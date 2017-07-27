<%-- 
    Document   : showContainers
    Created on : Oct 22, 2016, 1:25:44 AM
    Author     : dashmeetkaur
--%>

<%@page import="shipping.ConnectionProvider"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="style.css"/>
       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Containers</title>
    </head>
    <body>
        <h1>Existing Containers</h1>
        <% 
            Connection con=ConnectionProvider.getCon();
            Statement smt=con.createStatement();
            String sql="select * from container";
            ResultSet co=smt.executeQuery(sql);
            if(!co.next())
            {
                out.print("No container!!");
            }
            else
            {
                co.beforeFirst();
                %>
                <table border="1" cellspacing="3px" cellpadding="3px">
                    <tr>
                    <th> Container ID</th>
                    <th> Type </th>
                    <th> Size</th>
                    <th> Capacity</th>
                    <th> Status</th>
                    <th> Price(in Rs)</th>
                    </tr> 
                    <% 
                while(co.next())
                { %> <tr>
                <td><%= co.getInt("coId") %></td>
                <td><%= co.getString("type") %></td>
                <td><%= co.getInt("size") %></td>
                <td><%= co.getInt("capacity") %></td>
                <td><%= co.getString("status") %></td>
                <td><%= co.getInt("price") %></td>
                </tr>
                <% }} %>
            
             </table>
                <a href="home.jsp">Back</a>
    </body>
</html>
