package com.channelsoft.ems.service;

import com.channelsoft.ems.po.PerfMaintainPo;

import java.util.List;
import java.util.Map;

/**
 * Created by 张鑫 on 2016/12/19.
 */
public interface PerfMaintainService {
    /**
     *@Description:得到数据字典中的信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public List<Map<String,String>> getDCname();
    /**
     *@Description:根据Sum得到结果
     *@Param:request
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public List<Map<String,String>> getResult(String sum);
    /**
     *@Description:插入主表信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public int addParentTable(PerfMaintainPo maintainPo);
    public String queryFID();
    /**
     *@Description:插入子表信息
     *@Param:po
     *@return:AjaxResultPo
     *@author:zhangxin
     *@Date:2017/3/13
     */

    public int insertID(String[]nowFproject,String nowScore[],PerfMaintainPo po,String fId);
    /**
    *@Description:查询分页用
    *@Param:po
    *@return:AjaxResultPo
    *@author:zhangxin
    *@Date:2017/3/13
    */

    public int queryCount(PerfMaintainPo po);
    public List<PerfMaintainPo> queryList(PerfMaintainPo po, int page, int pageSize);
    //根据FNumber得到子表分数，FID
    public  List<Map<String,String>> queryScore(String fNumber);
    //更新主表
    public int updateMainMaintain(PerfMaintainPo po);
    //更新子表
    public int updateMaintainList(String[] fId ,String nowScore[],PerfMaintainPo po,String[] nowIdFproject);

    public int deleteMaintain(PerfMaintainPo po);
}
