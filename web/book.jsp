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
int sid=Integer.parseInt(session.getAttribute("sId").toString());
int oid=Integer.parseInt(request.getParameter("oid"));
int coid=Integer.parseInt(request.getParameter("coid"));
//String shipid=request.getParameter("shipid");

try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
        
	PreparedStatement ps = connection.prepareStatement("insert into books(sId,oId,coId) values(?,?,?)");
	ps.setInt(1,sid);
	ps.setInt(2,oid);
	ps.setInt(3,coid);
      
	ps.executeUpdate();
          
        
	%>
	<script>
		alert("container booked!");
	</script>
	<%
        PreparedStatement ps1=connection.prepareStatement("update container set status='occupied' where coId=?");
        ps1.setInt(1,coid);
        ps1.executeUpdate();
        response.sendRedirect("cargo.jsp?coid="+coid+"&oid="+oid);
	
	
}

catch (Exception e)
{
	e.printStackTrace();
}


%>



</body>
</html>