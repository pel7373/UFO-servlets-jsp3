<%--
  Created by IntelliJ IDEA.
  User: Prepress
  Date: 21.11.2023
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="static ufo.AppContent.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Page 03: You are won! Congratulations!</title>
</head>
<body>
<jsp:include page="header.jsp" />

<center>
<%
    Logger logger = LoggerFactory.getLogger(
            "youWon.jsp");
    logger.info("youWon.jsp is opened!");
    String message = (String)request.getAttribute("answer");

    session = request.getSession();
    String markerFromStartToFinish = (String) session.getAttribute("markerFromStartToFinish");
    if(markerFromStartToFinish.equals(STEP_2_ACCEPTED)) {
        Integer won = (Integer) session.getAttribute("won");
        Integer total = (Integer) session.getAttribute("total");
        total++;
        if(won != null) {
            won++;
        } else {
            won = 1;
        }
        session.setAttribute("won", won);
        session.setAttribute("total", total);
        session.setAttribute("markerFromStartToFinish", LOSE_PAGE);
    }
%>
        <%= message %>

    <h1>Ви виграли! Вітаємо! Ура, перемога!</h1>
<form action="/" method="post">
    <input type="submit" value="Почати гру заново!">
</form>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>
