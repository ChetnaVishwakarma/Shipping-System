package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.sql.*;
import com.mysql.jdbc.Driver.*;

public final class notifyorders_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<fieldset>\r\n");
      out.write("\t<legend>Orders</legend>\r\n");
      out.write("\t<form action=\"bookcontainer.jsp\">\r\n");
      out.write("\t\r\n");

String sid =session.getAttribute("sId").toString();

int oid;
try
{	
	Class.forName("com.mysql.jdbc.Driver") ;
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbms", "root", "root");
	
        Statement statement = connection.createStatement() ;
	PreparedStatement ps = connection.prepareStatement(" select * from orders where sId=?");
	ps.setString(1,sid);
        PreparedStatement ps1 = connection.prepareStatement(" select * from orderDetails where oId=?");
	
	
	ResultSet resultset=ps.executeQuery();
	if(!resultset.next())
                       {
        out.print("No orders!!");
                }
        else
                       {
            resultset.beforeFirst();
        while(resultset.next())
	{
		oid=resultset.getInt(1);
                ps1.setInt(1,oid);
                ResultSet rs1=ps1.executeQuery();
	
	
      out.write("\r\n");
      out.write("\t<input type=\"radio\" name=\"oid\" value=\"");
      out.print(oid );
      out.write("\">\r\n");
      out.write("\tOrder Id :");
      out.print(oid );
      out.write("  <br>\r\n");
      out.write("\tConsignee Id : ");
      out.print(resultset.getInt("cId") );
      out.write(" <br>\r\n");
      out.write("\t");

        if(rs1.next())
        {
            
      out.write("\r\n");
      out.write("        Order : ");
      out.print(rs1.getString("oName") );
      out.write(" <br>\r\n");
      out.write("\t");

        }
	

	
	
	} 
	
      out.write("\r\n");
      out.write("        <input type=\"submit\" value=\"Book Container\">\r\n");
      out.write("\t\r\n");
      out.write("\t</form>\r\n");
      out.write("\t</fieldset>\r\n");
      out.write("\t");
 }
}

catch (Exception e)
{
	e.printStackTrace();
} 
      out.write("\r\n");
      out.write(" <input TYPE=\"button\" VALUE=\"Back\" onClick=\"history.go(-1);\"/>\r\n");
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
