/**
 * 
 */
package com.channelsoft.ems.controller;

import com.channelsoft.ems.common.MD5;
import com.channelsoft.ems.po.AjaxResultPo;
import com.channelsoft.ems.po.UserPo;
import com.channelsoft.ems.service.HomeServiceItemService;
import com.channelsoft.ems.service.MobileService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kangqz
 * @Description:
 * @Date: 2017年2月21日
 * @Modified By:
 */
@Controller
@RequestMapping("/mobile")
public class MobileController {
	private static Logger logger = Logger.getLogger(MobileController.class);


	@Autowired
	private MobileService mobileService;
	/*@RequestMapping("/login")
	public String mindex(){
		
		return "mobile/mlogin";
	}*/

	@RequestMapping("/index")
	public String Login(UserPo user, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("进入 Login 方法");
		logger.debug("请求参数：" + user.toString());

		try {
//			UserPo user1 = (UserPo) request.getSession().getAttribute("mobileUser");
//
//
			if(user.getPassWord()==null){
				return "mobile/mlogin";
			}else{
				String md5 = new MD5().getMD5ofString(user.getPassWord());
				user.setPassWord(md5);
//			}


				List<UserPo> list = this.mobileService.queryMobile(user);
				if (list.size() != 0) {
					if (user.getRoleName().equals("护理")) {
						request.getSession().setAttribute("msg", "");
						request.getSession().setAttribute("mobileUser", list.get(0));

						return "mobile/mobileStaff/staffMessage";
					}
					if (user.getRoleName().equals("院长")) {
						request.getSession().setAttribute("msg", "");
						request.getSession().setAttribute("mobileUser", list.get(0));
						return "mobile/mobilePresident/allHomeView";
					}
					return null;
				} else {
					request.getSession().setAttribute("msg", "用户名或密码错误！");
					return "mobile/mlogin";
				}
			}
//			if (user1 != null) {
//				user.setPassWord(user1.getPassWord());
//				user.setUname(user1.getUname());
//				user.setRoleName(user1.getRoleName());
//			} else {


		} catch (Exception e) {
			request.setAttribute("loginError", e.getMessage());
			return "mobile/mlogin";
		 }

	}

    @RequestMapping("/quit")
    public String quit(HttpServletRequest request){
        request.getSession().removeAttribute("mobileUser");
        request.getSession().setAttribute("msg", "成功退出");
        return "mobile/mlogin";
    }

	@RequestMapping("/CheckPass")
	public String CheckPass( String oldPassword, UserPo user,HttpServletRequest request ,HttpServletResponse response) throws IOException {
		logger.debug("传进来的参数为"+user);
		String md5 = new MD5().getMD5ofString(oldPassword);//旧密码
		UserPo user1=(UserPo) request.getSession().getAttribute("mobileUser");
		if(md5.equals(user1.getPassWord())){
			user.setUid(user1.getUid());
             user.setPassWord(new MD5().getMD5ofString(user.getPassWord()));
			try {
				if(this.mobileService.updatePass(user)==0){
					request.getSession().setAttribute("dmsg","更新成功");
					logger.debug("更新成功");
					return "mobilePresident/changePassword";
				}else{
					logger.debug("进入更新方法,增加失败");
					request.getSession().setAttribute("dmsg", "更新失败");
					return "mobilePresident/changePassword";
				}
			} catch (Exception e) {
				// TODO: handle exception
				request.getSession().setAttribute("dmsg", "更新异常");
				logger.debug("异常:"+e.getMessage());
				e.printStackTrace();
				return "mobilePresident/changePassword";
			}
		}else{
			 request.getSession().setAttribute("dmsg","旧密码错误");
             return "mobilePresident/changePassword";
		}
	}
}
