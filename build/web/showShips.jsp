<%-- 
    Document   : showShips
    Created on : Oct 22, 2016, 1:05:15 AM
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
        <title>Existing Ships</title>
    </head>
    <body>
        <h1>Existing Ships</h1>
        <% 
            Connection con=ConnectionProvider.getCon();
            Statement smt=con.createStatement();
            String sql="select * from ship natural join routes";
            ResultSet ship=smt.executeQuery(sql);
            if(!ship.next())
            {
                out.print("No ships exsits!!");
            }
            else
            {
                ship.beforeFirst();
                %>
                <table border="1" cellspacing="3px" cellpadding="3px">
                    <tr>
                           
                    <th> Ship ID</th>
                    <th> Ship Name</th>
                    <th> Type </th>
                    <th> No of Containers</th>
                    <th> Slot Availability</th>
                    <th> Ship Line Id</th>
                    <th> Route Name</th>
                    </tr> 
                    <% 
                while(ship.next())
                { %> <tr>
                 
                <td><%= ship.getInt("shipId") %></td>
                <td><%= ship.getString("shipName") %></td>
                <td><%= ship.getString("type") %></td>
                <td><%= ship.getInt("noOfContainers") %></td>
                <td><%= ship.getString("slotAvailability") %></td>
                <td><%= ship.getInt("shipLineId") %></td>
                <td><%= ship.getString("rName") %></td>
                </tr>
                <% }} %>
            
             </table>
                <a href="home.jsp">Back</a>
    </body>
</html>
