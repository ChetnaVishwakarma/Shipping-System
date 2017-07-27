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
int coid=Integer.parseInt(request.getParameter("coid"));
int price=Integer.parseInt(request.getParameter("price"));
int quantity=Integer.parseInt(request.getParameter("quantity"));
String type=request.getParameter("type");
String name=request.getParameter("size");

try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" insert into cargo(name,type,price,quantity,coId) values(?,?,?,?,?)");
	ps.setInt(3,price);
	ps.setInt(4,quantity);
	ps.setInt(5,coid);
	ps.setString(1,name);
	ps.setString(2,type);

	ps.executeUpdate();
	%>
	<script>
		alert("Loaded in container!");
	</script>
	<%
        response.sendRedirect("shipperProfile.html");
	
	
	
}

catch (Exception e)
{
	e.printStackTrace();
}


%>



</body>
</html>