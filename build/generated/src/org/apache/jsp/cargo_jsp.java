package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import com.mysql.jdbc.Driver.*;

public final class cargo_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("    <a href=\"logout.jsp\"><button>LOGOUT</button></a>\r\n");
      out.write("   ");
 
    try{
    	String oname;
    	
    	int oid=Integer.parseInt(request.getParameter("oid"));
    	int coid=Integer.parseInt(request.getParameter("coid"));
    	Class.forName("com.mysql.jdbc.Driver") ;
    	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
    	Statement statement = connection.createStatement() ;
    	PreparedStatement ps = connection.prepareStatement(" select * from orderDetails where oId=?");
    	ps.setInt(1,oid);
    	
    	ResultSet resultset=ps.executeQuery();
    	if(resultset.next())
  
    	{
            
    		oname=resultset.getString("oName");
    		
    		
      out.write(" \r\n");
      out.write("    \t\tOrder details. <br>\r\n");
      out.write("    \t\tType : ");
      out.print(resultset.getString("type"));
      out.write(" <br>\r\n");
      out.write("    \t\tQuantity :");
      out.print(resultset.getString("quantity") );
      out.write(" <br>\r\n");
      out.write("    \t\tName :");
      out.print(oname);
      out.write("  <br><br>\r\n");
      out.write("    \t\r\n");
      out.write("    \r\n");
      out.write("        <fieldset>\r\n");
      out.write("            \r\n");
      out.write("            <legend>CARGO</legend>\r\n");
      out.write("          <form action=\"addcargo.jsp\" >  \r\n");
      out.write("            \r\n");
      out.write("         Name:<input type=\"text\" name=\"");
      out.print(oname );
      out.write("\" readonly/><br/><br>\r\n");
      out.write("         <input type=\"hidden\" name=\"coid\" value=\"");
      out.print(coid);
      out.write("\" required/><br/><br>\r\n");
      out.write("                 \r\n");
      out.write("         Price :<input type=\"number\" name=\"price\" required/><br/><br>\r\n");
      out.write("\r\n");
      out.write("         Type :<select name=\"type\" required>\r\n");
      out.write("         <option>textile</option>\r\n");
      out.write("         <option>food</option>\r\n");
      out.write("         <option>grains</option>\r\n");
      out.write("         <option>steel</option>\r\n");
      out.write("         <option>cement</option>\r\n");
      out.write("         <option>chemical</option>\r\n");
      out.write("         </select><br/><br>\r\n");
      out.write("\r\n");
      out.write("         Quantity :<input type=\"number\" name=\"quantity\" min=100 max=700 required /><br/><br>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<input type=\"submit\" value=\"Load Cargo\"/>  \r\n");
      out.write("</form>  \r\n");
      out.write("        </fieldset>\r\n");
      out.write("   ");
 
    	}
    
    }
   catch (Exception e)
   {
   	e.printStackTrace();
   }
    
    
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
