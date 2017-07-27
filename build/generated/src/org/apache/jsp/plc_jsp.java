package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;

public final class plc_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>place order</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");
  String oname= request.getParameter("oname");
            String sid= request.getParameter("sid");
            String type=request.getParameter("type");
            String quantity=request.getParameter("quantity");
            String loading_port=request.getParameter("loading_port");
            String discharge_port=request.getParameter("discharge_port");
            
             try{
                 
             Class.forName("com.mysql.jdbc.Driver") ;
            //Connection connection =null;
            
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
            Statement statement = connection.createStatement() ;
            //if(connection !=null){
            
            ResultSet resultset1= statement.executeQuery(" select sid from shippers " ) ; 
            ResultSet resultset2 = statement.executeQuery(" select * from port" ) ; 
            
            
        
      out.write("\n");
      out.write("        <h1> Place order </h1>\n");
      out.write("        <form action=\"placeOrder.jsp\" style=\"align:center;\">\n");
      out.write("  Order name:\n");
      out.write("  <input type=\"text\" name=\"oname\">\n");
      out.write("  <br><br>\n");
      out.write("  Shipper ID:\n");
      out.write("   <select name=\"sid\">\n");
      out.write("      ");
 resultset1.beforeFirst();
          while(resultset1.next()){ 
      out.write("\n");
      out.write("      <option>");
      out.print( resultset1.getInt(sid));
      out.write("</option>\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("  </select>\n");
      out.write("  <br><br>\n");
      out.write("  Type:\n");
      out.write("  <select name=\"type\">\n");
      out.write("    <option value=\"Oil\">Oil</option>\n");
      out.write("    <option value=\"Solid\">Solid</option>\n");
      out.write("    <option value=\"delicate\">delicate</option>\n");
      out.write("    <option value=\"precious\">precious</option>\n");
      out.write("  </select>\n");
      out.write("  <br><br>\n");
      out.write("  Quantity:\n");
      out.write("  <input type=\"text\" name=\"quantity\">\n");
      out.write("  <br><br>\n");
      out.write("  Loading port:\n");
      out.write("  <select name=\"loading_port\">\n");
      out.write("      ");
 resultset2.beforeFirst();
          while(resultset2.next()){ 
      out.write("\n");
      out.write("      <option>");
      out.print( resultset2.getString(2));
      out.write("</option>\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("  </select>\n");
      out.write("  <br><br>\n");
      out.write("  discharge port:\n");
      out.write("  <select name=\"discharge_port\">\n");
      out.write("    ");
  resultset2.beforeFirst();
        while(resultset2.next()){ 
      out.write("\n");
      out.write("      <option>");
      out.print( resultset2.getString(2));
      out.write("</option>\n");
      out.write("      ");
 } 
      out.write("\n");
      out.write("  </select>\n");
      out.write("  <br><br>\n");
      out.write("  <input type=\"submit\">\n");
      out.write("        </form>\n");
      out.write(" ");
 } 
 
  catch (Exception e)
	{
		e.printStackTrace();
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
