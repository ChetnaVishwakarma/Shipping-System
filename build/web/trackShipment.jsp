<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.mysql.jdbc.Driver.*" %>

<html>
    <head><link type="text/css" rel="stylesheet" href="style.css"/>
       </head>
<body>
<table>

<tr>
	<th>
		Order 
	</th>
</tr>
<tr>
	<td> Order id </td>
	<td> Ship id</td>
	<td> Container id</td>
	
	<td> Last port id</td>
	<td> Next port id</td>
	<td> Status</td>
	
</tr>
<tr> 
<%
try
{
		
	int oid=Integer.parseInt(request.getParameter("oid"));
	int shipid,coid,lpid,dpid;
	%><td><%=oid %></td><%
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
    Statement statement = connection.createStatement() ;
    PreparedStatement ps = connection.prepareStatement(" select shipId,b.coId from books as b,loads as d where oid=? b.coId=d.coId");
	ps.setInt(1,oid);
	ResultSet rs1=ps.executeQuery();
	PreparedStatement ps2 = connection.prepareStatement(" select * from discharge where coId=?");
	PreparedStatement ps4 = connection.prepareStatement(" select * from orders where oId=?");
	ps4.setInt(1,oid);
	ResultSet rs4=ps4.executeQuery();
	PreparedStatement ps3 = connection.prepareStatement(" select * from tracking where shipId=? ");
	
    if(rs1.next())
    {
    	shipid=rs1.getInt("shipId");
    	%><td><%=shipid %></td><%
    	coid=rs1.getInt("b.coId");
    	%><td><%=coid %></td><%
    	ps2.setInt(1,coid);
    	ps3.setInt(1,shipid);
    	ResultSet rs2=ps2.executeQuery();
    	ResultSet rs3=ps3.executeQuery();
    	if(rs2.next())
    	{
    		
    		if(rs4.next()){
    				%><td><%=rs4.getInt("loading")%></td>
    				<%
    				}
    				%>
    				<td>-</td>
    	<td>discharged</td><%
    		
    		
    	}
    	else if(rs3.next())
    	{
    		
        	%><td><%= rs3.getInt("lastPortId")%></td>
        	<td><%=dpid=rs3.getInt("nextPortId")%></td>
    		<td>in transit</td>
    		<%
    	}
    	
    
    else{
    	%>
    		<script>
    		alert("Your order wasn't loaded on Ship!");
    		</script>
    	<%
    }
    }
    %>
    </tr>
    </table>
	<%
	response.sendRedirect("notifyorders.jsp");
}
catch(Exception e)
{
	e.printStackTrace(); 
}
    	

%>
</body>
</html>