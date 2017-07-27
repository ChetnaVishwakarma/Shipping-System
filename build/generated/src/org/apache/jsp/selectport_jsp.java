package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import shipping.ConnectionProvider;
import java.sql.*;

public final class selectport_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Discharge</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1></h1>\n");
      out.write("        ");
 
            int shipId=Integer.parseInt(request.getParameter("shipId"));
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps1=con.prepareStatement("select rId from ship where shipId=?");
            PreparedStatement ps=con.prepareStatement("select pName,port.portId from routeDetails,port where rId=? and routeDetails.portId=port.portId");
            PreparedStatement ps2=con.prepareStatement("select coId from loads where shipId=?");
            
            ps1.setInt(1,shipId);
            ResultSet s=ps1.executeQuery();
            s.next();
            int rid=s.getInt(1);
            
            ps.setInt(1,rid);
            ResultSet p=ps.executeQuery();
            
            ps2.setInt(1,shipId);
            ResultSet c=ps2.executeQuery();
        
        
      out.write("\n");
      out.write("        <form action=\"./discharge\" method=\"post\">\n");
      out.write("            Ship id: <input type=\"number\" name=\"shipId\" value=\"");
      out.print( shipId );
      out.write("\" readonly/><br/><br/>\n");
      out.write("            Select Port: <select name=\"pId\">\n");
      out.write("                ");
 while(p.next())
                    {
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(p.getInt("portId"));
      out.write('"');
      out.write('>');
      out.print( p.getString("pName"));
      out.write("</option>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("            </select><br/><br/>\n");
      out.write("            Select Container:<select name=\"coId\">\n");
      out.write("                ");
 while(c.next())
                    {
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(c.getInt("coId"));
      out.write('"');
      out.write('>');
      out.print( p.getInt("coId"));
      out.write("</option>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("            </select>\n");
      out.write("                    <input type=\"submit\" value=\"Discharge\" name=\"submit\"/>\n");
      out.write("        </form>\n");
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
