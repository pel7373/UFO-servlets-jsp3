<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<center>
    <hr>
    <%
        session = request.getSession();
        Integer gameCounter = (Integer) session.getAttribute("gameCounter");
        if(gameCounter == null) {
            gameCounter = 0;
        }

        Integer counterOfWonGames = (Integer) session.getAttribute("counterOfWonGames");
        if(counterOfWonGames == null) {
            counterOfWonGames = 0;
        }
    %>
    Загальна кількість зіграних ігор у цій сесії: <b><%= gameCounter%></b>; кількість виграних ігор у цій сесії: <b><%= counterOfWonGames %></b>

</center>
