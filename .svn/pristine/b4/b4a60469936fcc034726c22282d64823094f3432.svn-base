package com.channelsoft.ems.controller;

import com.alibaba.fastjson.JSONObject;
import com.channelsoft.ems.po.TBuildingPo;
import com.channelsoft.ems.po.TFloorPo;
import com.channelsoft.ems.po.TreeViewPo;
import com.channelsoft.ems.service.TeBuildingService;
import com.channelsoft.ems.service.TeFloorService;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * 房间管理显示的菜单树
 * Created by wangjs on 2016/12/8.
 */
@Controller
@RequestMapping("/tree")
public class TreeViewController {
    private static Logger logger= Logger.getLogger(TreeViewController.class);

    @Autowired
    private TeBuildingService teBuildingService;

    @Autowired
    private TeFloorService teFloorService;

    /**
     * @Method: queryMenuTree
     * @Description: 房间菜单树
     * @Para: []
     * @Retun: List<TreeViewPo>
     * @Author: wangjs
     * @Date: 2016/12/8.
     */
    @RequestMapping(value = "/treeList")
    @ResponseBody
    public List<TreeViewPo> queryMenuTree(HttpServletRequest request, HttpServletResponse response){

        logger.debug("进入获取菜单树的方法:TreeViewController.queryMenuTree()");

        response.setContentType("text/html;charset=UTF-8");
        List<TBuildingPo> buildingTreeList= teBuildingService.queryTreeBuilding();

        List<TFloorPo> floorList= teFloorService.queryTreeFloor();

        List<TreeViewPo> result=new ArrayList<TreeViewPo>();

//        对大厦进行遍历，每一个大厦会和所有楼层匹配传入(List<TFloorPo> list,TBuildingPo po)函数
        if(null!=buildingTreeList&&buildingTreeList.size()!=0){
            for(TBuildingPo po:buildingTreeList){
                if(StringUtils.isNotEmpty(po.getfBuildingName())){
                    result.addAll(createTree(floorList, po));
                }
            }
            System.out.println("ojp========="+JSONObject.toJSON(result));
        }
        return result;

    }

    /**
     * @Method: createTree
     * @Description: 对每一个传过来的大厦和所有楼层进行匹配，楼层的fBuildingID和大厦fid相等，进行组装
     * @Para: [List<TFloorPo> list,TBuildingPo po]
     * @Retun: List<TreeViewPo>
     * @Author: wangjs
     * @Date: 2016/12/8.
     */
    public List<TreeViewPo> createTree(List<TFloorPo> list,TBuildingPo po){

        List<TreeViewPo> result=new ArrayList<TreeViewPo>();

        TreeViewPo tree=new TreeViewPo();
        tree.setfID(po.getfID());
        tree.setText(po.getfBuildingName());

        List<TreeViewPo> treeList=new ArrayList<TreeViewPo>();

        for(TFloorPo p:list){
            if(tree.getfID().equals(p.getfBuildingID())){
                TreeViewPo treeFloor=new TreeViewPo();
                treeFloor.setText(p.getfFLoorName());
                treeFloor.setfID(p.getfID());
                treeList.add(treeFloor);
                tree.setNodes(treeList);
            }
        }

        result.add(tree);

        return result;
    }
}
