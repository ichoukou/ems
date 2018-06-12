package com.channelsoft.ems.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.channelsoft.ems.po.FundAccountPo;
import com.channelsoft.ems.po.RolePo;
import com.channelsoft.ems.service.RoleManageService;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.channelsoft.ems.po.AjaxResultPo;

/**
 * 张鑫
 */
@Controller
@RequestMapping("/role")
public class RoleManageController {

    private static Logger logger = Logger.getLogger(RoleManageController.class);

    @Autowired
    private RoleManageService roleManagerService;

    @RequestMapping("/roleList")
    public String gotodataDictionary(HttpServletRequest request ,HttpServletResponse response){

        logger.debug("已经跳转");
        return "roleManage/roleManageList";
    }

    /**
    *@Description:查询，显示用
    *@Param:page,pageSize
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */
    @ResponseBody
    @RequestMapping("/query")
    public AjaxResultPo gotoList(int page, int pageSize, HttpServletRequest request , HttpServletResponse response){
       logger.debug("请求参数: page "+ page + " pageSize " + pageSize);
        List<RolePo> roleList = roleManagerService.getFenRoleList(page,pageSize);
        logger.debug("进入queryCount()方法");
        int roleCount = roleManagerService.getRolecount();
        return new AjaxResultPo(true, "success", roleCount, roleList);
    }

    /**
     * 校验账户信息是否存在   账户名和账户号都不能重复 这里使用的是bootstrap自带的校验
     * bootstrap远程检验的时候需要的返回值形式为 result:{"valid",true or false}
     * @return
     * @throws IOException
     */
    @RequestMapping("/check")
    @ResponseBody
    public String checkRoleName(RolePo rolePo, HttpServletRequest request, HttpServletResponse response) throws IOException{
        logger.debug("传进来的参数为"+rolePo.toString());
        int result=roleManagerService.check(rolePo);
        logger.debug("结果result"+result);
        boolean bol = true;
        if(result!=0){
            bol=false;
        }
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("valid", bol);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
     *@Description:更新查重
     *@Param:rolePo
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @RequestMapping("/updateCheck")
    @ResponseBody
    public String updateCheck(RolePo rolePo, HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.debug("传进来的参数为"+rolePo);
        int result=this.roleManagerService.updateCheck(rolePo);
        logger.debug("结果result"+result);
        boolean bol = true;
        if(result!=0){
            bol=false;
        }
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        map.put("valid", bol);
        ObjectMapper mapper = new ObjectMapper();
        String resultString = "";
        try {
            resultString = mapper.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return resultString;
    }

    /**
    *@Description:新增
    *@Param:rolePo
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/addRole")
    public AjaxResultPo addRoleManageData(RolePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   addRank()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("穿过来的对象"+po);
        try {
            if(this.roleManagerService.addRoleList(po)==0){
                logger.debug("增加成功");
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入增加方法,增加失败");
                request.getSession().setAttribute("dmsg", "增加失败");
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
    *@Description:更新信息
    *@Param:RolePo
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    @ResponseBody
    @RequestMapping("/updateRole")
    public AjaxResultPo updateRoleList(RolePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   updateRoleList()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("进入   update()......");
        logger.debug("请求参数: "+ po.toString());
        logger.debug("需要更新字段"+po);
        try {
            if(this.roleManagerService.updateRoleList(po)==0){
                logger.debug("更新成功");
                //List<RolePo> list= this.roleManagerService.getRoleList();
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入更新方法,更新失败");
                request.getSession().setAttribute("dmsg", "更新失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "更新异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    /**
     *@Description:根据id改变角色状态 0.禁用 1.启用
     *@Param:RolePo
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */
    @ResponseBody
    @RequestMapping("/deleteRole")
    public AjaxResultPo deleteRoleManage(String id, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   delete......");
        roleManagerService.updateState(id);
        return new AjaxResultPo(true, "success");
    }

    @ResponseBody
    @RequestMapping("/startRole")
    public AjaxResultPo startRole(RolePo po, HttpServletRequest request ,HttpServletResponse response){
        logger.debug("进入   startRole()......");
        logger.debug("请求参数: "+ po.toString());
        try {
            if(this.roleManagerService.startState(po)==0){
                logger.debug("成功启用"+po.getId());
                return new AjaxResultPo(true, "success");
            }else{
                logger.debug("进入启用方法,启用失败");
                request.getSession().setAttribute("dmsg", "启用失败");
                return null;
            }
        } catch (Exception e) {
            // TODO: handle exception
            request.getSession().setAttribute("dmsg", "启用异常");
            logger.debug("异常:"+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}
