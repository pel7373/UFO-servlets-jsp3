<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<center>
    <hr>
    <%
        session = request.getSession();
        Integer total = (Integer) session.getAttribute("total");
        if(total == null) {
            total = 0;
            session.setAttribute("total", 0);
        }

        Integer won = (Integer) session.getAttribute("won");
        if(won == null) {
            won = 0;
            session.setAttribute("won", 0);
        }

    %>
    Загальна кількість зіграних ігор у цій сесії: <b><%= total%></b>; кількість виграних ігор у цій сесії: <b><%= won %></b>

</center>
