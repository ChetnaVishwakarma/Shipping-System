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
	<form action="bookcontainer.jsp" method="POST">
	
<%
String sid =session.getAttribute("sId").toString();

int oid;
try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	
        Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" select * from orders where sId=?");
	ps.setString(1,sid);
        PreparedStatement ps1 = connection.prepareStatement(" select * from orderDetails where oId=?");
	
	
	ResultSet resultset=ps.executeQuery();
	if(!resultset.next())
                       {
        out.print("No orders!!");
                }
        else
                       {
            resultset.beforeFirst();
        while(resultset.next())
	{
		oid=resultset.getInt(1);
                ps1.setInt(1,oid);
                ResultSet rs1=ps1.executeQuery();
	
	%>
	<input type="radio" name="oid" value="<%=oid %>" required>
	Order Id :<%=oid %>  <br>
	Consignee Id : <%=resultset.getInt("cId") %> <br>
	<%
        if(rs1.next())
        {
            %>
        Order : <%=rs1.getString("oName") %> <br>
	<%
        }
	

	
	
	} 
	%>
        <input type="submit" value="Book Container">
	
	</form>
	</fieldset>
	<% }
}

catch (Exception e)
{
	e.printStackTrace();
} %>
 <input TYPE="button" VALUE="Back" onClick="history.go(-1);"/>




</body>
</html>