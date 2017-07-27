<%-- 
    Document   : trackorder.jsp
    Created on : Oct 20, 2016, 4:12:48 PM
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
        <title>Track order</title>
    </head>
    <body>
        <% 
            Connection con=ConnectionProvider.getCon();
            String sql="select distinct oId from books";
            Statement smt=con.createStatement();
            ResultSet rs=smt.executeQuery(sql);
        %>
        <h1>Track order</h1>
        <form action="./trackorders" method="post">
            Enter order id: <select name="oId" required>
            <% while(rs.next())
            { %>
            <option value="<%= rs.getInt(1) %>"><%= rs.getInt(1) %> </option>
            <% }
            %>
            </select><br/><br/>
            <input type="submit" name="Track" value="Track"/>
            <button onclick="history.go(-1)">Back</button>
        </form> 
    </body>
</html>
