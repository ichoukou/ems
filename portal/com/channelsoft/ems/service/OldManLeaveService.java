package com.channelsoft.ems.service;

import com.channelsoft.ems.controller.OldManLeaveController;
import com.channelsoft.ems.po.OldManLeavePo;

import java.util.List;

/**
 * Created by wangjs on 2016/12/26.
 */
public interface OldManLeaveService {

    public int queryCount(OldManLeavePo po);

    public List<OldManLeavePo> queryListByPage(OldManLeavePo po,int page,int pageSize);

    public void addOldManLeave(OldManLeavePo po);

    public void updOldManLeave(OldManLeavePo po);

    public void delOldManLeave(OldManLeavePo po);
}
