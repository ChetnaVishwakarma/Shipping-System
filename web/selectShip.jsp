<%-- 
    Document   : discharge
    Created on : Oct 21, 2016, 11:21:17 PM
    Author     : dashmeetkaur
--%>

<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8" import="shipping.ConnectionProvider"%>
<!DOCTYPE html>
<html>
    <head>
         <link type="text/css" rel="stylesheet" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Select ship</title>
    </head>
    <body>
        <% Connection con=ConnectionProvider.getCon(); 
           String sql="select * from loads";
           Statement smt=con.createStatement();
           ResultSet r=smt.executeQuery(sql);
           
        %>
        <h1>Discharge Containers</h1>
        <form action="selectport.jsp" method="post">
            Choose Ship Id: <select name="id">
                <% while(r.next())
                {
                %>
                
                <option><%= r.getInt("shipId") %> </option>
                
                <% } %>
            </select> 
            <input type="submit" name="submit" value="Go to select container"/>
        </form>
        <a href="home.jsp"><button>Back</button></a><br/>
    </body>
</html>
