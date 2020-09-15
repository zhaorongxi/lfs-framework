package com.lfs.interfaces.dao;

import com.lfs.interfaces.model.BankInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BankDao {

    List<BankInfo> getAgentBankList(@Param(value="agtPhone") String agtPhone);
}
