<%-- 
    Document   : showRoutes
    Created on : Oct 22, 2016, 1:37:54 AM
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
        <title>Routes</title>
    </head>
    <body>
        <h1>Routes</h1>
       <% Connection con=ConnectionProvider.getCon();
            Statement smt=con.createStatement();
            String sql="select * from routes";
            String sql1="select port.pName from port,routeDetails where port.portId=routeDetails.portId and rId=?";
            PreparedStatement ps1=con.prepareStatement(sql);
            PreparedStatement ps2=con.prepareStatement(sql1);
            ResultSet rd=ps1.executeQuery();
            
            
            
            if(!rd.next())
            {
                out.print("No routes exsits!!");
            }
            else
            {
                rd.beforeFirst();
                %>
                <table border="1" cellspacing="3px" cellpadding="3px">
                    <tr>
                    <th> Route ID</th>
                    <th> Route Name</th>
                    <th> Ports </th>
                    </tr> 
                    <% 
                    rd.beforeFirst();
                while(rd.next())
                { 
                    int rId=rd.getInt("rId");
                    ps2.setInt(1,rId);
                    ResultSet rp=ps2.executeQuery();
         
                    
                  %> <tr>
                <td><%= rd.getInt("routes.rId") %></td>
                <td><%= rd.getString("routes.rName") %></td>
                <td>  <%    rp.beforeFirst();
                            while(rp.next())
                    {   
                    out.print("-> "+rp.getString("pName")); %>
                   <%   
                    } %> </td>
                </tr>
                <%  } %> </table> <%
                
               }
                %>
                <a href="home.jsp">Back</a>
    </body>
</html>
