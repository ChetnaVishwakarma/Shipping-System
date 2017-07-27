package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import shipping.ConnectionProvider;

public final class addRouteDetail_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Route Detail</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Route Details</h1>\n");
      out.write("        ");
 String rName=request.getParameter("rName");
           int noOfStops= Integer.parseInt(request.getParameter("noOfStops"));
           
           int i=1;
           Connection con=ConnectionProvider.getCon();
           Statement smt=con.createStatement();
           String s1="select * from port";
           ResultSet rs=smt.executeQuery(s1);
           
           
           
        
      out.write("\n");
      out.write("        <form action=\"./addRoutes\" method=\"post\"> \n");
      out.write("            Route Name: <input type=\"text\" name=\"rName\" value=\"");
      out.print( rName);
      out.write("\" readonly/><br/>\n");
      out.write("            No of Stops: <input type=\"number\" name=\"noOfStops\" value=\"");
      out.print( noOfStops);
      out.write("\" readonly/><br/>\n");
      out.write("            ");
 while(i<=noOfStops)
            { 
      out.write("\n");
      out.write("            Choose Port for stop no ");
      out.print( i);
      out.write("\n");
      out.write("            <select name=\"stop\">\n");
      out.write("            ");
 rs.beforeFirst();
                while(rs.next())
                { 
      out.write(" <br/><br/>\n");
      out.write("                <option value=\"");
      out.print( rs.getInt("portId"));
      out.write('"');
      out.write('>');
      out.print( rs.getString("pName"));
      out.write("</option>\n");
      out.write("                ");
 }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("            ");
 i++; } 
      out.write("\n");
      out.write("            <input type=\"submit\" name=\"Add\" />\n");
      out.write("        </form>\n");
      out.write("            <button onclick=\"loaction.href='home.jsp'\">Home</button>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
