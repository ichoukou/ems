package com.channelsoft.ems.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.channelsoft.ems.common.MD5;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.MenuPo;
import com.channelsoft.ems.po.MessagePo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.EmpMessageService;
import com.channelsoft.ems.service.LoginService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService loginService;



	/** 
	 * 
	 * 登录
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
    @RequestMapping("/index")
    public String checkLogin(UserPo user, HttpServletRequest request, HttpServletResponse response) {

        try {

            String md5 = new MD5().getMD5ofString(user.getPassWord());
            user.setPassWord(md5);


            List<UserPo> list = this.loginService.queryLogin(user);


            if (list.size() != 0) {
                //可以直接查询权限 直接获取权限菜单


                logger.debug("可以进行查询 权限");
                List<Map<String,String>> list3=this.loginService.queryMenu(list.get(0));
                //进行循环  传递字符串
                if(list3.size()==0){
                    request.setAttribute("msg", "该用户未分配权限");
                    return "login";
                }
                String roleid=list3.get(0).get("s_menuid");
                logger.debug(roleid);
                //如果登录用户没有权限


                List<MenuPo> list2= this.loginService.queryAllMenu(roleid);

                String [] QC_URL=new String[list2.size()];

                for(int i=0;i<QC_URL.length;i++){
                    QC_URL[i]=list2.get(i).getSurl()+"/";
                }

                request.getSession().setAttribute("loginUser", list.get(0));

                request.getSession().setAttribute("QC_URL",QC_URL);

                UserPo user1=(UserPo)request.getSession().getAttribute("loginUser");
                request.getSession().setAttribute("list",list2);
                return "index";
            } else {
                request.setAttribute("msg", "用户名密码错误");
               return "login";
            }

        } catch (Exception e) {
            request.setAttribute("loginError", e.getMessage());
            return "login";
        }
    }
    
    /** 
	 * 
	 * 退出
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */

    @RequestMapping("/quit")
    public String quitLogin(UserPo user, HttpServletRequest request,
                            HttpServletResponse response) {
        request.getSession().removeAttribute("loginUser");
        request.getSession().removeAttribute("QC_URL");
        request.setAttribute("msg", "成功退出");

        return "login";

    }

    /** 
	 * 
	 * 查看个人资料
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
    @RequestMapping("/User")
    public String gotoUser(HttpServletRequest request ,HttpServletResponse response){
        UserPo user=(UserPo) request.getSession().getAttribute("loginUser");
        String creator=user.getEmployId();
        MessagePo messagePo=new MessagePo();
         messagePo.setfId(creator);
        List<MessagePo> list= this.loginService.getList(messagePo);
         request.setAttribute("list1",list);

        return "userMessage";
    }

    /** 
	 * 
	 * 修改密码
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
    @RequestMapping("/Pass")
    public String gotoPass( HttpServletRequest request ,HttpServletResponse response){
     /*   UserPo user=(UserPo) request.getSession().getAttribute("loginUser");

        String md5 = new MD5().getMD5ofString(po.getPassWord());
        po.setPassWord(md5);*/

        return "modifyPassword";


    }
    
    /** 
	 * 
	 * 核对密码
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */

    @RequestMapping("/CheckPass")
    @ResponseBody
    public String CheckPass(  UserPo user,HttpServletRequest request ,HttpServletResponse response) throws IOException {
        logger.debug("传进来的参数为"+user);

        String md5 = new MD5().getMD5ofString(user.getPassWord());
        user.setPassWord(md5);

        UserPo user1=(UserPo) request.getSession().getAttribute("loginUser");
        user.setUname(user1.getUname());
        List<UserPo> list = this.loginService.queryLogin(user);

        int result=list.size();
        logger.debug("结果result"+result);
        boolean bol = true;
        if(result==0){
            bol=false;
        }
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("valid", bol);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString=mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;


    }

    /** 
	 * 
	 * 更新密码
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
    @RequestMapping("/updatePass")
    @ResponseBody
    public AjaxResultPo updatePass( UserPo user ,HttpServletRequest request ,HttpServletResponse response){

        logger.debug("进入   updatePass()......");
        logger.debug("请求参数: "+ user);
        String md5 = new MD5().getMD5ofString(user.getPassWord());
        user.setPassWord(md5);

        UserPo user1=(UserPo) request.getSession().getAttribute("loginUser");
        user.setUid(user1.getUid());

        try {
            if(this.loginService.updatePass(user)==0){
                logger.debug("更新成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入更新方法,增加失败");
                request.getSession().setAttribute("dmsg", "更新失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "增加异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }




    }

    /** 
	 * 
	 * 拦截不能访问的请求 处理页面
	 * @author  wuhl
	 * @date 创建时间：2016年12月8日 下午16:13:41 
	 * @parameter  
	 * @return  
	 */
    @RequestMapping("/forbidden")
    public String forbidden(UserPo user, HttpServletRequest request,
                            HttpServletResponse response) {
       logger.debug("拦截不能访问权限！");

        return "forbidden";

    }

}
