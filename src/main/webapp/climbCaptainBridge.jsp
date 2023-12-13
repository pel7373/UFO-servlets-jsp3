<%--
  Created by IntelliJ IDEA.
  User: Prepress
  Date: 21.11.2023
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="static ufo.AppContent.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Climb to the captain's bridge</title>
</head>
<body>
<jsp:include page="header.jsp" />

<center>
    <%
        Logger logger = LoggerFactory.getLogger(
                "climbCaptainBridge.jsp");
        logger.info("climbCaptainBridge.jsp is opened!");

        String message = (String)request.getAttribute("answer");

        session = request.getSession();
        String markerFromStartToFinish = (String) session.getAttribute("markerFromStartToFinish");
        if(markerFromStartToFinish.equals(STEP_0_ACCEPTED)) {
            markerFromStartToFinish = STEP_1_ACCEPTED;
            session.setAttribute("markerFromStartToFinish", STEP_1_ACCEPTED);
        }
    %>
    <%= message %>

    <h1>Піднятися на капітанський місток?</h1>
    <form action="/ufo01" method="post">

        <input type="radio" name="answer" value="true">Так<br>
        <input type="radio" name="answer" value="false">Ні<br>
        <input type="submit" value="Ок">

    </form>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>
