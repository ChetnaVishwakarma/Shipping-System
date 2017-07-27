package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import shipping.ConnectionProvider;

public final class consigneeTrackOrder_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Track Order</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
 
            Connection con=ConnectionProvider.getCon();
            PreparedStatement ps=con.prepareStatement("select oId from orders where cId=?");
            int id=Integer.parseInt(session.getAttribute("cId").toString());
            ps.setInt(1,id);
            ResultSet rs=ps.executeQuery();
            if(!rs.next())
            {
                
      out.write(" No orders to track ");

            }
            else
            {
                rs.beforeFirst();
            
      out.write("\n");
      out.write("        <h1>Track Order</h1>\n");
      out.write("        <form action=\"./trackorders\" method=\"post\">\n");
      out.write("            Choose order id: <select name=\"oId\" required>\n");
      out.write("            ");
 while(rs.next()) 
            { 
      out.write("\n");
      out.write("            <option value=\"");
      out.print( rs.getInt(1));
      out.write('"');
      out.write('>');
      out.print( rs.getInt(1) );
      out.write("</option>\n");
      out.write("            ");
    
            } 
      out.write("\n");
      out.write("            </select>\n");
      out.write("            <input type=\"submit\" value=\"Track\" name=\"Track\"/>\n");
      out.write("        </form>\n");
      out.write("         ");
 } 
      out.write("\n");
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
