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
        
        <title>Sign In</title>
    </head>
    <body>
        <div class="container-fluid">
            <form action="UserServlet" method="post">
                <center><i>${invalid}</i></center>
                    <br>
                <div class="row">
                    <div class="col-md-12 text-center">
                        <input type="hidden" name="formtype" value="login"/>
                            <label>Email</label>
                    </div>
                    <div class="col-md-12 text-center">
                        <input type="email" name="email" required/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                        <label>Password</label>
                    </div>
                    <div class="col-md-12 text-center">
                        <input type="password" name="password" required/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                        <input type="submit" value="Sign in"/>
                    </div>
                </div>
            </form>
        </div>
        <c:import url="/footer.jsp"/>
    </body>
</html>
