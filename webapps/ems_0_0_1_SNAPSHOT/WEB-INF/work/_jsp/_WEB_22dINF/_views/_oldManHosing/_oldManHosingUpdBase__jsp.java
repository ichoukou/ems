/*
 * JSP generated by Resin-4.0.36 (built Fri, 26 Apr 2013 03:31:59 PDT)
 */

package _jsp._WEB_22dINF._views._oldManHosing;
import javax.servlet.*;
import javax.servlet.jsp.*;
import javax.servlet.http.*;

public class _oldManHosingUpdBase__jsp extends com.caucho.jsp.JavaPage
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
    out.write(_jsp_string1, 0, _jsp_string1.length);
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
    depend = new com.caucho.vfs.Depend(appDir.lookup("WEB-INF/views/oldManHosing/oldManHosingUpdBase.jsp"), -2827642847123666425L, false);
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

  private final static char []_jsp_string1;
  private final static char []_jsp_string0;
  static {
    _jsp_string1 = "            </td>\r\n                            <td align=\"right\">\u8001\u4eba\u624b\u673a\uff1a</td>\r\n                            <td>\r\n                                <input onblur=\"updCheckMobilePhone()\" name=\"updfoldManMobile\" type=\"text\" maxlength=\"11\" id=\"updfoldManMobile\"  required style=\"width: 90px;height: 23px\">\r\n                                <label id=\"upd_foldManMobile_base\" style=\"color: red;width:10px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                            </td>\r\n                            <td align=\"right\">\u5165\u4f4f\u65e5\u671f\uff1a</td>\r\n                            <td>\r\n                                <input onFocus=\"WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})\" name=\"fcheckinTime\" type=\"text\" maxlength=\"10\" id=\"updfcheckinTime\"  required style=\"width: 90px;height: 23px\">\r\n                                \r\n                            </td>\r\n                        </tr>\r\n\r\n                        <tr>\r\n                            <td align=\"right\">\u6240\u4f4f\u5927\u53a6\uff1a</td>\r\n                            <td>\r\n                                <select  onblur=\"updCheck_buildingID_base()\" name=\"fbuildingID\" id=\"updfbuildingID\" style=\"width: 90px;height: 23px\">\r\n\r\n                                </select>\r\n                                <label id=\"upd_build_base\" style=\"color: red;width:10px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n\r\n                            </td>\r\n\r\n                            <td align=\"right\">\u6240\u4f4f\u623f\u95f4\uff1a</td>\r\n                            <td>\r\n                                <select  onblur=\"updCheck_roomID_base()\" id=\"updfroomID\">\r\n\r\n                                </select>\r\n                                <label id=\"upd_froomID_base\" style=\"color: red;width:10px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                            </td>\r\n                            <td align=\"right\">\u6240\u4f4f\u5e8a\u4f4d\uff1a</td>\r\n                            <td colspan=\"2\">\r\n                                <select id=\"updfbedID\" onchange=\"addBedPrice()\" style=\"width: 90px\">\r\n\r\n                                </select>\r\n                                \r\n                                <input value=\"9\" name=\"updfisEntire\" id=\"updfisEntire\" type=\"checkbox\" onclick=\"myUpdGray(this)\"/>\u6574\u79df\r\n                            </td>\r\n\r\n                        </tr>\r\n\r\n                        <tr>\r\n                            <td align=\"right\">\u8eab\u4efd\u8bc1\u53f7\uff1a</td>\r\n                            <td>\r\n                                <input  onblur=\"updCheck_cardId_base()\" id=\"updfoldManIdCard\" type=\"text\" maxlength=\"18\" id=\"\" placeholder=\"\u5fc5\u586b\u9879\" required style=\"width: 135px;height: 23px\">\r\n                                <label id=\"upd_cardId_base\" style=\"color: red;width:10px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                            </td>\r\n\r\n                            <td align=\"right\">\u62a4\u7406\u7ea7\u522b\uff1a</td>\r\n                            <td colspan=\"2\">\r\n                                <input type=\"text\" id=\"updfnursingLevel\" name=\"fnursingLevel\" style=\"width: 90px;height: 23px\">\r\n                                \r\n                                <button id=\"btn_add\" type=\"button\" data-toggle=\"modal\" data-target=\"#addModal\" onclick=\"showName()\" >\r\n                                    <span  aria-hidden=\"true\"></span>\u5b9a\u7ea7\r\n                                </button>\r\n                            </td>\r\n\r\n                        </tr>\r\n                        <tr>\r\n                            <td align=\"right\">\u6237\u7c4d\uff1a</td>\r\n                            <td colspan=\"8\">\r\n                                <input onblur=\"updCheck_oldManNative_base()\" type=\"text\" maxlength=\"200\" id=\"updfoldManNative\"  required style=\"width: 710px;height: 23px\">\r\n                                <label id=\"upd_foldManNative_base\" style=\"color: red;width:10px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                            </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td align=\"right\">\u8bf4\u660e\uff1a</td>\r\n                            <td colspan=\"8\">\r\n                                <textarea style=\"width: 710px;\" name=\"fInstruction\" id=\"updfInstruction\"></textarea>\r\n                            </td>\r\n                        </tr>\r\n                        <tr>\r\n                            <td colspan=\"4\" style=\"text-align:center;vertical-align:middle;\">\r\n                                <button type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">\u5173\u95ed</button>\r\n                            </td>\r\n                            <td colspan=\"4\" style=\"text-align:center;vertical-align:middle;\">\r\n                                <button type=\"button\" class=\"btn btn-primary\" id=\"baseBtn\" onclick=\"updBase()\">\u4fee\u6539</button>\r\n                            </td>\r\n                        </tr>\r\n\r\n                        </tbody>\r\n                    </table>\r\n                </div>\r\n\r\n                </body>\r\n\r\n            </div>\r\n        </div>\r\n\r\n    </div>\r\n</form>".toCharArray();
    _jsp_string0 = "\r\n\r\n<!-- Modal -->\r\n<form id=\"form_validate\" class=\"form-horizontal\">\r\n    <div class=\"modal fade\" id=\"updBaseModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"myModalLabel\" aria-hidden=\"true\">\r\n\r\n        <div class=\"modal-dialog\" style=\"width: 1050px\">\r\n            <div class=\"modal-content\" style=\"height: 500px\">\r\n\r\n                <div class=\"modal-header\">\r\n                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\"><span aria-hidden=\"true\">&times;</span><span class=\"sr-only\">Close</span></button>\r\n                    <h4 class=\"modal-title\" id=\"myModalLabel\">\u4fee\u6539\u8001\u4eba\u57fa\u672c\u4fe1\u606f</h4>\r\n                </div>\r\n\r\n                <head>\r\n                    <title>Title</title>\r\n                    <style>\r\n                        select{\r\n                            width: 90px;\r\n                            height: 23px;\r\n                        }\r\n                    </style>\r\n                </head>\r\n                <body>\r\n                <div class=\"popover-content\" style=\"width: 1000px;\">\r\n                    <table style=\"\">\r\n                        <tbody>\r\n                        <tr>\r\n                            <td></td>\r\n                            <td></td>\r\n                            <td>&nbsp;</td>\r\n                            <td>&nbsp;</td>\r\n                            <td></td>\r\n                            <td></td>\r\n                            <td></td>\r\n                            <td></td>\r\n                            <td rowspan=\"8\" style=\"text-align: center;vertical-align: middle;\">\r\n                                <img id=\"img_2\" src=\"/ems/img/a3.jpg\" style=\"height: 135px;width: 110px;\">\r\n                                <input type=\"file\" name=\"myfiles\" id=\"file_2\" class=\"input_text\" onchange=\"onChangFile('2')\" style=\"width: 110px\">\r\n                                \r\n                            </td>\r\n                        </tr>\r\n                        <tr>\r\n\r\n                            <input id=\"updfid\" type=\"hidden\">\r\n                            <input id=\"fNursingHomeID\" type=\"hidden\" value=\"33\">\r\n                            <td align=\"right\" style=\"width:70px;\">\u8001\u4eba\u7f16\u53f7\uff1a</td>\r\n                            <td style=\"width: 170px\">\r\n                                <input  id=\"updfoldManNum\" type=\"hidden\">\r\n                                <input placeholder=\"\u81ea\u52a8\u751f\u6210\" readonly=\"readonly\" type=\"text\" maxlength=\"4\"  required style=\"width: 90px;height: 23px\">\r\n                            </td>\r\n                            <td align=\"right\" style=\"width:70px;\">\u8001\u4eba\u59d3\u540d\uff1a</td>\r\n                            <td style=\"width: 130px\">\r\n                                <input onblur=\"updCheck_name_base()\" name=\"foldManName\" type=\"text\" maxlength=\"8\" id=\"updfoldManName\" placeholder=\"\u5fc5\u586b\u9879\" required style=\"width: 90px;height: 23px\">\r\n                                <label id=\"upd_name_base\" style=\"color: red;width:10px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n\r\n                            </td>\r\n                            <td align=\"right\" style=\"width:70px;\">\u8001\u4eba\u6027\u522b\uff1a</td>\r\n                            <td>\r\n                                <select name=\"fOldManIDnSex\" id=\"updfOldManIDnSex\">\r\n                                </select>\r\n                            </td>\r\n                            <td align=\"right\" style=\"width:80px;\">&nbsp;\u8001\u4eba\u72b6\u6001\uff1a</td>\r\n                            <td>\r\n                                <select name=\"foldManStatusID\" id=\"updfoldManStatusID\" required style=\"width: 90px;height: 23px\">\r\n\r\n                                </select>\r\n                            </td>\r\n\r\n                        </tr>\r\n\r\n                        <tr>\r\n                            <td align=\"right\">\u8001\u4eba\u804c\u4e1a\uff1a</td>\r\n                            <td>\r\n                                <select id=\"updfoccupation\" name=\"foccupation\">\r\n\r\n                                </select>\r\n                            </td>\r\n                            <td align=\"right\">\u51fa\u751f\u65e5\u671f\uff1a</td>\r\n                            <td>\r\n                                <input onblur=\"updCheck_birth_base()\" onFocus=\"WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})\" type=\"text\" id=\"updfoldManBirth\" style=\"width: 70px;height: 23px\">\r\n                                <label id=\"upd_birth_base\" style=\"color: red;width:10px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                                <input id=\"updfoldManIsLunar\" type=\"checkbox\" value=\"\u519c\u5386\" />\u519c\u5386\r\n                            </td>\r\n                            <td align=\"right\">\u653f\u6cbb\u9762\u8c8c\uff1a</td>\r\n                            <td>\r\n                                <select name=\"foldManPoliticsID\" id=\"updfoldManPoliticsID\">\r\n\r\n                                </select>\r\n                                \r\n                            </td>\r\n                            <td align=\"right\">\u8001\u4eba\u6c11\u65cf\uff1a</td>\r\n                            <td>\r\n                                <select name=\"foldManNationID\" id=\"updfoldManNationID\">\r\n\r\n                                </select>\r\n                            </td>\r\n\r\n                        </tr>\r\n                        <tr>\r\n                            <td align=\"right\">\u5a92\u4f53\u6e20\u9053\uff1a</td>\r\n                            <td>\r\n                                <select name=\"foldManMediaID\" id=\"updfoldManMediaID\">\r\n\r\n                                </select>\r\n                                \r\n                            </td>\r\n\r\n                            <td align=\"right\">\u5408\u540c\u53f7\uff1a</td>\r\n                            <td>\r\n                                <input name=\"fcontractNo\" type=\"text\" maxlength=\"4\" id=\"updfcontractNo\"  required style=\"width: 90px;height: 23px\">\r\n                            </td>\r\n                            <td align=\"right\">\u5408\u540c\u5f00\u59cb\uff1a</td>\r\n                            <td>\r\n                                <input onFocus=\"WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})\" type=\"text\" id=\"updfcontractBegin\" style=\"width: 90px;height: 23px\">\r\n                                \r\n                            </td>\r\n                            <td align=\"right\">\u5408\u540c\u7ed3\u675f\uff1a</td>\r\n                            <td>\r\n                                <input onblur=\"updCheck_contentStopDate_base()\" onFocus=\"WdatePicker({lang:'zh-cn',dateFmt:'yyyy-MM-dd'})\" type=\"text\" id=\"updfcontractEnd\" style=\"width: 90px;height: 23px\">\r\n                                <label id=\"upd_fcontractEnd_base\" style=\"color: red;width:10px;height: auto\">&nbsp;&nbsp;&nbsp;</label>\r\n                            </td>\r\n                        </tr>\r\n\r\n                        <tr>\r\n                            <td align=\"right\">\u533b\u4fdd\u7c7b\u578b\uff1a</td>\r\n                            <td>\r\n                                <select id=\"updfMInsuranceType\" name=\"fMInsuranceType\">\r\n\r\n                                </select>\r\n                                \r\n                            </td>\r\n                            <td align=\"right\">\u8001\u4eba\u5361\u53f7\uff1a</td>\r\n                            <td>\r\n                                <input type=\"text\" maxlength=\"10\" id=\"updfoldManCardNo\"  required style=\"width: 90px;height: 23px\">\r\n                            </td>\r\n                            <td align=\"right\">\u529e\u7406\u4eba\uff1a</td>\r\n                            <td>\r\n                                <input name=\"ftransactor\" type=\"text\" maxlength=\"11\" id=\"updftransactor\"  required style=\"width: 90px;height: 23px\">\r\n                            </td>\r\n                            <td align=\"right\">\u62a4\u7406\u5458\uff1a</td>\r\n                            <td>\r\n                                <input name=\"fnursing\" type=\"text\" maxlength=\"11\" id=\"updfnursing\"  required style=\"width: 90px;height: 23px\">\r\n                            </td>\r\n                        </tr>\r\n\r\n                        <tr>\r\n                            <td align=\"right\">\u8001\u4eba\u4fe1\u4ef0\uff1a</td>\r\n                            <td>\r\n                                <select name=\"foldManBeliefID\" id=\"updfoldManBeliefID\">\r\n\r\n                                </select>\r\n                            </td>\r\n                            <td align=\"right\">\u5165\u4f4f\u7c7b\u578b</td>\r\n                            <td>\r\n                                <select name=\"foldManTypeID\" id=\"updfoldManTypeID\" required style=\"width: 90px;height: 23px\">\r\n\r\n                                </select>\r\n                ".toCharArray();
  }
}