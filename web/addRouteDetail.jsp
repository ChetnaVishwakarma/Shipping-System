<%-- 
    Document   : addRouteDetail
    Created on : Oct 18, 2016, 10:50:29 PM
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
        <title>Route Detail</title>
    </head>
    <body>
        <h1>Route Details</h1>
        <% String rName=request.getParameter("rName");
           int noOfStops= Integer.parseInt(request.getParameter("noOfStops"));
           
           int i=1;
           Connection con=ConnectionProvider.getCon();
           Statement smt=con.createStatement();
           String s1="select * from port";
           ResultSet rs=smt.executeQuery(s1);
           
           
           
        %>
        <form action="./addRoutes" method="post"> 
            Route Name: <input type="text" name="rName" value="<%= rName%>" readonly/><br/>
            No of Stops: <input type="number" name="noOfStops" value="<%= noOfStops%>" readonly/><br/>
            <% while(i<=noOfStops)
            { %> <br/><br/>
            Choose Port for stop no <%= i%>
            <select name="stop">
            <% rs.beforeFirst();
                while(rs.next())
                { %> 
                
                <option value="<%= rs.getInt("portId")%>"><%= rs.getString("pName")%></option>
                <% }
                %>
            </select>
            Choose Stop Days: <input type="number" name="days" required/>
            <% i++; } %>
            <input type="submit" name="Add" />
        </form>
            <button onclick="loaction.href='home.jsp'">Home</button>
    </body>
</html>
