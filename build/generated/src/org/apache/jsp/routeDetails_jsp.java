package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;

public final class routeDetails_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("  ");
      	
		Class.forName("com.mysql.jdbc.Driver") ;
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
		Statement statement = connection.createStatement() ;
                ResultSet rs1= statement.executeQuery("select * from routes");
                PreparedStatement ps=connection.prepareStatement("select p.pName from port as p, routeDetails as rd where p.portID=rd.portId and rd.rId=?");
                
      out.write("\n");
      out.write("\t\t<form action=\"plc.jsp\">\n");
      out.write("                    ");

                while(rs1.next())
                {
                    
      out.write("<br/><br/>\n");
      out.write("                    \n");
      out.write("                    <input type=\"radio\" name=\"rName\" value=\"");
      out.print( rs1.getInt(1));
      out.write("\" />");
      out.print( rs1.getString("rName"));
      out.write("\n");
      out.write("                    ");

                
                    int rid=rs1.getInt(1);
                    ps.setInt(1,rid);
                    ResultSet rs2=ps.executeQuery();
                    while(rs2.next())
                        { 
      out.write("\n");
      out.write("                        ");
      out.print(rs2.getString("pName"));
      out.write(";\n");
      out.write("                       ");
 }}   
      out.write("\n");
      out.write("                          </form>\n");
      out.write("  </body>\n");
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
