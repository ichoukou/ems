/*
 * JSP generated by Resin-4.0.36 (built Fri, 26 Apr 2013 03:31:59 PDT)
 */

package _jsp._WEB_22dINF._views._empRewards;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _empRewardsUpdate__jsp extends com.caucho.jsp.JavaPage
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
    com.caucho.server.webapp.WebApp _jsp_application = _caucho_getApplication();
    com.caucho.jsp.PageContextImpl pageContext = _jsp_pageManager.allocatePageContext(this, _jsp_application, request, response, null, null, 8192, true, false);

    TagState _jsp_state = null;

    try {
      _jspService(request, response, pageContext, _jsp_application, _jsp_state);
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
              TagState _jsp_state)
    throws Throwable
  {
    javax.servlet.jsp.JspWriter out = pageContext.getOut();
    final javax.el.ELContext _jsp_env = pageContext.getELContext();
    javax.servlet.ServletConfig config = getServletConfig();
    javax.servlet.Servlet page = this;
    javax.servlet.jsp.tagext.JspTag _jsp_parent_tag = null;
    com.caucho.jsp.PageContextImpl _jsp_parentContext = pageContext;
    response.setContentType("text/html; charset=UTF-8");

    out.write(_jsp_string0, 0, _jsp_string0.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/views/empRewards/empRewardsUpdate.jsp"), 2049888258738472393L, false);
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
    } catch (Exception e) {
      throw com.caucho.config.ConfigException.create(e);
    }
  }

  private final static char []_jsp_string0;
  static {
    _jsp_string0 = "\r\n<style>\r\n    .modal-content{\r\n        background-color:#F0F0F0;\r\n    }\r\n</style>\r\n<!-- Modal -->\r\n<form id=\"form_validate\" class=\"form-horizontal\">\r\n    <div class=\"modal fade\" id=\"updateModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n        <div class=\"modal-dialog\" id=\"modal\">\r\n            <div class=\"modal-content\">\r\n                <div class=\"modal-header\">\r\n                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>\r\n                    <h4 class=\"modal-title\" id=\"myModalLabel\">\u66f4\u65b0\u5956\u60e9</h4>\r\n                </div>\r\n                <div class=\"modal-body\">\r\n                    <input type=\"hidden\" id=\"Rewards_id\">\r\n                    <div class=\"form-group row\">\r\n                        <label for=\"updateFStaffName\" class=\"col-sm-2 control-label\">\u5458\u5de5\u59d3\u540d</label>\r\n                        <div class=\"col-sm-4\">\r\n                            <select class=\"form-control\" id=\"updateFStaffName\"name=\"updateFStaffName\">\r\n                            </select>\r\n                            <label id=\"update_FStaffName_message\" style=\"color: red;width: 140px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                        </div>\r\n                        <label for=\"updateFRewardDate\" class=\"col-sm-2 control-label\">\u65e5\u671f</label>\r\n                        <div class=\"col-sm-4\">\r\n                            <input class=\"form-control\" onblur=\"update_FRewardDate()\" onFocus=\"WdatePicker({readOnly:true,maxDate:new Date()})\" type=\"text\" id=\"updateFRewardDate\">\r\n                            <label id=\"update_FRewardDate_message\" style=\"color: red;width: 140px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                        </div>\r\n                    </div>\r\n                    <div class=\"form-group row\">\r\n                        <label for=\"updateFRewardType\" class=\"col-sm-2 control-label\">\u5956\u60e9\u7c7b\u578b</label>\r\n                        <div class=\"col-sm-4\">\r\n                            <select onblur=\"update_FRewardType()\" class=\"form-control\" id=\"updateFRewardType\"name=\"updateFRewardType\">\r\n                            </select>\r\n                            <label id=\"update_FRewardType_message\" style=\"color: red;width: 140px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                        </div>\r\n                        <label for=\"updateFRewardMoney\" class=\"col-sm-2 control-label\">\u91d1\u989d</label>\r\n                        <div class=\"col-sm-4\">\r\n                            <input onblur=\"update_FRewardMoney()\" class=\"form-control\" type=\"text\" id=\"updateFRewardMoney\">\r\n                            <label id=\"update_FRewardMoney_message\" style=\"color: red;width: 140px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                        </div>\r\n                    </div>\r\n                    <div class=\"form-group row\">\r\n                        <label for=\"updateFRewardReason\" class=\"col-sm-2 control-label\">\u5956\u60e9\u539f\u56e0</label>\r\n                        <div class=\"col-sm-4\">\r\n                            <textarea style=\"resize:none;\" class=\"form-control\" name=\"updateFRewardReason\" id=\"updateFRewardReason\" placeholder=\"\u5956\u60e9\u539f\u56e0\"></textarea>\r\n                        </div>\r\n                        <label for=\"updateFExplain\" class=\"col-sm-2 control-label\">\u8bf4\u660e</label>\r\n                        <div class=\"col-sm-4\">\r\n                            <textarea style=\"resize:none;\" class=\"form-control\" name=\"updateFExplain\" id=\"updateFExplain\" placeholder=\"\u8bf4\u660e\"></textarea>\r\n                        </div>\r\n                    </div>\r\n                </div>\r\n                <div class=\"modal-footer\">\r\n                    <button id=\"update_close_btn\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">\u5173\u95ed</button>\r\n                    <button type=\"button\" class=\"btn btn-primary\" onclick=\"updateRewards()\">\u4fdd\u5b58</button>\r\n                </div>\r\n            </div>\r\n        </div>\r\n\r\n    </div>\r\n</form>".toCharArray();
  }
}
