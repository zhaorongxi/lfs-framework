package com.lfs.interfaces.agent.service;

import com.lfs.interfaces.dto.ResultReturn;
import com.lfs.interfaces.model.Agent;
import com.lfs.interfaces.model.vo.AgentVo;
import com.lfs.interfaces.model.vo.AgtAccessVo;
import com.lfs.interfaces.model.vo.AgtSecurityVo;

import java.util.List;
import java.util.Map;

public interface AgentSerivce {

    ResultReturn<List<AgentVo>> getAgentInfoByPhone(String agtPhone);

    ResultReturn<List<AgtSecurityVo>> getAgtSecurityInfo(String agtNo);

    ResultReturn<AgentVo> getAgentInfoByAgtNo(String agtNo);

    ResultReturn<AgtAccessVo> getAgtAccessByAgtPhone(String agtPhone);

    Map<String,String> getDbAgentInfoByPhone(String agtpnone);

    List<AgtSecurityVo> verifyOrder(String agtPhone);

    int checkAllowCharge(String mobile);

    Agent getAgentBankInfo(String agtNo);
}
