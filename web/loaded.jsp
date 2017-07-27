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
int pid=Integer.parseInt(request.getParameter("pid"));
//int oid=Integer.parseInt(request.getParameter("oid"));
int coid=Integer.parseInt(request.getParameter("coid"));
int shipid=Integer.parseInt(request.getParameter("shipid"));

try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	//Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement("insert into loads(portId,coId,shipId) values(?,?,?)");
	ps.setInt(1,pid);
	ps.setInt(2,coid);
	ps.setInt(3,shipid);
        //out.print(":");
	ps.executeUpdate();
        //out.print(":");
        
	%>
	<script>
		alert("Loaded on ship!");
                <a href="shipperProfile.html"><button>Home</button></a>
	</script>
	<%
       
	
	
	
}

catch (Exception e)
{
	e.printStackTrace();
}


%>



</body>
</html>