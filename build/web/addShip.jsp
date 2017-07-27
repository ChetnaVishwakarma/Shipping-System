<%-- 
    Document   : addShip
    Created on : Oct 18, 2016, 1:56:12 PM
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
        <title>Add Ship</title>
    </head>
    <body>
        <%
           Connection con=ConnectionProvider.getCon();
           String s1="select * from shippingLine";
           String s2="select * from routes";
           PreparedStatement ps1=con.prepareStatement(s1);
           PreparedStatement ps2=con.prepareStatement(s2);
           ResultSet rl=ps1.executeQuery();
           ResultSet r=ps2.executeQuery();
           
        %>
        <h1>Add Ship</h1>
        
        
        <form action="./addShips" method="post">
            Enter Ship Name: <input type="text" name="shipName" required/><br/><br/>
            Enter Type: <select name="type">
                <option value="Container">Container</option>
                <option value="Bulk">Bulk</option>
                <option value="RoRo">RoRo</option>
            </select><br/><br/>
            Enter number of Containers: <input type="number" name="noOfContainers" required/><br/><br/>
            Enter slot available: <input type="number" name="slotAvailable" required/><br/><br/>
            Enter Ship Line : <select name="shipLineId" required>
                <% rl.beforeFirst();
                    while(rl.next())
                { %>
                <option value="<%= rl.getInt("shipLineId") %>"> <%= rl.getString("shipLineName") %></option>
                <% }%>
                </select><br/><br/>
            Enter Route : <select name="rId" required>
                <%  r.beforeFirst();
                    while(r.next())
                { %>
                <option value="<%= r.getInt("rId") %>"> <%= r.getString("rName") %></option>
                <% }%>
                </select><br/><br/>
            <input type="submit" name="submit" value="Add Ship"/><br/><br/>
            
        </form><br/>
        <a href="home.jsp"><button>Back</button></a><br/>
        
    </body>
</html>
