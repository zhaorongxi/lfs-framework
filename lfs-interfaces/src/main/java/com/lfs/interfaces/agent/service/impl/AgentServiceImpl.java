package com.lfs.interfaces.agent.service.impl;

import com.lfs.interfaces.agent.service.AgentSerivce;
import com.lfs.interfaces.common.Constants;
import com.lfs.interfaces.dao.AgentDao;
import com.lfs.interfaces.dto.ResultReturn;
import com.lfs.interfaces.model.Agent;
import com.lfs.interfaces.model.AgtAccess;
import com.lfs.interfaces.model.AgtSecurity;
import com.lfs.interfaces.model.vo.AgentVo;
import com.lfs.interfaces.model.vo.AgtAccessVo;
import com.lfs.interfaces.model.vo.AgtSecurityVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class AgentServiceImpl implements AgentSerivce {

    @Resource
    private AgentDao agentDao;

    @Override
    public ResultReturn<AgentVo> getAgentInfoByAgtNo(String agtNo) {
        List<Agent> list = agentDao.getAgentInfoByNo(agtNo);
        AgentVo vo = new AgentVo();
        if (list.size() > 0) {
            Agent agent = list.get(0);
            vo = new AgentVo(agent.getId(), agent.getAgtName(), agent.getAgtPhone(), agent.getParentId(),
                    agent.getAgtNo(), agent.getAgtType(), agent.getState(),agent.getIsUsedCard(),agent.getAgtOfficeAddr());
        }
        return new ResultReturn<AgentVo>().setData(vo);
    }

    @Override
    public ResultReturn<List<AgentVo>> getAgentInfoByPhone(String agtPhone) {
        try {
            List<Agent> list = agentDao.getAgentInfoByPhone(agtPhone);
            List<AgentVo> vos = new ArrayList<>();
            for (Agent agent : list) {
                AgentVo vo = new AgentVo(agent.getId(), agent.getAgtName(), agent.getAgtPhone(), agent.getParentId(),
                        agent.getAgtNo(), agent.getAgtType(), agent.getState(),agent.getIsUsedCard(),agent.getAgtOfficeAddr());
                vos.add(vo);
            }
            return new ResultReturn<List<AgentVo>>().setData(vos);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public ResultReturn<List<AgtSecurityVo>> getAgtSecurityInfo(String agtNo) {
        List<AgtSecurityVo> vos = new ArrayList<>();
        List<AgtSecurity> list = agentDao.getAgtSecurityInfo(agtNo);
        for (AgtSecurity agtSecurity : list) {
            AgtSecurityVo vo = new AgtSecurityVo(agtNo, agtSecurity.getLoginPwd(), agtSecurity.getTradePwd(),
                    agtSecurity.getChargeMsgState(), agtSecurity.getCustMsgState());
            vos.add(vo);
        }
        return new ResultReturn<List<AgtSecurityVo>>().setData(vos);
    }


    @Override
    public ResultReturn<AgtAccessVo> getAgtAccessByAgtPhone(String agtPhone) {
        try {
            List<AgtAccess> accesses = agentDao.getAgtAccessByAgtPhone(agtPhone);
            if (accesses.size() > 0) {
                AgtAccessVo vo = new AgtAccessVo();
                vo.setAgtNo(accesses.get(0).getAgtNo());
                vo.setAppId(accesses.get(0).getAppId());
                vo.setAppKey(accesses.get(0).getAppKey());
                vo.setId(accesses.get(0).getId());
                return new ResultReturn<AgtAccessVo>().setStatus(Constants.SUCCESS).setData(vo);
            } else {
                return new ResultReturn<AgtAccessVo>().setStatus(Constants.FAILED).setData(null);
            }
        } catch (Exception e) {
            return new ResultReturn<AgtAccessVo>().setStatus(Constants.EXCEPTION).setData(null);
        }
    }

    @Override
    public Map<String,String> getDbAgentInfoByPhone(String agtpnone) {
        return agentDao.getDbAgentInfoByPhone(agtpnone);
    }

    public List<AgtSecurityVo> verifyOrder(String agtPhone) {
        return agentDao.verifyOrder(agtPhone);
    }

    @Override
    public int checkAllowCharge(String mobile) {
        return agentDao.checkAllowCharge(mobile);
    }

    @Override
    public Agent getAgentBankInfo(String agtNo) {
        return agentDao.getAgentBankInfo(agtNo);
    }
}
