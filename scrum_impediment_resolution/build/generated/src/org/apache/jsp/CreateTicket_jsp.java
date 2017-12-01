package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class CreateTicket_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_transaction_dataSource;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_update_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_query_var;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_sql_transaction_dataSource = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_update_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_query_var = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_sql_transaction_dataSource.release();
    _jspx_tagPool_sql_update_var.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_sql_query_var.release();
    _jspx_tagPool_c_if_test.release();
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.release();
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

      out.write('\n');
      out.write("\n");
      out.write("      ");
 
           String user_id = (String) session.getAttribute("connected_user");
          
          
           if (user_id == null) {
               response.setStatus(response.SC_MOVED_TEMPORARILY);
               response.setHeader("Location", "/scrum_impediment_resolution/ConnectMe");
               return;
           }
               
           int id_user = Integer.parseInt(user_id);
         
      out.write("    \n");
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
      out.write("        <title>Ticket Creation</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("    <style type=\"text/css\">\n");
      out.write("        html, body, #wrapper{\n");
      out.write("            height: 100%;\n");
      out.write("        }\n");
      out.write("    </style>\n");
      out.write("    </head>\n");
      out.write("     \n");
      out.write("        \n");
      out.write("          <div id=\"wrapper\">\n");
      out.write("        <header>\n");
      out.write("            <nav class=\"navbar navbar-default\">\n");
      out.write("                <div class=\"container-fluid\">\n");
      out.write("                    <div class=\"navbar-header\">\n");
      out.write("                      <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#MENU\" aria-expanded=\"false\">\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                      </button>\n");
      out.write("                        <span class=\"navbar-brand\"><span >Scrum Impediment Resolution</span></span>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"MENU\">\n");
      out.write("                      <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                        <li><a href=\"/scrum_impediment_resolution/Profile\">Profile</a></li>\n");
      out.write("                      </ul>\n");
      out.write("                    <div class=\"cleafix\"></div>\n");
      out.write("                </div>\n");
      out.write("            </nav>\n");
      out.write("        </header>\n");
      out.write("        <div class=\"container\">\n");
      out.write("\n");
      out.write("            <div class=\"row\">\n");
      out.write("                <div class=\"col-md-8 col-md-offset-2\">\n");
      out.write("                    <div class=\"panel panel-primary\">\n");
      out.write("                        <div class=\"panel-heading\">\n");
      out.write("         <h3>Create Ticket</h3>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"panel-body\">\n");
      out.write("         <form class=\"form\" action=\"/scrum_impediment_resolution/connected/CreateTicket.jsp\" method=\"post\">\n");
      out.write("             \n");
      out.write("             \n");
      out.write("             <div class=\"form-group\">\n");
      out.write("                                <label for=\"subject\">Subject</label>\n");
      out.write("                                <input type=\"text\" name=\"subject\" class=\"form-control\" id=\"subject\">\n");
      out.write("\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"form-group\">\n");
      out.write("                                <label for=\"description\">Description</label>\n");
      out.write("                                <textarea name=\"description\" class=\"form-control\" id=\"description\"></textarea>\n");
      out.write("\n");
      out.write("                              </div>\n");
      out.write("                              <div class=\"form-group\">\n");
      out.write("                                <label for=\"prio\">Priority</label>\n");
      out.write("                                <select name=\"priority\" class=\"form-control\" id=\"prio\">\n");
      out.write("                                    <option>minor</option>\n");
      out.write("                                    <option>Moderate</option>\n");
      out.write("                                    <option>critical</option>\n");
      out.write("                                </select>\n");
      out.write("                              </div>\n");
      out.write("                              <button type=\"submit\" class=\"btn btn-default\">Create</button>\n");
      out.write("      \n");
      out.write("         </form>\n");
      out.write("                            </div>\n");
      out.write("                        <div class=\"panel-footer\">\n");
      out.write("                            <p><small><center>Scrum Ticketing</center></small></p>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("    </div>\n");
      out.write("    <footer>\n");
      out.write("            <p>XYZ PEOPLE</p>\n");
      out.write("    </footer>\n");
      out.write("         \n");
      out.write("         ");
      database.Impediment imp = null;
      synchronized (_jspx_page_context) {
        imp = (database.Impediment) _jspx_page_context.getAttribute("imp", PageContext.PAGE_SCOPE);
        if (imp == null){
          imp = new database.Impediment();
          _jspx_page_context.setAttribute("imp", imp, PageContext.PAGE_SCOPE);
          out.write("\n");
          out.write("             ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("imp"), "subject", request.getParameter("subject"), request, "subject", false);
          out.write("\n");
          out.write("             ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("imp"), "description", request.getParameter("description"), request, "description", false);
          out.write("\n");
          out.write("             ");
          org.apache.jasper.runtime.JspRuntimeLibrary.introspecthelper(_jspx_page_context.findAttribute("imp"), "priority", request.getParameter("priority"), request, "priority", false);
          out.write("\n");
          out.write("            \n");
          out.write("            ");
          //  c:if
          org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
          _jspx_th_c_if_0.setPageContext(_jspx_page_context);
          _jspx_th_c_if_0.setParent(null);
          _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${imp.subject != null}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
          int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
          if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\n");
              out.write("             \n");
              out.write("                \n");
              out.write("                 ");
              if (_jspx_meth_sql_setDataSource_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
                return;
              out.write("\n");
              out.write("                ");
              //  sql:transaction
              org.apache.taglibs.standard.tag.rt.sql.TransactionTag _jspx_th_sql_transaction_0 = (org.apache.taglibs.standard.tag.rt.sql.TransactionTag) _jspx_tagPool_sql_transaction_dataSource.get(org.apache.taglibs.standard.tag.rt.sql.TransactionTag.class);
              _jspx_th_sql_transaction_0.setPageContext(_jspx_page_context);
              _jspx_th_sql_transaction_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
              _jspx_th_sql_transaction_0.setDataSource((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${connect_table}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
              int[] _jspx_push_body_count_sql_transaction_0 = new int[] { 0 };
              try {
                int _jspx_eval_sql_transaction_0 = _jspx_th_sql_transaction_0.doStartTag();
                if (_jspx_eval_sql_transaction_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                  do {
                    out.write("\n");
                    out.write("                    ");
                    if (_jspx_meth_sql_update_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_sql_transaction_0, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
                      return;
                    out.write("\n");
                    out.write("                    ");
                    if (_jspx_meth_sql_query_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_sql_transaction_0, _jspx_page_context, _jspx_push_body_count_sql_transaction_0))
                      return;
                    out.write("\n");
                    out.write("                    ");
                    //  sql:update
                    org.apache.taglibs.standard.tag.rt.sql.UpdateTag _jspx_th_sql_update_1 = (org.apache.taglibs.standard.tag.rt.sql.UpdateTag) _jspx_tagPool_sql_update_var.get(org.apache.taglibs.standard.tag.rt.sql.UpdateTag.class);
                    _jspx_th_sql_update_1.setPageContext(_jspx_page_context);
                    _jspx_th_sql_update_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sql_transaction_0);
                    _jspx_th_sql_update_1.setVar("ticket");
                    int[] _jspx_push_body_count_sql_update_1 = new int[] { 0 };
                    try {
                      int _jspx_eval_sql_update_1 = _jspx_th_sql_update_1.doStartTag();
                      if (_jspx_eval_sql_update_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                        if (_jspx_eval_sql_update_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                          out = _jspx_page_context.pushBody();
                          _jspx_push_body_count_sql_update_1[0]++;
                          _jspx_th_sql_update_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                          _jspx_th_sql_update_1.doInitBody();
                        }
                        do {
                          out.write("\n");
                          out.write("                        INSERT INTO member_ticket (id_impediment, id_member) VALUES (LAST_INSERT_ID(), ");
                          out.print(id_user);
                          out.write(");\n");
                          out.write("                    ");
                          int evalDoAfterBody = _jspx_th_sql_update_1.doAfterBody();
                          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                            break;
                        } while (true);
                        if (_jspx_eval_sql_update_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                          out = _jspx_page_context.popBody();
                          _jspx_push_body_count_sql_update_1[0]--;
                      }
                      if (_jspx_th_sql_update_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                        return;
                      }
                    } catch (Throwable _jspx_exception) {
                      while (_jspx_push_body_count_sql_update_1[0]-- > 0)
                        out = _jspx_page_context.popBody();
                      _jspx_th_sql_update_1.doCatch(_jspx_exception);
                    } finally {
                      _jspx_th_sql_update_1.doFinally();
                      _jspx_tagPool_sql_update_var.reuse(_jspx_th_sql_update_1);
                    }
                    out.write("\n");
                    out.write("                ");
                    int evalDoAfterBody = _jspx_th_sql_transaction_0.doAfterBody();
                    if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                      break;
                  } while (true);
                }
                if (_jspx_th_sql_transaction_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
                  return;
                }
              } catch (Throwable _jspx_exception) {
                while (_jspx_push_body_count_sql_transaction_0[0]-- > 0)
                  out = _jspx_page_context.popBody();
                _jspx_th_sql_transaction_0.doCatch(_jspx_exception);
              } finally {
                _jspx_th_sql_transaction_0.doFinally();
                _jspx_tagPool_sql_transaction_dataSource.reuse(_jspx_th_sql_transaction_0);
              }
              out.write("\n");
              out.write("                        \n");
              out.write("                        \n");
              out.write("                        ");
              if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context))
                return;
              out.write(" \n");
              out.write("            ");
              int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
            _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
            return;
          }
          _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
          out.write("\n");
          out.write("         ");
        }
      }
      out.write("\n");
      out.write("         \n");
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

  private boolean _jspx_meth_sql_setDataSource_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:setDataSource
    org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag _jspx_th_sql_setDataSource_0 = (org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag) _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.get(org.apache.taglibs.standard.tag.rt.sql.SetDataSourceTag.class);
    _jspx_th_sql_setDataSource_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_setDataSource_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_sql_setDataSource_0.setVar("connect_table");
    _jspx_th_sql_setDataSource_0.setDriver("com.mysql.jdbc.Driver");
    _jspx_th_sql_setDataSource_0.setUrl("jdbc:mysql://localhost/impediment_resolution");
    _jspx_th_sql_setDataSource_0.setUser("testuser");
    _jspx_th_sql_setDataSource_0.setPassword("password");
    int _jspx_eval_sql_setDataSource_0 = _jspx_th_sql_setDataSource_0.doStartTag();
    if (_jspx_th_sql_setDataSource_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.reuse(_jspx_th_sql_setDataSource_0);
      return true;
    }
    _jspx_tagPool_sql_setDataSource_var_user_url_password_driver_nobody.reuse(_jspx_th_sql_setDataSource_0);
    return false;
  }

  private boolean _jspx_meth_sql_update_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sql_transaction_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:update
    org.apache.taglibs.standard.tag.rt.sql.UpdateTag _jspx_th_sql_update_0 = (org.apache.taglibs.standard.tag.rt.sql.UpdateTag) _jspx_tagPool_sql_update_var.get(org.apache.taglibs.standard.tag.rt.sql.UpdateTag.class);
    _jspx_th_sql_update_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_update_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sql_transaction_0);
    _jspx_th_sql_update_0.setVar("insertion");
    int[] _jspx_push_body_count_sql_update_0 = new int[] { 0 };
    try {
      int _jspx_eval_sql_update_0 = _jspx_th_sql_update_0.doStartTag();
      if (_jspx_eval_sql_update_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_update_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_update_0[0]++;
          _jspx_th_sql_update_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_update_0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("                    INSERT INTO impediment (subject, description, priority) VALUES (\n");
          out.write("                    \"");
          out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((database.Impediment)_jspx_page_context.findAttribute("imp")).getSubject())));
          out.write("\",\n");
          out.write("                    \"");
          out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((database.Impediment)_jspx_page_context.findAttribute("imp")).getDescription())));
          out.write("\",\n");
          out.write("                    \"");
          out.write(org.apache.jasper.runtime.JspRuntimeLibrary.toString((((database.Impediment)_jspx_page_context.findAttribute("imp")).getPriority())));
          out.write("\");\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_sql_update_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_update_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_update_0[0]--;
      }
      if (_jspx_th_sql_update_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_update_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_update_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_update_0.doFinally();
      _jspx_tagPool_sql_update_var.reuse(_jspx_th_sql_update_0);
    }
    return false;
  }

  private boolean _jspx_meth_sql_query_0(javax.servlet.jsp.tagext.JspTag _jspx_th_sql_transaction_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_sql_transaction_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  sql:query
    org.apache.taglibs.standard.tag.rt.sql.QueryTag _jspx_th_sql_query_0 = (org.apache.taglibs.standard.tag.rt.sql.QueryTag) _jspx_tagPool_sql_query_var.get(org.apache.taglibs.standard.tag.rt.sql.QueryTag.class);
    _jspx_th_sql_query_0.setPageContext(_jspx_page_context);
    _jspx_th_sql_query_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_sql_transaction_0);
    _jspx_th_sql_query_0.setVar("last_id");
    int[] _jspx_push_body_count_sql_query_0 = new int[] { 0 };
    try {
      int _jspx_eval_sql_query_0 = _jspx_th_sql_query_0.doStartTag();
      if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
          out = _jspx_page_context.pushBody();
          _jspx_push_body_count_sql_query_0[0]++;
          _jspx_th_sql_query_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
          _jspx_th_sql_query_0.doInitBody();
        }
        do {
          out.write("\n");
          out.write("                        SELECT LAST_INSERT_ID() AS id;\n");
          out.write("                    ");
          int evalDoAfterBody = _jspx_th_sql_query_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
        if (_jspx_eval_sql_query_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
          out = _jspx_page_context.popBody();
          _jspx_push_body_count_sql_query_0[0]--;
      }
      if (_jspx_th_sql_query_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_sql_query_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_sql_query_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_sql_query_0.doFinally();
      _jspx_tagPool_sql_query_var.reuse(_jspx_th_sql_query_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ticket > 0}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                            ");
        if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("    \n");
        out.write("                        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_out_0.setValue(new String("<h3>Something went wrong, please Repeat!</h3>"));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }
}
