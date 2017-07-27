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
	<form action="book.jsp" method="POST">
	
<%
String oid=request.getParameter("oid");
String type=request.getParameter("type");
String quantity=request.getParameter("quantity");
String size=request.getParameter("size");

try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" select * from container where type=? and size=? and capacity>=? and status=?");
	ps.setString(1,type);
	ps.setString(2,size);
	ps.setString(3,quantity);
	ps.setString(4,"free");
	ResultSet resultset=ps.executeQuery();
	while(resultset.next())
	{
		%>
		Container <br>
		<input type="radio" name="coid" value="<%=resultset.getInt("coId")%>" required/>
		 Id : <%=resultset.getInt("coId")%> <br>
		 <input type="hidden" name="oid" value="<%=oid%>">
		 Type : <input type="text" value="<%=resultset.getString("type") %>" name="type" readonly> <br>
		 Size : <input type="text" value="<%=resultset.getString("size") %>" name="size" readonly> <br>
	     Capacity : <input type="text" value="<%=resultset.getString("capacity") %>" name="capacity" readonly> <br>
		 Use Status : <input type="text" value="<%=resultset.getString("status") %>" name="usestatus" readonly> <br>
		 Price : <input type="text" value="<%=resultset.getString("price") %>" name="price" readonly> <br>
	
			
		<%
	
	}
	%>
	
	<input type="submit" value="Book Container">
	</form>
	
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