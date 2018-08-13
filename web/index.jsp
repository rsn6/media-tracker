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
        <title>Media Page</title>
    </head>
    <body id="index-bg">
        <div class="container-fluid">
            <c:import url="/header.jsp"/>
            <center><h1>Your Media</h1></center>
            
       <center>
        <label>Add TV Show</label>
        <form class ="form" action="TitleServlet" method="post">
            <label>Name</label> <input type="text" name="name" value="${tvtitle.name}"/>
            <label>Genre</label> <input type="text" name="genre" value="${tvtitle.genre}"/>
            <label>Year</label> <input type="text" name="year" value="${tvtitle.year}"/>
            <input type="hidden" name="name" value="${tvtitle.name}"/>
            <input type="hidden" name="genre" value="${tvtitle.genre}"/>
            <input type="hidden" name="year" value="${tvtitle.year}"/>
            <input type="hidden" name="method" value="addTVTitle"/>
            <input type="submit" value="Add TV Show"/>
        </form>
        <br>
        <br>
        <label>Add Movie</label>
        <form class ="form" action="TitleServlet" method="post">
            <label>Name</label> <input type="text" name="name" value="${movietitle.name}"/>
            <label>Genre</label> <input type="text" name="genre" value="${movietitle.genre}"/>
            <label>Year</label> <input type="text" name="year" value="${movietitle.year}"/>
            <input type="hidden" name="name" value="${movietitle.name}"/>
            <input type="hidden" name="genre" value="${movietitle.genre}"/>
            <input type="hidden" name="year" value="${movietitle.year}"/>
            <input type="hidden" name="method" value="addMovieTitle"/>
            <input type="submit" value="Add Movie"/>
        </form>
       </center>
            
        <table class ="table table-hover">
            <tr>
                <th>TV Show Names</th>
                <th>Genre</th>
                <th>Year</th>
                <th></th>
            </tr>
            <c:forEach var="tvtitle" items="${tvtitles}">
                <tr>
                    <td><c:out value="${tvtitle.name}"/></td>
                    <td><c:out value="${tvtitle.genre}"/></td>
                    <td><c:out value="${tvtitle.year}"/></td>
                    <td>
                        <form action="TitleServlet" method="post">
                            <input type="hidden" name="name" value="${tvtitle.name}"/>
                            <input type="hidden" name="genre" value="${tvtitle.genre}"/>
                            <input type="hidden" name="year" value="${tvtitle.year}"/>
                            <input type="hidden" name="method" value="showEditTVForm"/>
                            <input type="submit" value="Edit"/>
                        </form>
                        
                        <form action="TitleServlet" method="post">
                            <input type="hidden" name ="name" value="${tvtitle.name}"/>
                            <input type="hidden" name="method" value="deleteTVTitle"/>
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <th>Movie Names</th><br>
                <th>Genre</th>
                <th>Year</th>
                <th></th>
            </tr>
            <c:forEach var="movietitle" items="${movietitles}">
                <tr>
                    <td><c:out value="${movietitle.name}"/></td>
                    <td><c:out value="${movietitle.genre}"/></td>
                    <td><c:out value="${movietitle.year}"/></td>
                    <td>
                        <form action="TitleServlet" method="post">
                            <input type="hidden" name="name" value="${movietitle.name}"/>
                            <input type="hidden" name="genre" value="${movietitle.genre}"/>
                            <input type="hidden" name="year" value="${movietitle.year}"/>
                            <input type="hidden" name="method" value="showEditMovieForm"/>
                            <input type="submit" value="Edit"/>
                        </form>
                        
                        <form action="TitleServlet" method="post">
                            <input type="hidden" name ="name" value="${movietitle.name}"/>
                            <input type="hidden" name="method" value="deleteMovieTitle"/>
                            <input type="submit" value="Delete"/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
         <c:import url="/footer.jsp"/>
        </div>
    </body>
</html>
