<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="javax.servlet.http.HttpServlet.*"%>
<%@ page import ="javax.servlet.http.HttpServletRequest.*" %>
<%@ page import ="javax.servlet.http.HttpServletResponse.*"%>
<html>
    <head> <link type="text/css" rel="stylesheet" href="style.css"/></head>
    <body>
<%
  String oname= request.getParameter("oname");
  int sId= Integer.parseInt(request.getParameter("sid"));
  String type=request.getParameter("type");
  int quantity=Integer.parseInt(request.getParameter("quantity"));
  String loading_port=request.getParameter("loading_port");
  String discharge_port=request.getParameter("discharge_port");
  int cId=Integer.parseInt(session.getAttribute("cId").toString());
  
	try
	{	
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
		PreparedStatement ps2 = connection.prepareStatement("insert into  orderDetails(oname,type,quantity)" + "values(?,?,?)",Statement.RETURN_GENERATED_KEYS); ;
                ps2.setString(1,oname);
	        ps2.setString(2,type);
                ps2.setInt(3,quantity);
                        int j=ps2.executeUpdate(); 
                        
                        ResultSet rs=ps2.getGeneratedKeys();
                        rs.next();
                        int oId=rs.getInt(1);
                        
                        PreparedStatement ps=connection.prepareStatement("insert into orders(oId,sId,cId,loading,discharge,paymentStatus) values(?,?,?,?,?,?)");
                        ps.setInt(1,oId);
                        ps.setInt(2,sId);
                        ps.setInt(3,cId);
                        ps.setString(4,loading_port);
                        ps.setString(5,discharge_port);
                        ps.setString(6,"not paid");
                        int r=ps.executeUpdate();
                        if(r>0)
                        {
                            %> Order Placed!!<br/> Your order Id is: <% out.print(oId); 
                        }
                            else
                            {
                            %> something went wrong!! Try later<%
                            }
	 	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} %>
        <br/><br/>
        <a href="index_2.html">Home</a>
</body>
</html>