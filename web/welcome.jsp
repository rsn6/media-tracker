<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="/mediatracker/resource/styles/bootstrap.min.css">
        <link rel="stylesheet" href="/mediatracker/resource/styles/app.css">
        <script src="/mediatracker/resource/js/jquery.min.js"></script>
        <script src="/mediatracker/resource/js/popper.min.js"></script>
        <script src="/mediatracker/resource/js/bootstrap.min.js"></script>     
        
        <title>Welcome</title>
    </head>
    <body>
    <center><h1>Welcome ${user.firstname}</h1></center>
    <center><a href="/mediatracker/TitleServlet">
        <img src="film.jpg" alt="Film picture" id="welcome">
    </a>
        <p>Go To Media</p>

    </center>
        <c:import url="/footer.jsp"/>
    </body>
</html>
