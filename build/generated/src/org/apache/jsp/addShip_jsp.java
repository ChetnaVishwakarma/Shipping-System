package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import shipping.ConnectionProvider;

public final class addShip_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Add Ship</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

           Connection con=ConnectionProvider.getCon();
           Statement smt=con.createStatement();
           String s1="select * from shippingLine";
           String s2="select * from routes";
           PreparedStatement ps1=con.prepareStatement(s1);
           PreparedStatement ps2=con.prepareStatement(s2);
           ResultSet rl=ps1.executeQuery();
           ResultSet r=ps2.executeQuery();
           
        
      out.write("\n");
      out.write("        <h1>Add Ship</h1>\n");
      out.write("        \n");
      out.write("        <button onclick=\"location.href='history.go(-1)'\">Back</button> <br/><br/>\n");
      out.write("        <form action=\"./addShips\" method=\"post\">\n");
      out.write("            Enter Ship Name: <input type=\"text\" name=\"shipName\" required/><br/><br/>\n");
      out.write("            Enter Type: <select name=\"type\">\n");
      out.write("                <option value=\"Container\">Container</option>\n");
      out.write("                <option value=\"Bulk\">Bulk</option>\n");
      out.write("                <option value=\"RoRo\">RoRo</option>\n");
      out.write("            </select><br/><br/>\n");
      out.write("            Enter number of Containers: <input type=\"number\" name=\"noOfContainers\" required/><br/><br/>\n");
      out.write("            Enter slot available: <input type=\"number\" name=\"slotAvailable\" required/><br/><br/>\n");
      out.write("            Enter Ship Line : <select name=\"shipLineId\" required>\n");
      out.write("                ");
 rl.beforeFirst();
                    while(rl.next())
                { 
      out.write("\n");
      out.write("                <option value=\"");
      out.print( rl.getInt("shipLineId") );
      out.write("\"> ");
      out.print( rl.getString("shipLineName") );
      out.write("</option>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("                </select><br/><br/>\n");
      out.write("            Enter Route : <select name=\"rId\" required>\n");
      out.write("                ");
  r.beforeFirst();
                    while(r.next())
                { 
      out.write("\n");
      out.write("                <option value=\"");
      out.print( r.getInt("rId") );
      out.write("\"> ");
      out.print( r.getString("rName") );
      out.write("</option>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("                </select><br/><br/>\n");
      out.write("            <input type=\"submit\" name=\"submit\" value=\"Add Ship\"/><br/><br/>\n");
      out.write("            \n");
      out.write("        </form><br/><br/>\n");
      out.write("        \n");
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
