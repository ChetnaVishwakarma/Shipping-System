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

<%
String oid=request.getParameter("oid");

try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" select * from orderDetails where oId=?");
	ps.setString(1,oid);
	ResultSet resultset=ps.executeQuery();
	if(resultset.next())
	{
		
	
	%>
	<div style="border : 2px solid black">
	Order : <%=resultset.getString("oName") %> <br>
	Type : <input type="text" value="<%=resultset.getString("type") %>" name="type" readonly> <br>
	</div>
	
	<fieldset>
	<legend>Enter Container Requirements</legend>
	<form action="displaycontainers.jsp" method="POST">
	<input type="hidden" name="oid" value="<%=oid%>"/>
	
	Type :  <select name="type">
		<option>open top </option>
		<option>dry </option>
		<option>refrigerated </option>
	</select>
	<br><br>
	
	Quantity : <input type="text" value="<%=resultset.getInt("quantity") %>" name="quantity" readonly > <br><br>
	Size :  
	<select name="size">
		<option>20 feet </option>
		<option>40 feet </option>
		<option>45 feet (high cube) </option>
	</select>
	<br><br>
	
	
	
	
	<input type="submit" value="Show available Containers">
	

	
	<%
	} 
	%>
	</form>
        <a href="notifyorders.jsp"><button>Back</button></a>
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