package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import com.mysql.jdbc.Driver.*;

public final class bookcontainer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <link type=\"text/css\" rel=\"stylesheet\" href=\"style.css\"/>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");

String oid=request.getParameter("oid");

try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" select * from orderDetails where oId=?");
	ps.setString(1,oid);
	ResultSet resultset=ps.executeQuery();
	if(resultset.next())
	{
		
	
	
      out.write("\r\n");
      out.write("\t<div style=\"border : 2px solid black\">\r\n");
      out.write("\tOrder : ");
      out.print(resultset.getString("oName") );
      out.write(" <br>\r\n");
      out.write("\tType : <input type=\"text\" value=\"");
      out.print(resultset.getString("type") );
      out.write("\" name=\"type\" readonly> <br>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<fieldset>\r\n");
      out.write("\t<legend>Enter Container Requirements</legend>\r\n");
      out.write("\t<form action=\"displaycontainers.jsp\" method=\"POST\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"oid\" value=\"");
      out.print(oid);
      out.write("\"/>\r\n");
      out.write("\t\r\n");
      out.write("\tType :  <select name=\"type\">\r\n");
      out.write("\t\t<option>open top </option>\r\n");
      out.write("\t\t<option>dry </option>\r\n");
      out.write("\t\t<option>refrigerated </option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t\r\n");
      out.write("\tQuantity : <input type=\"text\" value=\"");
      out.print(resultset.getInt("quantity") );
      out.write("\" name=\"quantity\" readonly > <br><br>\r\n");
      out.write("\tSize :  \r\n");
      out.write("\t<select name=\"size\">\r\n");
      out.write("\t\t<option>20 feet </option>\r\n");
      out.write("\t\t<option>40 feet </option>\r\n");
      out.write("\t\t<option>45 feet (high cube) </option>\r\n");
      out.write("\t</select>\r\n");
      out.write("\t<br><br>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<input type=\"submit\" value=\"Show available Containers\">\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t");

	} 
	
      out.write("\r\n");
      out.write("\t</form>\r\n");
      out.write("        <a href=\"notifyorders.jsp\"><button>Back</button></a>\r\n");
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
