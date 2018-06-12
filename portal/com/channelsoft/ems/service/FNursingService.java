package com.channelsoft.ems.service;

import com.channelsoft.ems.po.ArrgngHomePo;
import com.channelsoft.ems.po.FNursingPo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 
 * 员工排房  
 * @author  wuhl
 * @date 创建时间：2016年12月9日 下午16:13:41 
 * @parameter  
 * @return  
 */
public interface FNursingService {


    //查询启用的养老院i
    public List<FNursingPo> queryStartFNursing( );

    //查询所有养老院
    public List<FNursingPo> queryAllFNursing( );

    //根据ID查询养老院
    public List<FNursingPo> getNusingHomeById(FNursingPo po);


    //查询养老院数量
    public int queryFNursingCount( FNursingPo param);

   //查询养老院总数
    public List<FNursingPo> queryFNursing( FNursingPo param, int page, int pageSize);

    //禁用
    public int delete(FNursingPo param);

    //启用
    public int start(FNursingPo param);

    //新增养老院
    public int addFBursing(FNursingPo param);

    //更新养老院
    public int updateFBursing(FNursingPo po);


 //养老院收费标准
    public List<Map<String,String>> showFursing();

    //养老院名字不能重复
    public int check(FNursingPo po);

    //更新不能重复
    public int updateCheck(FNursingPo po);


}
