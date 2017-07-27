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
	<legend>Orders</legend>
	<form action="./trackorders">
	
<%
//String oid=request.getParameter("oid");
//
int sid =Integer.parseInt(session.getAttribute("sId").toString());
int oid;
try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" select * from books where sId=?");
	ps.setInt(1,sid);
	
	ResultSet resultset=ps.executeQuery();
	%>
        <select name="oId">
                <% while(resultset.next())
	{
		oid=resultset.getInt("oId");
	
	%>
	
	<option  value="<%=oid %>"> <%=oid %></option>
		

	
	<%} %> </select>
        
	<input type="submit" value="Track Order">
        
	
	</form>
                <button onclick="location.href='shipperProfile.html'">Back</button>
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