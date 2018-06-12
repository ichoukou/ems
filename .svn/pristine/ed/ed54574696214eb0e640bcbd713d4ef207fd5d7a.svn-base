package com.channelsoft.ems.expenses.mouthblance.mapper;

import java.math.BigDecimal;
import java.util.List;

import com.channelsoft.ems.expenses.rpayment.po.Oldmanblance;
import com.channelsoft.ems.nursing.nursingPlan.po.OldManPo;
import com.channelsoft.ems.po.OldManChargePo;

/** 
 * 
 * 月结账mapper
 * @author  lwj
 * @date 创建时间：2017年3月6日21:19:05
 * @parameter  
 * @return  
 */
public interface OldmanblanceMapper {
    int deleteByPrimaryKey(String fid);

    int insert(Oldmanblance record);

    int insertSelective(Oldmanblance record);

    Oldmanblance selectByPrimaryKey(String fid);

    int updateByPrimaryKeySelective(Oldmanblance record);

    int updateByPrimaryKey(Oldmanblance record);

	Oldmanblance getOldManBlance();

	List<OldManPo> getAllOldManOfwhole();

	Oldmanblance getOldManBlanceByOldman(String foldmanid);

	BigDecimal getFaramountTotal(Oldmanblance omb);

	BigDecimal getFapamountTotal(Oldmanblance omb);

	List<OldManChargePo> getOldManChargeNeed(String foldmanid);

	void deleteOldmanblanceByyearmouth(Oldmanblance oldmanblance);

	BigDecimal getFaramountTotalBlance(Oldmanblance omb);

	BigDecimal getFapamountTotalBlance(Oldmanblance omb);

	List<Oldmanblance> QueryList(Oldmanblance po);

	int getTotalSize(Oldmanblance po);
}