<%--
  Created by IntelliJ IDEA.
  User: Paul
  Date: 28.11.2023
  Time: 04:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="org.slf4j.Logger" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="static ufo.AppContent.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History of the game</title>
</head>
<body>
<%
  Logger logger = LoggerFactory.getLogger(
          "history.jsp");
  logger.info("history.jsp is opened!");
  session.setAttribute("markerFromStartToFinish", LOSE_PAGE);
%>

<jsp:include page="header.jsp" />

<center>
<h1>Історія гри:</h1>

  <h2>Lorem Ipsum</h2>
<i> "Neque porro quisquam est qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit..."
  <p>"There is no one who loves pain itself, who seeks after it and wants to have it, simply because it is pain..."
  </i>
</center>
  <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. In ac ultrices metus, vitae pharetra massa. Suspendisse maximus varius nunc quis iaculis. Suspendisse ultrices massa quis porttitor sollicitudin. Quisque convallis eu risus id euismod. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras ultricies augue id mattis laoreet. Ut lectus mauris, facilisis a eleifend eget, auctor eu purus. Nullam enim massa, commodo eget velit at, aliquam ultricies ipsum. Mauris non orci at ex rutrum luctus. Maecenas posuere urna at metus efficitur, ut blandit elit sodales. Integer id pharetra nulla. Mauris rhoncus lacus vitae hendrerit tincidunt.
  <p>Quisque faucibus mattis eros. Nam fermentum fringilla lorem. Sed sed laoreet lectus. Duis quam leo, tempor eu turpis vel, bibendum bibendum orci. Ut pharetra feugiat tincidunt. Proin sit amet mollis libero. Aliquam non ipsum lacus.
  <p>Donec augue lectus, faucibus eu molestie ac, rutrum sit amet ipsum. Aenean porta lorem ut molestie fringilla. Suspendisse ullamcorper arcu non libero vulputate tristique. Quisque placerat turpis vitae nulla scelerisque luctus. Morbi rhoncus dolor in mi dignissim tristique. Aenean enim tellus, accumsan in neque id, sollicitudin consectetur velit. Donec bibendum volutpat accumsan. Maecenas gravida rhoncus quam, ut pretium sapien dapibus eu. Pellentesque ultrices erat ut nisl blandit iaculis. Maecenas interdum ac nunc sed congue.
  <p>Sed eros lorem, viverra ac tincidunt et, rhoncus ut nibh. Vivamus at sem vitae purus fringilla accumsan quis sed odio. Etiam tempus malesuada ipsum a tincidunt. Vivamus ultricies, augue consequat vulputate rhoncus, ligula mi sollicitudin tellus, quis viverra odio purus nec turpis. Integer ut justo id tortor cursus aliquet a auctor justo. Quisque consequat quam sit amet dolor tincidunt, sed mollis felis tincidunt. Vivamus venenatis posuere justo faucibus finibus. Etiam pulvinar sem cursus, mattis ipsum et, vulputate nisi. Fusce suscipit mi quam. Vivamus lobortis nulla nunc. Fusce ut leo in erat interdum elementum. Etiam mattis, lectus sed luctus tempus, nibh urna ullamcorper lacus, eget dapibus felis felis quis elit.
  <p>Aenean at laoreet nulla, eget mattis eros. Phasellus viverra, massa dapibus interdum vehicula, orci lectus efficitur ipsum, vel imperdiet neque massa quis velit. Sed et scelerisque urna. Pellentesque vel commodo magna, in posuere odio. Mauris id feugiat leo, vitae fermentum leo. Proin felis felis, efficitur non tortor at, malesuada varius massa. Aliquam faucibus, augue ut rhoncus scelerisque, ex dolor porta justo, molestie sagittis nibh neque ut tellus. Morbi lacinia ligula eu leo molestie, at rutrum metus efficitur. Duis at efficitur nibh, non molestie metus. Aliquam dui augue, placerat vitae laoreet et, blandit non enim. Donec iaculis venenatis posuere. Proin ut aliquet justo, sit amet ultrices tortor. Ut elementum erat ac nisl interdum, eu placerat tortor sagittis. Donec mi ligula, fermentum a felis quis, gravida ullamcorper libero. Donec at maximus justo. Sed egestas elementum odio, et aliquam neque porta ac.

  <hr>
  <center>
<form action="/" method="post">
  <input type="submit" value="Почати гру заново!">
</form>
</center>
<jsp:include page="footer.jsp" />
</body>
</html>
