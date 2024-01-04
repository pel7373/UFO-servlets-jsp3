package ufo.web;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static ufo.Constants.*;

class ClimbCaptainBridgeServletTest extends Mockito {
    HttpServletRequest request = spy(HttpServletRequest.class);
    HttpServletResponse response = spy(HttpServletResponse.class);
    HttpSession session = spy(HttpSession.class);
    RequestDispatcher requestDispatcher = spy(RequestDispatcher.class);
    ServletContext context = spy(ServletContext.class);

    @Test
    public void doPostAnswerTrueTest() throws ServletException, IOException {
        String expectedAnswer = "true";
        String expectedNextPage = CLIMB_CAPTAIN_BRIDGE_NEXT_PAGE;
        String expectedAnswerInResponse = CLIMB_CAPTAIN_BRIDGE_ACCEPTED;

        when(request.getParameter("answer")).thenReturn(expectedAnswer);
        when(request.getServletContext()).thenReturn(context);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("markerFromStartToFinish")).thenReturn(ACCEPT_CHALLENGE_ACCEPTED);
        when(request.getRequestDispatcher(expectedNextPage)).thenReturn(requestDispatcher);

        new ClimbCaptainBridgeServlet().doPost(request, response);
        verify(requestDispatcher).forward(request, response);
        verify(request, times(1)).getParameter("answer");
        verify(request, times(1)).setAttribute("answer", expectedAnswerInResponse);
        verify(response, times(1)).setStatus(200);
    }

    @Test
    public void doPostAnswerFalseTest() throws ServletException, IOException {
        String expectedAnswer = "false";
        String expectedNextPage = LOSE_PAGE;
        String expectedAnswerInResponse = CLIMB_CAPTAIN_BRIDGE_NOT_ACCEPTED;

        when(request.getParameter("answer")).thenReturn(expectedAnswer);
        when(request.getServletContext()).thenReturn(context);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("markerFromStartToFinish")).thenReturn(ACCEPT_CHALLENGE_ACCEPTED);
        when(request.getRequestDispatcher(expectedNextPage)).thenReturn(requestDispatcher);

        new ClimbCaptainBridgeServlet().doPost(request, response);
        verify(requestDispatcher).forward(request, response);
        verify(request, times(1)).getParameter("answer");
        verify(request, times(1)).setAttribute("answer", expectedAnswerInResponse);
        verify(response, times(1)).setStatus(200);
    }

    @Test
    public void doPostAnswerAnyTest() throws ServletException, IOException {
        String expectedAnswer = "aaa111";
        String expectedNextPage = LOSE_PAGE;
        String expectedAnswerInResponse = CLIMB_CAPTAIN_BRIDGE_NOT_ACCEPTED;

        when(request.getParameter("answer")).thenReturn(expectedAnswer);
        when(request.getServletContext()).thenReturn(context);
        when(request.getSession()).thenReturn(session);
        when(session.getAttribute("markerFromStartToFinish")).thenReturn(ACCEPT_CHALLENGE_ACCEPTED);
        when(request.getRequestDispatcher(expectedNextPage)).thenReturn(requestDispatcher);

        new ClimbCaptainBridgeServlet().doPost(request, response);
        verify(requestDispatcher).forward(request, response);
        verify(request, times(1)).getParameter("answer");
        verify(request, times(1)).setAttribute("answer", expectedAnswerInResponse);
        verify(response, times(1)).setStatus(200);
    }

}