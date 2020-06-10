package com.bc.interfaces.wallet.service.impl;

import com.bc.interfaces.dao.AgentWalletDao;
import com.bc.interfaces.model.AgtWallet;
import com.bc.interfaces.wallet.service.AgentWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentWalletServiceImpl implements AgentWalletService {

    @Autowired
    private AgentWalletDao agentWalletDao;

    @Override
    public int addAgentWallet(AgtWallet agtWallet) {
        return agentWalletDao.addAgentWallet(agtWallet);
    }
}
