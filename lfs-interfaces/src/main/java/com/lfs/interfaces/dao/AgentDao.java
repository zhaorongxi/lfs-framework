package com.lfs.interfaces.dao;

import com.lfs.interfaces.model.Agent;
import com.lfs.interfaces.model.AgtAccess;
import com.lfs.interfaces.model.AgtSecurity;
import com.lfs.interfaces.model.vo.AgtSecurityVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AgentDao {

    List<Agent> getAgentInfoByNo(@Param(value = "agtNo") String agtNo);
    
    List<Agent> getAgentInfoByPhone(@Param(value = "agtPhone") String agtPhone);

	Map<String,String> getDbAgentInfoByPhone(String agtpnone);

	int checkAllowCharge(String mobile);

    List<AgtSecurity> getAgtSecurityInfo(@Param(value = "agtNo") String agtNo);

    List<AgtAccess> getAgtAccessByAgtPhone(@Param(value = "agtPhone") String agtPhone);

    List<AgtSecurityVo> verifyOrder(String agtPhone);

    Agent getAgentBankInfo(@Param( value= "agtNo") String agtNo);

}
