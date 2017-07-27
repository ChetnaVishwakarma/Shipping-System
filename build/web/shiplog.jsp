<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%@ page import ="javax.servlet.http.HttpServlet.*"%>
<%@ page import ="javax.servlet.http.HttpServletRequest.*" %>
<%@ page import ="javax.servlet.http.HttpServletResponse.*"%>
<%
int sid=  Integer.parseInt(request.getParameter("sid"));
String tel=request.getParameter("tel");
try
	{	
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
		Statement statement = connection.createStatement() ;
               PreparedStatement ps =connection.prepareStatement("select * from shipper where sId=? and tel=?");
               ResultSet rs;
               ps.setInt(1, sid);
               ps.setString(2, tel);
               rs=ps.executeQuery();
                if(rs.next())
                {
                    session=request.getSession();
		    session.setAttribute("sId", sid);
                    response.sendRedirect("shipperProfile.html");

                }
                else
                {
                    %>
			<script>
   	  alert("Wrong! ");
   	  window.location.href="shiplog.html";
   	  </script>
    		 <%

                }
        }
            catch(Exception e)
	{
		e.printStackTrace();
	}
%>