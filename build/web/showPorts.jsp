<%-- 
    Document   : showPorts
    Created on : Oct 22, 2016, 1:32:01 AM
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
        <title>Ports</title>
    </head>
    <body>
        <h1>Existing Ports</h1>
        <% Connection con=ConnectionProvider.getCon();
            Statement smt=con.createStatement();
            String sql="select * from port";
            ResultSet port=smt.executeQuery(sql);
            if(!port.next())
            {
                out.print("No ports exsits!!");
            }
            else
            {
                port.beforeFirst();
                %>
                <table border="1" cellspacing="3px" cellpadding="3px">
                    <tr>
                    <th> Port ID</th>
                    <th> Port Name</th>
                    <th> Charges(in Rs) </th>
                    </tr> 
                    <% 
                while(port.next())
                { %> <tr>
                <td><%= port.getInt("portId") %></td>
                <td><%= port.getString("pName") %></td>
                <td><%= port.getInt("charges") %></td>
                </tr>
                <% }} %>
            
             </table>
                <a href="home.jsp"><button>Back</button></a><br/>
    </body>
</html>
