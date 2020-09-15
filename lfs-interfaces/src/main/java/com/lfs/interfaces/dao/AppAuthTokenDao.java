package com.lfs.interfaces.dao;

import com.lfs.interfaces.model.AppAuthToken;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AppAuthTokenDao {

    List<AppAuthToken> getAppIdAndToken(@Param("chargeAddr") String chargeAddr);
}
