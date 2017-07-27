<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.mysql.jdbc.Driver.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link type="text/css" rel="stylesheet" href="style.css"/>
       
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>Available Ships</legend>
	<form action="loaded.jsp" method="POST">
	
<%
int oid=Integer.parseInt(request.getParameter("oid"));
int coid=Integer.parseInt(request.getParameter("coid"));
int pid=Integer.parseInt(request.getParameter("pid"));
String loading;
String discharge;
int route,shipid,shipLineId,no;
String shipname,type;

try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps1 = connection.prepareStatement(" select * from orders where oId=?");
	ps1.setInt(1,oid);
	ResultSet rs=ps1.executeQuery();
	if(rs.next())
	{
            
		loading=rs.getString("loading");
		discharge=rs.getString("discharge");
		
	
	PreparedStatement ps2 = connection.prepareStatement(" select rId from routeDetails where portId in (select portId from port where pName=?)");
	ps2.setString(1,loading);
	ResultSet resl= ps2.executeQuery();
       
	//ps2.setString(1,discharge);
	//ResultSet resd= ps2.executeQuery();
        
	if(resl.next()){
            
            
		route=resl.getInt(1);
                    
	PreparedStatement ps3 =connection.prepareStatement(" select * from ship where rId=? and slotAvailability='available'");
	ps3.setInt(1,route);
	
	ResultSet ship=ps3.executeQuery();
        while(ship.next())
	{
				shipid=ship.getInt(1);
				shipLineId=ship.getInt(7);
				shipname=ship.getString(2);
				type=ship.getString(4);
				no=ship.getInt(5);
		%>
		
		<input type="radio"  name="shipid" value="<%=shipid%>" required>
		<input type="hidden" name="oid" value="<%=oid%>">
		<input type="hidden" name="coid" value="<%=coid%>">
		<input type="hidden" name="pid" value="<%= pid %>">
		 Name : <%=shipname%> <br>
		 Type : <%=type%> <br>
	     Capacity : <%=no%> <br>
		 			
		<%
	
	}
	%>
	
	<input type="submit" value="Load on Ship">
	</form>
	<a href="loadOnPort.jsp"><button>Back</button></a>
	</fieldset>
	<%
	}
	}
}

catch (Exception e)
{
	e.printStackTrace();
}


%>



</body>
</html>