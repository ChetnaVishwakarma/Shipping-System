package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import shipping.ConnectionProvider;

public final class showShips_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Existing Ships</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Existing Ships</h1>\n");
      out.write("        ");
 
            Connection con=ConnectionProvider.getCon();
            Statement smt=con.createStatement();
            String sql="select * from ship natural join routes";
            ResultSet ship=smt.executeQuery(sql);
            if(!ship.next())
            {
                out.print("No ships exsits!!");
            }
            else
            {
                ship.beforeFirst();
                
      out.write("\n");
      out.write("                <table border=\"1\" cellspacing=\"3px\" cellpadding=\"3px\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th>Route ID</th>    \n");
      out.write("                    <th> Ship ID</th>\n");
      out.write("                    <th> Ship Name</th>\n");
      out.write("                    <th> Type </th>\n");
      out.write("                    <th> No of Containers</th>\n");
      out.write("                    <th> Slot Availability</th>\n");
      out.write("                    <th> Ship Line Id</th>\n");
      out.write("                    <th> Route Name</th>\n");
      out.write("                    </tr> \n");
      out.write("                    ");
 
                while(ship.next())
                { 
      out.write(" <tr>\n");
      out.write("                  <td>");
      out.print( ship.getInt("rId") );
      out.write("</td>  \n");
      out.write("                <td>");
      out.print( ship.getInt("shipId") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( ship.getString("shipName") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( ship.getString("type") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( ship.getInt("noOfContainers") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( ship.getInt("slotAvailability") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( ship.getInt("shipLineId") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( ship.getString("rName") );
      out.write("</td>\n");
      out.write("                </tr>\n");
      out.write("                ");
 }} 
      out.write("\n");
      out.write("            \n");
      out.write("             </table>\n");
      out.write("                <a href=\"history.go(-1)\">Back</a>\n");
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
