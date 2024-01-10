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
import java.util.Optional;

import static ufo.Constants.*;

@WebServlet("/accept-challenge")
public class AcceptChallengeServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            AcceptChallengeServlet.class);
    private final AcceptChallengeService acceptChallengeService = new AcceptChallengeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder infoForLogger = new StringBuilder();
        boolean answerIfAcceptChallenge = Boolean.parseBoolean(req.getParameter("answer"));
        Answer answer = acceptChallengeService.getAnswer(answerIfAcceptChallenge);

        HttpSession session = req.getSession();
        session.setAttribute("markerFromStartToFinish", LOSE_PAGE);

        if (answerIfAcceptChallenge) {
            session.setAttribute("markerFromStartToFinish", ACCEPT_CHALLENGE_ACCEPTED);
        } else {
            Integer gameCounter = Optional.ofNullable((Integer)session.getAttribute("gameCounter")).orElse(0);
            session.setAttribute("gameCounter", ++gameCounter);
            infoForLogger.append("gameCounter: " + gameCounter + ". ");
        }

        resp.setStatus(200);
        req.setAttribute("answer", answer.getMessage());

        infoForLogger.append("Answer was received. Message: ")
                .append(answer.getMessage())
                .append("; forwarding to page: ")
                .append(answer.getPage())
                .append("; status was set: 200.");
        LOGGER.info(infoForLogger.toString());

        req.getRequestDispatcher(answer.getPage()).forward(req, resp);
    }
}