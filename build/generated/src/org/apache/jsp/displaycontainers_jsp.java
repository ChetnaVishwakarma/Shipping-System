package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import com.mysql.jdbc.Driver.*;

public final class displaycontainers_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<fieldset>\r\n");
      out.write("\t<legend>Available Containers</legend>\r\n");
      out.write("\t<form action=\"book.jsp\">\r\n");
      out.write("\t\r\n");

String oid=request.getParameter("oid");
String type=request.getParameter("type");
String quantity=request.getParameter("quantity");
String size=request.getParameter("size");

try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" select * from container where type=? and size=? and capacity>=? and status=?");
	ps.setString(1,type);
	ps.setString(2,size);
	ps.setString(3,quantity);
	ps.setString(4,"free");
	ResultSet resultset=ps.executeQuery();
	while(resultset.next())
	{
		
      out.write("\r\n");
      out.write("\t\tContainer <br>\r\n");
      out.write("\t\t<input type=\"radio\" name=\"coid\" value=\"");
      out.print(resultset.getInt("coId"));
      out.write("\"/>\r\n");
      out.write("\t\t Id : ");
      out.print(resultset.getInt("coId"));
      out.write(" <br>\r\n");
      out.write("\t\t <input type=\"hidden\" name=\"oid\" value=\"");
      out.print(oid);
      out.write("\">\r\n");
      out.write("\t\t Type : <input type=\"text\" value=\"");
      out.print(resultset.getString("type") );
      out.write("\" name=\"type\" readonly> <br>\r\n");
      out.write("\t\t Size : <input type=\"text\" value=\"");
      out.print(resultset.getString("size") );
      out.write("\" name=\"size\" readonly> <br>\r\n");
      out.write("\t     Capacity : <input type=\"text\" value=\"");
      out.print(resultset.getString("capacity") );
      out.write("\" name=\"capacity\" readonly> <br>\r\n");
      out.write("\t\t Use Status : <input type=\"text\" value=\"");
      out.print(resultset.getString("status") );
      out.write("\" name=\"usestatus\" readonly> <br>\r\n");
      out.write("\t\t Price : <input type=\"text\" value=\"");
      out.print(resultset.getString("price") );
      out.write("\" name=\"price\" readonly> <br>\r\n");
      out.write("\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t");

	
	}
	
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"submit\" value=\"Book Container\">\r\n");
      out.write("\t</form>\r\n");
      out.write("\t\r\n");
      out.write("\t</fieldset>\r\n");
      out.write("\t");

	
}

catch (Exception e)
{
	e.printStackTrace();
}



      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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
