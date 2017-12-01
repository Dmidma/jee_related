package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import database.entityclasses.Member1Facade;
import database.entityclasses.Member1FacadeLocal;
import database.Member1;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Connect Me</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>Weclome To Scrum Platfrom</h1>\n");
      out.write("        ");
      database.entityclasses.Member1FacadeLocal useme = null;
      synchronized (_jspx_page_context) {
        useme = (database.entityclasses.Member1FacadeLocal) _jspx_page_context.getAttribute("useme", PageContext.PAGE_SCOPE);
        if (useme == null){
          try {
            useme = (database.entityclasses.Member1FacadeLocal) java.beans.Beans.instantiate(this.getClass().getClassLoader(), "database.entityclasses.Member1FacadeLocal");
          } catch (ClassNotFoundException exc) {
            throw new InstantiationException(exc.getMessage());
          } catch (Exception exc) {
            throw new ServletException("Cannot create bean of class " + "database.entityclasses.Member1FacadeLocal", exc);
          }
          _jspx_page_context.setAttribute("useme", useme, PageContext.PAGE_SCOPE);
          out.write("\n");
          out.write("            \n");
          out.write("            ");
 
                
                List<Member1> l = useme.findAll();
                    for (Member1 i : l) {
                out.println(i.getName());
                out.println("<br/>");
            }
            
          out.write("\n");
          out.write("        ");
        }
      }
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
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
