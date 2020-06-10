package com.bc.interfaces.authToken.service.impl;

import com.bc.interfaces.authToken.service.AppAuthTokenService;
import com.bc.interfaces.dao.AppAuthTokenDao;
import com.bc.interfaces.model.AppAuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppAuthTokenServiceImpl implements AppAuthTokenService {

    @Autowired
    private AppAuthTokenDao appAuthTokenDao;

    @Override
    public List<AppAuthToken> getAppIdAndToken(String chargeAddr) {
        return appAuthTokenDao.getAppIdAndToken(chargeAddr);
    }
}
