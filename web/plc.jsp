<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<html>
    <head>
         <link type="text/css" rel="stylesheet" href="style.css"/>
        <title>place order</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <%  /*String oname= request.getParameter("oname");
            String sid= request.getParameter("sid");
            String type=request.getParameter("type");
            String quantity=request.getParameter("quantity");
            String loading_port=request.getParameter("loading_port");
            String discharge_port=request.getParameter("discharge_port");*/
            int rId=Integer.parseInt(request.getParameter("rId"));
            
             try{
                 
             Class.forName("com.mysql.jdbc.Driver") ;
            //Connection connection =null;
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
            Statement statement = connection.createStatement() ;
            //if(connection !=null){
            
            ResultSet resultset1= statement.executeQuery(" select sId from shipper " ) ; 
            PreparedStatement ps=connection.prepareStatement(" select pName from port,routeDetails where port.portId=routeDetails.portId and rId=?" );
            ps.setInt(1,rId);
            ResultSet resultset2 = ps.executeQuery();
             
            
            
        %>
        <h1> Place order </h1>
        <form action="placeOrder.jsp" style="align:center;">
  Order name:
  <input type="text" name="oname" required/>
  <br/><br/>
  Shipper ID:
  <select name="sid">
      <% resultset1.beforeFirst();
          while(resultset1.next()){ %>
      <option value="<%= resultset1.getInt(1)%>"><%= resultset1.getInt(1)%></option>
      <% } %>
  </select>
  <br/><br/>
  Type:
  <select name="type">
    <option value="food">Food</option>
    <option value="textile">Textile</option>
    <option value="chemicals">Chemicals</option>
    <option value="steel">Steel</option>
     <option value="cement">Cement</option>
     
  </select>
  <br/><br/>
  Quantity:
  <input type="text" name="quantity" required/>
  <br/><br/>
  Loading port:
  <select name="loading_port">
      <% resultset2.beforeFirst();
          while(resultset2.next()){ %>
      <option value="<%= resultset2.getString(1)%>"><%= resultset2.getString(1)%></option>
      <% } %>
  </select>
  <br/><br/>
  discharge port:
  <select name="discharge_port">
    <%  resultset2.beforeFirst();
        while(resultset2.next()){ %>
      <option value="<%= resultset2.getString(1)%>"><%= resultset2.getString(1)%></option>
      <% } %>
  </select>
  <br/><br/>
  <input type="submit">
        </form>
  <a href="routeDetails.jsp"><button>Back</button></a>
 <% } 
 
  catch (Exception e)
	{
		e.printStackTrace();
	}
  %>
    </body>
</html>
