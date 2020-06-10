package com.bc.interfaces.bank.service;

import com.bc.interfaces.model.BankInfo;

import java.util.List;

public interface BankService {

    List<BankInfo> getAgentBankList(String agtNo);
}
