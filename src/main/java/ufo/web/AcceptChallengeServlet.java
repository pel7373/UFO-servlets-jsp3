package ufo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ufo.AcceptChallengeService;
import ufo.answers.Answer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ufo.Constants.*;

@WebServlet("/acceptChallenge")
public class AcceptChallengeServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            AcceptChallengeServlet.class);
    private final AcceptChallengeService acceptChallengeService = new AcceptChallengeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        HttpSession session = req.getSession();

        boolean answerIfAcceptChallenge = Boolean.parseBoolean(req.getParameter("answer"));
        Answer answer = acceptChallengeService.call(answerIfAcceptChallenge);

        if(answerIfAcceptChallenge) {
            session.setAttribute("markerFromStartToFinish", ACCEPT_CHALLENGE_ACCEPTED);
        } else {
            Integer total = (Integer) session.getAttribute("total");
            if(total == null) {
                total = 0;
            }
            total++;
            session.setAttribute("total", total);
        }

        resp.setStatus(200);
        req.setAttribute("answer", answer.getMessage());

        sb.append("Answer was received. Message: ")
                .append(answer.getMessage())
                .append("; forwarding to page: ")
                .append(answer.getPage())
                .append("; status was set: 200.");
        LOGGER.info(sb.toString());

        req.getRequestDispatcher(answer.getPage()).forward(req, resp);
        }

}