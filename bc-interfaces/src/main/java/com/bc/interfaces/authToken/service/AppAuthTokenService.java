package com.bc.interfaces.authToken.service;

import com.bc.interfaces.model.AppAuthToken;

import java.util.List;

public interface AppAuthTokenService {

    List<AppAuthToken> getAppIdAndToken(String chargeAddr);
}
