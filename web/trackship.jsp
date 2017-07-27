<%-- 
    Document   : trackship
    Created on : Oct 19, 2016, 12:13:02 AM
    Author     : dashmeetkaur
--%>

<%@page import="java.sql.*"%>
<%@page import="shipping.ConnectionProvider"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="style.css"/>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Track Ship</title>
    </head>
    <body>
        <% 
            Connection con=ConnectionProvider.getCon();
            Statement smt=con.createStatement();
            String sql="select shipId from ship";
            ResultSet rs=smt.executeQuery(sql);
            
        %>
        <h1>Track Ship</h1>
        <form action="./trackShips" method="post">
            Choose Ship Id to track: <select name="shipId" required>
            <% while(rs.next())
            { %>
            <option value="<%= rs.getInt(1) %>"><%= rs.getInt(1) %></option> <%}%>
        </select>
            <input type="submit" value="Track" name="Track"/>
        </form>
        <br/><br/>
        <button onclick='history.go(-1)'>Back</button>
    </body>
</html>
