package ufo.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static ufo.Constants.*;

@WebServlet("/history")
public class HistoryServlet extends HttpServlet {
    private static final Logger LOGGER = LoggerFactory.getLogger(
            HistoryServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder infoForLogger = new StringBuilder();

        HttpSession session = req.getSession();
        session.setAttribute("markerFromStartToFinish", LOSE_PAGE);

        infoForLogger.append("HistoryServlet has worked")
                .append("; forwarding to HISTORY_PAGE: " + HISTORY_PAGE);
        LOGGER.info(infoForLogger.toString());

        req.getRequestDispatcher(HISTORY_PAGE).forward(req, resp);
    }
}
