/*
 * JSP generated by Resin-4.0.36 (built Fri, 26 Apr 2013 03:31:59 PDT)
 */

package _jsp._WEB_22dINF._views._oldManHosing;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _oldManChargeAdd__jsp extends com.caucho.jsp.JavaPage
{
  private static final java.util.HashMap<String,java.lang.reflect.Method> _jsp_functionMap = new java.util.HashMap<String,java.lang.reflect.Method>();
  private boolean _caucho_isDead;
  private boolean _caucho_isNotModified;
  private com.caucho.jsp.PageManager _jsp_pageManager;
  
  public void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response)
    throws java.io.IOException, javax.servlet.ServletException
  {
    javax.servlet.http.HttpSession session = request.getSession(true);
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, null, session, 8192, true, false);

    TagState _jsp_state = null;

    try {
      _jspService(request, response, pageContext, _jsp_application, session, _jsp_state);
    } catch (java.lang.Throwable _jsp_e) {
      pageContext.handlePageException(_jsp_e);
    } finally {
      _jsp_pageManager.freePageContext(pageContext);
    }
  }
  
  private void
  _jspService(javax.servlet.http.HttpServletRequest request,
              javax.servlet.http.HttpServletResponse response,
              com.caucho.jsp.PageContextImpl pageContext,
              javax.servlet.ServletContext application,
              javax.servlet.http.HttpSession session,
              TagState _jsp_state)
    throws Throwable
  {
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    javax.servlet.jsp.tagext.JspTag _jsp_parent_tag = null;
    com.caucho.jsp.PageContextImpl _jsp_parentContext = pageContext;
    response.setContentType("text/html;charset=UTF-8");

    out.write(_jsp_string0, 0, _jsp_string0.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string1, 0, _jsp_string1.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string2, 0, _jsp_string2.length);
    _caucho_expr_0.print(out, _jsp_env, false);
    out.write(_jsp_string3, 0, _jsp_string3.length);
  }

  private com.caucho.make.DependencyContainer _caucho_depends
    = new com.caucho.make.DependencyContainer();

  public java.util.ArrayList<com.caucho.vfs.Dependency> _caucho_getDependList()
  {
    return _caucho_depends.getDependencies();
  }

  public void _caucho_addDepend(com.caucho.vfs.PersistentDependency depend)
  {
    super._caucho_addDepend(depend);
    _caucho_depends.add(depend);
  }

  protected void _caucho_setNeverModified(boolean isNotModified)
  {
    _caucho_isNotModified = true;
  }

  public boolean _caucho_isModified()
  {
    if (_caucho_isDead)
      return true;

    if (_caucho_isNotModified)
      return false;

    if (com.caucho.server.util.CauchoSystem.getVersionId() != -1842010395327194821L)
      return true;

    return _caucho_depends.isModified();
  }

  public long _caucho_lastModified()
  {
    return 0;
  }

  public void destroy()
  {
      _caucho_isDead = true;
      super.destroy();
    TagState tagState;
  }

  public void init(com.caucho.vfs.Path appDir)
    throws javax.servlet.ServletException
  {
    com.caucho.vfs.Path resinHome = com.caucho.server.util.CauchoSystem.getResinHome();
    com.caucho.vfs.MergePath mergePath = new com.caucho.vfs.MergePath();
    mergePath.addMergePath(appDir);
    mergePath.addMergePath(resinHome);
    com.caucho.loader.DynamicClassLoader loader;
    loader = (com.caucho.loader.DynamicClassLoader) getClass().getClassLoader();
    String resourcePath = loader.getResourcePathSpecificFirst();
    mergePath.addClassPath(resourcePath);
    com.caucho.vfs.Depend depend;
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/views/oldManHosing/oldManChargeAdd.jsp"), -6259753752196859986L, false);
    _caucho_depends.add(depend);
  }

  final static class TagState {

    void release()
    {
    }
  }

  public java.util.HashMap<String,java.lang.reflect.Method> _caucho_getFunctionMap()
  {
    return _jsp_functionMap;
  }

  public void caucho_init(ServletConfig config)
  {
    try {
      com.caucho.server.webapp.WebApp webApp
        = (com.caucho.server.webapp.WebApp) config.getServletContext();
      init(config);
      if (com.caucho.jsp.JspManager.getCheckInterval() >= 0)
        _caucho_depends.setCheckInterval(com.caucho.jsp.JspManager.getCheckInterval());
      _jsp_pageManager = webApp.getJspApplicationContext().getPageManager();
      com.caucho.jsp.TaglibManager manager = webApp.getJspApplicationContext().getTaglibManager();
      com.caucho.jsp.PageContextImpl pageContext = new com.caucho.jsp.InitPageContextImpl(webApp, this);
      _caucho_expr_0 = com.caucho.jsp.JspUtil.createExpr(pageContext.getELContext(), "${pageContext.request.contextPath}");
    } catch (Exception e) {
      throw com.caucho.config.ConfigException.create(e);
    }
  }
  private static com.caucho.el.Expr _caucho_expr_0;

  private final static char []_jsp_string2;
  private final static char []_jsp_string3;
  private final static char []_jsp_string1;
  private final static char []_jsp_string0;
  static {
    _jsp_string2 = "/script/lib/H+/js/bootstrap.min.js?v=3.3.6\"></script>\r\n    <script src=\"".toCharArray();
    _jsp_string3 = "/script/lib/bootstrap-multiselect/dist/js/bootstrap-multiselect.js\"></script>\r\n    \r\n        \r\n    \r\n    <script type=\"text/javascript\">\r\n\r\n    </script>\r\n</head>\r\n\r\n<body>\r\n    <div id=\"\">\r\n        <input id=\"oldManChargeId\" type=\"hidden\">\r\n\r\n        <div class=\"col-xs-5\">\r\n            <div style=\"text-align: center;font-size: 20px;\">\u5f85\u9009\u8d39\u7528</div>\r\n            <select name=\"from\" id=\"undo_redo\" class=\"form-control\" size=\"13\"\r\n                    multiple=\"multiple\">\r\n\r\n            </select>\r\n        </div>\r\n\r\n        <div class=\"col-xs-2\" style=\"padding-top: 60px;\">\r\n\r\n            <button type=\"hidden\" id=\"undo_redo_rightAll\"\r\n                    class=\"btn btn-default btn-block\">\r\n                <i class=\"glyphicon glyphicon-forward\"></i>\r\n            </button>\r\n            <button type=\"button\" id=\"undo_redo_rightSelected\"\r\n                    class=\"btn btn-default btn-block\">\r\n                <i class=\"glyphicon glyphicon-chevron-right\"></i>\r\n            </button>\r\n            <button type=\"button\" id=\"undo_redo_leftSelected\"\r\n                    class=\"btn btn-default btn-block\">\r\n                <i class=\"glyphicon glyphicon-chevron-left\"></i>\r\n            </button>\r\n            <button type=\"hidden\" id=\"undo_redo_leftAll\"\r\n                    class=\"btn btn-default btn-block\">\r\n                <i class=\"glyphicon glyphicon-backward\"></i>\r\n            </button>\r\n\r\n        </div>\r\n\r\n        <div class=\"col-xs-5\">\r\n            <div style=\"text-align: center;font-size: 20px;\">\u5df2\u9009\u8d39\u7528</div>\r\n            <select name=\"to\" id=\"undo_redo_to\" class=\"form-control\"\r\n                    size=\"13\" multiple=\"multiple\"></select>\r\n        </div>\r\n\r\n        <div class=\"col-xs-2\">\r\n        </div>\r\n        <div class=\"col-xs-2\">\r\n            <button class=\"btn btn-warning btn-block\" id=\"b2\" onclick=\"updChargeStatus(this.value,false)\" value=\"0\">\u505c\u6b62\u5df2\u9009\u8d39\u7528</button>\r\n        </div>\r\n\r\n        <div class=\"col-xs-4\">\r\n            \u603b\u8d39\u7528\uff1a<input type=\"text\" id=\"totalCost\">\r\n        </div>\r\n\r\n        <div class=\"col-xs-2\">\r\n            <button class=\"btn btn-primary btn-block\" id=\"b1\" onclick=\"updChargeStatus(this.value,true)\" value=\"1\">\u4fdd\u5b58\u5df2\u9009\u8d39\u7528</button>\r\n        </div>\r\n    </div>\r\n</body>\r\n\r\n</html>\r\n".toCharArray();
    _jsp_string1 = "/script/lib/H+/js/jquery.min.js?v=2.1.4\"></script>\r\n    <script src=\"".toCharArray();
    _jsp_string0 = "\r\n\r\n\r\n\r\n<html>\r\n<head>\r\n    <title>\u8d39\u7528\u4fe1\u606f</title>\r\n    <!-- \u5168\u5c40js -->\r\n    <script src=\"".toCharArray();
  }
}