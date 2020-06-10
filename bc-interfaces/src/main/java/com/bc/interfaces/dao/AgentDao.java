package com.bc.interfaces.dao;

import com.bc.interfaces.model.Agent;
import com.bc.interfaces.model.AgtAccess;
import com.bc.interfaces.model.AgtSecurity;
import com.bc.interfaces.model.vo.AgtSecurityVo;
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
