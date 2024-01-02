<%--
  Created by IntelliJ IDEA.
  User: Prepress
  Date: 02.01.2024
  Time: 15:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cheating detected!</title>
</head>
<body>
<%
    Logger logger = LoggerFactory.getLogger(
            "cheating.jsp");
    logger.info("cheating.jsp is opened!");

%>

<jsp:include page="header.jsp" />

<center>
    <h1>Cheating detected! Грати в ігру можна тільки з самого початку!</h1>

    <h2>Була зареєстрована спроба грати не з самого початку! Пропонуємо Вам почати гру заново!</h2>

<hr>
<center>
    <form action="/" method="post">
        <input type="submit" value="Почати гру заново!">
    </form>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>
