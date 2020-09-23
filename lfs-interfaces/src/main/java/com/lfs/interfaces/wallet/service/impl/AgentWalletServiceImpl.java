package com.lfs.interfaces.wallet.service.impl;

import com.lfs.interfaces.dao.AgentWalletDao;
import com.lfs.interfaces.wallet.service.AgentWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AgentWalletServiceImpl implements AgentWalletService {

    @Autowired
    private AgentWalletDao agentWalletDao;

    @Override
    public Map<String,Object> addAgentWallet(Map<String,Object> map) {
        return agentWalletDao.addAgentWallet(map);
    }
}
