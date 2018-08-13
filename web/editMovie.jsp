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
        <title>Edit Movies</title>
    </head>
    <body>
        <form class="form" action="TitleServlet" method="post">
            <h1>Edit for : ${movietoedit.name}</h1> <br>
            <label>Name</label> <input type="text" name="name" value="${movietoedit.name}"/>
            <label>Genre</label> <input type="text" name="genre" value="${movietoedit.genre}"/>
            <label>Year</label> <input type="text" name="year" value="${movietoedit.year}"/>
            <input type="hidden" name="method" value="editMovie"/>
            <input type="submit" value="Update"/>
            
        </form>
    <c:import url="/footer.jsp"/>
    </body>
</html>
