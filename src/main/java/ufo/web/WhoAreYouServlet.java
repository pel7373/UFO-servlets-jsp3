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

@WebServlet("/whoAreYouServlet")
public class WhoAreYouServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            WhoAreYouServlet.class);
    private final WhoAreYouService whoAreYouService = new WhoAreYouService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder sb = new StringBuilder();
        boolean answerWhoAreYou = Boolean.parseBoolean(req.getParameter("answer"));
        Answer answer = whoAreYouService.call(answerWhoAreYou);
        HttpSession session = req.getSession();
        String markerFromStartToFinish = (String) session.getAttribute("markerFromStartToFinish");
        session.setAttribute("markerFromStartToFinish", LOSE_PAGE);

        if (!markerFromStartToFinish.equals(CLIMB_CAPTAIN_BRIDGE_ACCEPTED)) {
            LOGGER.info(LOGGING_OF_CHEATING);
            req.getRequestDispatcher(CHEATING_PAGE).forward(req, resp);
            return;
        }

        Integer gameCounter = Optional.ofNullable((Integer)session.getAttribute("gameCounter")).orElse(0);
        session.setAttribute("gameCounter", ++gameCounter);

        if (answerWhoAreYou) {
            Integer counterOfWonGames  = Optional.ofNullable((Integer)session.getAttribute("counterOfWonGames")).orElse(0);
            session.setAttribute("counterOfWonGames", ++counterOfWonGames );
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
