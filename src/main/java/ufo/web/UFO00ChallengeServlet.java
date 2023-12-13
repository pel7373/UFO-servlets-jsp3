package ufo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ufo.UFO00AcceptChallengeService;
import ufo.answers.UFOAnswer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ufo00")
public class UFO00ChallengeServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(
            UFO00ChallengeServlet.class);
    private final UFO00AcceptChallengeService uFO00AcceptChallengeService = new UFO00AcceptChallengeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        UFOAnswer answer = uFO00AcceptChallengeService.call(Boolean.parseBoolean(req.getParameter("answer")));

        resp.setStatus(200);
        req.setAttribute("answer", answer.getMessage());

        sb.append("Answer was received. Message: ")
                .append(answer.getMessage())
                .append("; forwarding to page: ")
                .append(answer.getPage())
                .append("; status was set: 200.");
        logger.info(sb.toString());

        req.getRequestDispatcher(answer.getPage()).forward(req, resp);
    }
}