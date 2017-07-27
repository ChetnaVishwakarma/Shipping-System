<%-- 
    Document   : selectPort
    Created on : Oct 22, 2016, 12:16:01 AM
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
        <title>Discharge</title>
    </head>
    <body>
        <h1></h1>
        <% 
            int shipId=Integer.parseInt(request.getParameter("id"));
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps1=con.prepareStatement("select rId from ship where shipId=?");
            PreparedStatement ps=con.prepareStatement("select pName,port.portId from routeDetails,port where rId=? and routeDetails.portId=port.portId");
            PreparedStatement ps2=con.prepareStatement("select * from loads where shipId=?");
            
            ps1.setInt(1,shipId);
            ResultSet s=ps1.executeQuery();
            s.next();
            int rid=s.getInt(1);
            
            ps.setInt(1,rid);
            ResultSet p=ps.executeQuery();
            
            ps2.setInt(1,shipId);
            ResultSet c=ps2.executeQuery();
        
        %>
        <form action="./discharge" method="post">
            Ship id: <input type="number" name="shipId" value="<%= shipId %>" readonly/><br/><br/>
            Select Port: <select name="pId">
                <% while(p.next())
                    {%>
                    <option value="<%=p.getInt("portId")%>"><%= p.getString("pName")%></option>
                    <% }%>
            </select><br/><br/>
            Select Container:<select name="coId">
                <% while(c.next())
                    {%>
                    <option value="<%=c.getInt("coId")%>"> <%= c.getInt("coId")%> </option>
                    <% }%>
            </select>
                    <input type="submit" value="Discharge" name="submit"/>
        </form>
            
    </body>
</html>
