package com.lfs.interfaces.authToken.service;

import com.lfs.interfaces.model.AppAuthToken;

import java.util.List;

public interface AppAuthTokenService {

    List<AppAuthToken> getAppIdAndToken(String chargeAddr);
}
