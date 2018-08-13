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
        <title>Sign up</title>
    </head>
    <body>
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-12 text-center">
                    <h1>Welcome to MediaTracker! Please signup or login below</h1>
                </div>
            </div>
        <form action="UserServlet" method="post">
            <center><i>${error}</i></center><br>
            <div class="row">
                <div class="col-md-12 text-center">
                    <input type="hidden" name="formtype" value="signup"/>
                    <label>First Name</label>
                </div>
                <div class="col-md-12 text-center">
                    <input type="text" name="firstname" required/><br>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <label>Last Name</label>
                    <div class="col-md-12 text-center">
                        <input type="text" name="lastname" required/><br>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <label>Email</label>
                    <div class="col-md-12 text-center">
                        <input type="email" name="email" required/><br>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <label>Password</label>
                </div>
                <div class="col-md-12 text-center">
                    <input type="password" name="password" required/><br>
                </div>
            </div>
                <div class="row">
                    <div class="col-md-12 text-center">
                    <input type="submit" value="Sign up"/>
                    </div>
                </div>
        </form>
            <div class="row">
                <div class="col-md-12 text-center">
                    <label>If you already have an account, </label>
                    <a href="/mediatracker/login.jsp">Login here</a>
                </div>
            </div>

        </div>
        <c:import url ="/footer.jsp"/>
    </body>
</html>
