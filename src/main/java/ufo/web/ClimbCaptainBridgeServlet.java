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

import static ufo.Constants.*;

@WebServlet("/climbCaptainBridgeServlet")
public class ClimbCaptainBridgeServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            ClimbCaptainBridgeServlet.class);
    private final ClimbCaptainBridgeService climbCaptainBridgeService = new ClimbCaptainBridgeService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        boolean answerIfClimbCaptainBridge = Boolean.parseBoolean(req.getParameter("answer"));
        Answer answer = climbCaptainBridgeService.call(answerIfClimbCaptainBridge);
        HttpSession session = req.getSession();
        String markerFromStartToFinish = (String) session.getAttribute("markerFromStartToFinish");

        session.setAttribute("markerFromStartToFinish", LOSE_PAGE);

        if (!markerFromStartToFinish.equals(ACCEPT_CHALLENGE_ACCEPTED)) {
            sb.append("Cheating was detected")
                    .append("; forwarding to CHEATING_PAGE: ")
                    .append(CHEATING_PAGE);
            LOGGER.info(sb.toString());

            req.getRequestDispatcher(CHEATING_PAGE).forward(req, resp);
            return;
        }

        if (answerIfClimbCaptainBridge) {
            session.setAttribute("markerFromStartToFinish", CLIMB_CAPTAIN_BRIDGE_ACCEPTED);
        } else {
            Integer total = (Integer) session.getAttribute("total");
            if (total == null) {
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
