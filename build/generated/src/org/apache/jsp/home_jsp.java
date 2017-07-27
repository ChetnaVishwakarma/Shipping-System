package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Home</title>\n");
      out.write("        <style>\n");
      out.write("            button{\n");
      out.write("                width: 90px;\n");
      out.write("                \n");
      out.write("                height: 50px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"margin-left: 30\">\n");
      out.write("        <h1>Home</h1>\n");
      out.write("        <a href='addContainer.jsp'><button>Add Containers</button></a><br/><br/>\n");
      out.write("        <a href='addShip.jsp'><button>Add Ships</button></a><br/><br/>\n");
      out.write("        <a href='addPort.jsp'><button>Add Port</button></a><br/><br/>\n");
      out.write("        <a href='addRoute.jsp'><button>Add Route</button></a><br/><br/>\n");
      out.write("        <a href='trackship.jsp'><button>Track Ship</button></a><br/><br/>\n");
      out.write("        <a href='trackorder.jsp'><button>Track Order</button></a><br/><br/>\n");
      out.write("        <a href='showContainers.jsp'><button>Show Containers</button></a><br/><br/>\n");
      out.write("        <a href='showPorts.jsp'><button>Show Ports</button></a><br/><br/>\n");
      out.write("        <a href='showRoutes.jsp'><button>Show Routes</button></a><br/><br/>\n");
      out.write("        <a href='showShips.jsp'><button>Show Ships</button></a><br/><br/>\n");
      out.write("        <a href='showShips.jsp'><button>Show Ships</button></a><br/><br/>\n");
      out.write("        <a href='selectShip.jsp'><button>Discharge containers</button></a><br/><br/>\n");
      out.write("        <a href='logout.jsp'><button>Log out</button></a><br/><br/>\n");
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
