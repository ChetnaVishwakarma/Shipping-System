<%-- 
    Document   : addPorts
    Created on : Oct 18, 2016, 2:10:34 PM
    Author     : dashmeetkaur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Ports</title>
    </head>
    <body>
        <h1>Add Ports</h1>
        <form action="./addPorts" method="post">
            Enter Port Name: <input type="text" name="pName" required/>
            Enter Charges: <input type="number" name="charges" required/>
            <input type="submit" name="submit" value="submit"/>
        </form>
        <br/><br/>
        <button onclick="history.go(-1)">Back</button>
    </body>
</html>
