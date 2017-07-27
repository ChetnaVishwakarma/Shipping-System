<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="com.mysql.jdbc.Driver.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="style.css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <a href="logout.jsp"><button>LOGOUT</button></a>
   <% 
    try{
    	String oname;
    	
    	int oid=Integer.parseInt(request.getParameter("oid"));
    	int coid=Integer.parseInt(request.getParameter("coid"));
    	Class.forName("com.mysql.jdbc.Driver") ;
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
    	Statement statement = connection.createStatement() ;
    	PreparedStatement ps = connection.prepareStatement(" select * from orderDetails where oId=?");
    	ps.setInt(1,oid);
    	
    	ResultSet resultset=ps.executeQuery();
    	if(resultset.next())
  
    	{
            
    		oname=resultset.getString("oName");
    		
    		%> 
    		Order details. <br>
    		Type : <%=resultset.getString("type")%> <br>
    		Quantity :<%=resultset.getString("quantity") %> <br>
    		Name :<%=oname%>  <br><br>
    	
    
        <fieldset>
            
            <legend>CARGO</legend>
          <form action="addcargo.jsp" >  
            
         Name:<input type="text" name="oname"  value="<%= oname %> " readonly/><br/><br>
         <input type="hidden" name="coid" value="<%=coid%>" required/><br/><br>
                 
         Price :<input type="number" name="price" required/><br/><br>

         Type :<select name="type" required>
         <option>textile</option>
         <option>food</option>
         <option>grains</option>
         <option>steel</option>
         <option>cement</option>
         <option>chemical</option>
         </select><br/><br>

         Quantity :<input type="number" name="quantity" min=0 max=700 required /><br/><br>



<input type="submit" value="Load Cargo"/>  

</form>  
        </fieldset>
   <% 
    	}
    
    }
   catch (Exception e)
   {
   	e.printStackTrace();
   }
    
    %>
    </body>
</html>
