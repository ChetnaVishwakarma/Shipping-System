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
	<legend>Containers</legend>
	<form action="loadOnPort.jsp" method="POST">
	
<%
//String oid=request.getParameter("oid");
//
int sid =Integer.parseInt(session.getAttribute("sId").toString());
int coid,oid;
try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" select * from books where sId=?");
	PreparedStatement pss = connection.prepareStatement(" select * from container where coId=?");
	ps.setInt(1,sid);
	
	ResultSet resultset=ps.executeQuery();
	while(resultset.next())
	{
		coid=resultset.getInt("coId");
		oid=resultset.getInt("oId");
	
	%>
	<input type="radio" name="coid" value="<%=coid %>" required>
	<input type="hidden" name="oid" value="<%=oid %>">
	<% 
	pss.setInt(1,coid);
	ResultSet rs=pss.executeQuery();
	while(rs.next())
	{
		%>
		Container Id : <%=coid %> <br>
		Order Id : <%=oid %><br>
		Type : <input type="text" value="<%=rs.getString("type") %>" name="type" readonly> <br>
		Size : <input type="text" value="<%=rs.getString("size") %>" name="size" readonly> <br>
	    Price : <input type="text" value="<%=rs.getString("price") %>" name="price" readonly> <br>
	
	
	
	

	
	<%
	}
	}
	%>
	<input type="submit" value="Load on Port">
	</form>
        <a href="shipperProfile.html"><button>Back</button></a>
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