<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.mysql.jdbc.Driver.*" %>
<html>
<head>
     <link type="text/css" rel="stylesheet" href="style.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>Available Containers</legend>
	<form action="ships.jsp" method="POST">
	
<%
int oid=Integer.parseInt(request.getParameter("oid"));
int coid=Integer.parseInt(request.getParameter("coid"));

String loading;
int pid;


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
		
		out.println(loading);
	
	PreparedStatement ps2 = connection.prepareStatement(" select portId from port where pName=?");
	ps2.setString(1,loading);
	ResultSet port= ps2.executeQuery();
	
	if(port.next())
	{
				pid=port.getInt("portId");
		%>
		
		<input type="hidden" name="pid" value="<%=pid%>" readonly>
		<input type="hidden" name="coid" value="<%=coid%>" readonly>
		<input type="hidden" name="oid" value="<%=oid%>" readonly>
		
		Port Name : <input type="text" name="loading" value="<%= loading%>" readonly>
		
		<br>
		 			
		<%
	
	}
	}
	%>
	
	<input type="submit" value="Select Ship">
	</form>
	<a href="selectContainer.jsp"><button>Back</button></a>
	</fieldset>
	<%
	
	
}

catch (Exception e)
{
	e.printStackTrace();
}


%>



</body>
</html>