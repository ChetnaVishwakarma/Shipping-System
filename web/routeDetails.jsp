<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<html>
    <head>
        <style>
            body{
                color:blue;
            }
            
        </style>
         <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
  <%      	
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
		Statement statement = connection.createStatement() ;
                ResultSet rs1= statement.executeQuery("select * from routes");
                PreparedStatement ps=connection.prepareStatement("select p.pName from port as p, routeDetails as rd where p.portID=rd.portId and rd.rId=?");
                %>
		<form action="plc.jsp">
                    
                
                    Available route names along with its ports are given<br/>
                    Choose a route:- <br/>
                    <%while(rs1.next())
                    {
                    %><br/><br/>
                    
                    <input type="radio" name="rId" value="<%= rs1.getInt(1)%>" />Route Name: <%= rs1.getString("rName")%>  Ports:
                    
                    <%
                
                    int rid=rs1.getInt(1);
                    ps.setInt(1,rid);
                    ResultSet rs2=ps.executeQuery();
                    while(rs2.next())
                        { %>
                        <%=rs2.getString("pName") %>;
                       <% }}   %>
                       <br/>
                       <input type="submit" name="submit" value="Select"/>
                       </form>
                       <a href="index_2.html"><button>Home Page</button></a>
          
  </body>
</html>