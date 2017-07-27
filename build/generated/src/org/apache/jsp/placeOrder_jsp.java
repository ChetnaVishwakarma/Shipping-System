package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import java.sql.*;
import javax.sql.*;
import javax.servlet.http.HttpServlet.*;
import javax.servlet.http.HttpServletRequest.*;
import javax.servlet.http.HttpServletResponse.*;

public final class placeOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <body>\n");

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
                        
                        int oId=rs.getInt(1);
                        out.print("1");
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
                            
      out.write(" Order Placed!!<br/> Your order Id is: ");
 out.print(oId); 
                        }
                            else
                            {
                            
      out.write(" something went wrong!! Try later");

                            }
	 	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	} 
      out.write("\n");
      out.write("        <a href=\"index_2.html\">Home</a>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
