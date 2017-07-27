<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="javax.servlet.http.HttpServlet.*"%>
<%@ page import ="javax.servlet.http.HttpServletRequest.*" %>
<%@ page import ="javax.servlet.http.HttpServletResponse.*"%>
<html>
    <head>
        <link type="text/css" rel="stylesheet" href="style.css"/>
    </head>
    <body>
    
<%
int cid=  Integer.parseInt(request.getParameter("cid"));
String tel=request.getParameter("tel");
try
	{	
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
		Statement statement = connection.createStatement() ;
                PreparedStatement ps =connection.prepareStatement("select * from consignee where cid=? and tel=?");
               ResultSet rs;
               ps.setInt(1, cid);
               ps.setString(2, tel);
               rs=ps.executeQuery();
                if(rs.next())
                {
                    session=request.getSession();
		    session.setAttribute("cId", cid);
                    response.sendRedirect("index_2.html");
                    
                }
                else
                {
                 %>
           <script>
   	  alert("Wrong! ");
   	  window.location.href="conlog.html";
   	  </script>
    		 <%

                }
        }
            catch(Exception e)
	{
		e.printStackTrace();
	}
%>
</body> 
</html>