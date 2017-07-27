<%-- 
    Document   : adminLogin
    Created on : Oct 21, 2016, 2:10:29 PM
    Author     : dashmeetkaur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <link type="text/css" rel="stylesheet" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Login</title>
    </head>
    <body>
        <h1>Admin Login</h1>
        <form action="./adLogin" method="post">
            ShipLine Id:<input type="number" name="slId" required/><br><br>
            Password: <input type="password" name="pwd" required/><br><br>
            <input type="submit" value="submit">
            <a href="home.html"><button>Home Page</button></a>
        </form>
    </body>
</html>
