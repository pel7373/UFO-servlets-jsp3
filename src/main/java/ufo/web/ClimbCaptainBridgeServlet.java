package ufo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ufo.answers.Answer;
import ufo.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

import static ufo.Constants.*;

@WebServlet("/climb-captain-bridge")
public class ClimbCaptainBridgeServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            ClimbCaptainBridgeServlet.class);
    private final ClimbCaptainBridgeService climbCaptainBridgeService = new ClimbCaptainBridgeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder infoForLogger = new StringBuilder();
        boolean answerIfClimbCaptainBridge = Boolean.parseBoolean(req.getParameter("answer"));
        Answer answer = climbCaptainBridgeService.getAnswer(answerIfClimbCaptainBridge);
        HttpSession session = req.getSession();
        String markerFromStartToFinish = Optional.ofNullable((String) session.getAttribute("markerFromStartToFinish")).orElse(LOSE_PAGE);
        session.setAttribute("markerFromStartToFinish", LOSE_PAGE);

        if (!markerFromStartToFinish.equals(ACCEPT_CHALLENGE_ACCEPTED)) {
            LOGGER.info(LOGGING_OF_CHEATING);
            req.getRequestDispatcher(CHEATING_PAGE).forward(req, resp);
            return;
        }

        if (answerIfClimbCaptainBridge) {
            session.setAttribute("markerFromStartToFinish", CLIMB_CAPTAIN_BRIDGE_ACCEPTED);
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
