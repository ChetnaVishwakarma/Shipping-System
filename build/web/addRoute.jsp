<%-- 
    Document   : addRoute
    Created on : Oct 18, 2016, 9:31:37 PM
    Author     : dashmeetkaur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Routes</title>
    </head>
    <body>
        <h1>Add Route</h1>
        <form   action="addRouteDetail.jsp" method="post">
            Enter Route Name:<input type="text" name="rName" required/><br/>
            Enter No of stops:<input type="number" name="noOfStops" required/><br/>
            <input type="submit" value="submit"/>
        </form>
        <a href="home.jsp"><button>Back</button></a><br/>
    </body>
</html>
