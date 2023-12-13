<%--
  Created by IntelliJ IDEA.
  User: Prepress
  Date: 21.11.2023
  Time: 14:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="static ufo.AppContent.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Who are you?</title>
</head>
<body>
<jsp:include page="header.jsp" />

<center>
    <%
        Logger logger = LoggerFactory.getLogger(
                "whoAreYou.jsp");
        logger.info("whoAreYou.jsp is opened!");
        String message = (String)request.getAttribute("answer");

        session = request.getSession();
        String markerFromStartToFinish = (String) session.getAttribute("markerFromStartToFinish");
        if(markerFromStartToFinish.equals(STEP_1_ACCEPTED)) {
            markerFromStartToFinish = STEP_2_ACCEPTED;
            session.setAttribute("markerFromStartToFinish", markerFromStartToFinish);
        }
    %>
    <%= message %>

    <h1>Хто ви?</h1>
    <form action="/ufo02" method="post">

        <input type="radio" name="answer" value="true">Розповісти правду про себе<br>
        <input type="radio" name="answer" value="false">Збрехати про себе<br>
        <input type="submit" value="Ок">

    </form>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>
