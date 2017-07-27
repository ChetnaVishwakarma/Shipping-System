
<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="javax.servlet.http.HttpServlet.*"%>
<%@ page import ="javax.servlet.http.HttpServletRequest.*" %>
<%@ page import ="javax.servlet.http.HttpServletResponse.*"%>

<html>	
    <head> <link type="text/css" rel="stylesheet" href="style.css"/></head>
<body>

<%
String cname = request.getParameter("cname");
String tel =request.getParameter("tel") ;
String email= request.getParameter("email") ;
String pobox= request.getParameter("pobox");

	try
	{	
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
		Statement statement = connection.createStatement() ;
		ResultSet rs ;
			int i=statement.executeUpdate("insert into consignee(cname,tel,email,pobox)" + "values('"+cname+"' , '"+tel+"' ,'"+email+"' , '"+ pobox +"')",Statement.RETURN_GENERATED_KEYS);
                        ResultSet rs1=statement.getGeneratedKeys();
                        rs1.next();
                        int id=rs1.getInt(1);
			%>
			 <script>
			 	alert(" You are now registered. Your consignee id is: <%=id%>" );
                                
			 	</script>
		 	 <%
		
	
	
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	

%>
<center>
    <a href="home.html">Home Page</a>
    <br>
    <a href="conlog.html">Login</a>
</center>

</body>
</html>
</html>
