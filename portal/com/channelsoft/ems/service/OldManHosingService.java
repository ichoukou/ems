package com.channelsoft.ems.service;

import com.channelsoft.ems.po.OldManMainPo;

import java.util.List;

/**
 * Created by wangjs on 2016/12/15.
 */
public interface OldManHosingService {

    public int queryCount(OldManMainPo po,String startTime,String stopTime);

    public int queryCountByState(OldManMainPo po);

    public List<OldManMainPo> queryList(OldManMainPo po,int page,int pageSize,String startTime,String stopTime);

    public List<OldManMainPo> queryOldManMainByState(OldManMainPo po,int page,int pageSize,String startTime,String stopTime);

    public List<OldManMainPo> getOldManRoom(OldManMainPo po);

    public List<OldManMainPo> getomList(OldManMainPo po);

    public List<OldManMainPo> queryLast();

    public OldManMainPo getOldManById(String Id);

    public List<OldManMainPo> addBase(OldManMainPo po)throws Exception;

    public void updBase(OldManMainPo po);

    public void updOldManState(OldManMainPo po);
}
