<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Start Page</title>
</head>
<body>

<%
    Logger logger = LoggerFactory.getLogger(
            "index.jsp");
    logger.info("index.jsp is opened!");
%>

<jsp:include page="header.jsp" />

<center>
<h1>Ви втрачаєте пам'ять! Прийняти виклик НЛО?</h1>
<form action="/accept-challenge" method="post">
    <input type="radio" name="answer" value="true">Прийняти виклик<br>
    <input type="radio" name="answer" value="false">Відхилити виклик<br>
    <input type="submit" value="Ок">
</form>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>