<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="static ufo.Constants.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lose Page</title>
</head>
<body>
<jsp:include page="header.jsp" />

<center>
<%
    Logger logger = LoggerFactory.getLogger(
            "losePage.jsp");
    logger.info("losePage.jsp is opened!");

    String message = (String)request.getAttribute("answer");

    session = request.getSession();
    Integer total = (Integer) session.getAttribute("total");
    if(total == null) {
        total = 0;
    }
%>
<%= message %>
<h1>Ви програли!</h1>
<form action="/" method="post">
    <input type="submit" value="Почати гру заново!">
</form>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>