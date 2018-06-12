package com.channelsoft.ems.mapper;

import com.channelsoft.ems.po.OldManPaymentEntryPo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * Created by wangjs on 2016/12/28.
 */
public interface OldManPaymentEntryMapper {

    @Insert("insert into t_fygl_rpaymententry (FParentid,FCostItem,FitemID,FArPaymentAmount) " +
            "values (#{fParentid},#{fCostItem},#{fitemID},#{fArPaymentAmount})")
    public int addPaymentEntry(@Param("fParentid")String fParentid,
               @Param("fCostItem")String fCostItem,@Param("fitemID")String fitemID,
               @Param("fArPaymentAmount")String fArPaymentAmount);

    @Insert("insert into t_fygl_rpaymententry (FParentid,FitemID,FArPaymentAmount,Fsourcebillid) " +
            "values (#{fParentid},#{fitemID},#{fArPaymentAmount},#{fsourcebillid})")
    public void addPaymentEntryOne(OldManPaymentEntryPo po);

    @Update("update t_fygl_rpaymententry set FCostItem=#{fCostItem},FArPaymentAmount=#{fArPaymentAmount} " +
            "where FParentid=#{fParentid}")
    public void updPaymentEntryOne(OldManPaymentEntryPo po);

    @Delete("delete from t_fygl_rpaymententry where FParentid=#{fParentid}")
    public void delPaymentEntryOne(OldManPaymentEntryPo po);

}
