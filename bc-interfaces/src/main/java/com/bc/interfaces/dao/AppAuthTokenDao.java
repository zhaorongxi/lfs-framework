package com.bc.interfaces.dao;

import com.bc.interfaces.model.AppAuthToken;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppAuthTokenDao {

    List<AppAuthToken> getAppIdAndToken(@Param("chargeAddr") String chargeAddr);
}
