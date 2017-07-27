package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import shipping.ConnectionProvider;

public final class showRoutes_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Routes</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Routes</h1>\n");
      out.write("       ");
 Connection con=ConnectionProvider.getCon();
            Statement smt=con.createStatement();
            String sql="select * from routes,routeDetails,port where routes.rId=routeDetails.rId and routeDetails.portId=port.portId";
            String sql1="select rId,max(stopNo) from routeDetails group by rId";
            PreparedStatement ps1=con.prepareStatement(sql);
            PreparedStatement ps2=con.prepareStatement(sql1);
            ResultSet rd=ps1.executeQuery();
            ResultSet rp=ps2.executeQuery();
            
            int i=1;
            if(!rd.next())
            {
                out.print("No routes exsits!!");
            }
            else
            {
                rd.beforeFirst();
                rp.beforeFirst();
                
      out.write("\n");
      out.write("                <table border=\"1\" cellspacing=\"3px\" cellpadding=\"3px\">\n");
      out.write("                    <tr>\n");
      out.write("                    <th> Route ID</th>\n");
      out.write("                    <th> Route Name</th>\n");
      out.write("                    <th> Ports </th>\n");
      out.write("                    </tr> \n");
      out.write("                    ");
 
                while(rd.next())
                { 
                    
                    rp.next();
                    i=1;
                    int stops=rp.getInt(2); 
      out.write(" <tr>\n");
      out.write("                <td>");
      out.print( rd.getInt("routes.rId") );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( rd.getString("routes.rName") );
      out.write("</td>\n");
      out.write("                <td> -> ");
  while(i<=stops)
                    {   
                    out.print(rd.getString("pName")); 
      out.write("</td>\n");
      out.write("                   ");
   if(!rd.next())
                        break;
                        else
                            rd.next();
                    i++;
                    } 
      out.write("\n");
      out.write("                </tr>\n");
      out.write("                ");
 rd.previous(); } 
      out.write(" </table> ");

                
               }
                
      out.write("\n");
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
