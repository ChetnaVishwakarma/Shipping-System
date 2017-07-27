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
int quantity=Integer.parseInt(request.getParameter("quantity"));
int price=Integer.parseInt(request.getParameter("price"));
int coid=Integer.parseInt(request.getParameter("coid"));
String name=request.getParameter("oname");
String type=request.getParameter("type");
try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" insert into cargo(coId,name,price,type,quantity) values(?,?,?,?,?)");
	ps.setInt(1,coid);
	ps.setString(2,name);
        ps.setInt(3,price);
	ps.setString(4,type);
        ps.setInt(5,quantity);
	
	ps.executeUpdate();
	%>
	<script>
		r=alert("Loaded in container!");
                
	</script>

       <a href="shipperProfile.html"> <button> Go back </button></a>
	
<%	
}

catch (Exception e)
{
	e.printStackTrace();
}


%>



</body>
</html>