package com.lfs.interfaces.authToken.service.impl;

import com.lfs.interfaces.authToken.service.AppAuthTokenService;
import com.lfs.interfaces.dao.AppAuthTokenDao;
import com.lfs.interfaces.model.AppAuthToken;
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
