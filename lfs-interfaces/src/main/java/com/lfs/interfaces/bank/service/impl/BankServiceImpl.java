package com.lfs.interfaces.bank.service.impl;

import com.lfs.interfaces.bank.service.BankService;
import com.lfs.interfaces.dao.BankDao;
import com.lfs.interfaces.model.BankInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankDao bankDao;

    @Override
    public List<BankInfo> getAgentBankList(String agtPhone) {
        return bankDao.getAgentBankList(agtPhone);
    }
}
