
<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="javax.servlet.http.HttpServlet.*"%>
<%@ page import ="javax.servlet.http.HttpServletRequest.*" %>
<%@ page import ="javax.servlet.http.HttpServletResponse.*"%>

<html>	
    <head> <link type="text/css" rel="stylesheet" href="style.css"/></head>
<body>

<%
String sname = request.getParameter("sname");
String tel =request.getParameter("tel") ;
String email= request.getParameter("email") ;


	try
	{	
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
		Statement statement = connection.createStatement() ;
		ResultSet rs ;
			int i=statement.executeUpdate("insert into shipper(sname,tel,email)" + "values('"+sname+"' , '"+tel+"' ,'"+email+"')",Statement.RETURN_GENERATED_KEYS);
                        ResultSet rs3=statement.getGeneratedKeys();
                        rs3.next();
                        int id=rs3.getInt(1);
			%>
			 <script>
                             alert("YOU ARE NOW REGISTERED AS SHIPPER!! Your shipper id is: <%=id%>");
			 	</script>
		 	 <%
		
	
	
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}
	

%>
<center>
    <a href="home.html">HOME PAGE</a>
    <br>
    <a href="shiplog.html"><button>LOGIN</button></a>
    
</center>

</body>
</html>
</html>
