<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.mysql.jdbc.Driver.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
	<legend>Available Containers</legend>
	<form action="cargo.jsp">
	
<%
int rid;
try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps1 = connection.prepareStatement("select sum(payment) from paymentDetails,orders where paymentDetails.oId=orders.oId and paymentStatus='paid' ");
	ResultSet rs1=ps1.executeQuery();
	if(!rs1.next())
	{
		out.print("No revenue generated ");
		
	}
	else
	{
		rs1.beforeFirst();
		rs1.next();
		out.print("Revenue generated(in Rs): "+ rs1.getInt(1));
	}
	
	//ps.setString(2,coid);
	//ps.setString(3,shipid);
	
	
	
}

catch (Exception e)
{
	e.printStackTrace();
}


%>
		<button onclick="location.href='adminhome.jsp'">Home</button>


</body>
</html>