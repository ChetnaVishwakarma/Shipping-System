<%-- 
    Document   : consigneeTrackOrder
    Created on : Oct 21, 2016, 3:42:22 PM
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
        <title>Track Order</title>
    </head>
    <body>
        <% 
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("select * from orders where cId=?");
            int id=Integer.parseInt(session.getAttribute("cId").toString());
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(!rs.next())
            {
                %> No orders to track <%
            }
            else
            {
                rs.beforeFirst();
            %>
        <h1>Track Order</h1>
        <form action="./trackorders" method="post">
            Choose order id: <select name="oId" required>
            <% while(rs.next()) 
            { %>
            <option value="<%= rs.getInt("oId")%>"><%= rs.getInt("oId") %></option>
            <%    
            } %>
            </select>
            <input type="submit" value="Track" name="Track"/>
        </form>
         <% } %>
    </body>
</html>
