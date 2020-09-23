package com.lfs.interfaces.bank.service;

import com.lfs.interfaces.model.BankInfo;

import java.util.List;

public interface BankService {

    List<BankInfo> getAgentBankList(String agtNo);
}
