<%-- 
    Document   : addContainer
    Created on : Oct 18, 2016, 2:03:53 PM
    Author     : dashmeetkaur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Container</title>
    </head>
    <body>
        <h1>Add Container</h1><br/><br/>
        <form action="./addContainers" method="post">
            Enter Type:
            <select name="type">
                <option value="open top">open top</option>
                <option value="dry">dry</option>
                <option value="refrigerated">refrigerated</option>
            </select><br/><br/>
            Enter Size: <input type="number" name="size" required/><br/> <br/>
            Enter Capacity(in tons): <input type="number" name="capacity" required/><br/><br/> 
            Enter Price: <input type="number" name="price" required/><br/> <br/>
            <input type="submit" name="submit" value="submit"/>
         </form>
        <br/><br/>
        <button onclick="history.go(-1)">Back</button>
    </body>
</html>
