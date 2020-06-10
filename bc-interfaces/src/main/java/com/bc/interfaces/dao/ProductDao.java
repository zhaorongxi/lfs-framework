package com.bc.interfaces.dao;

import com.bc.interfaces.model.ChannelInfo;
import com.bc.interfaces.model.Product;
import com.bc.interfaces.model.dto.ChargeDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProductDao {

    List<Product> getProductRightByAgtNo(Map<String, Object> map);

    List<Product> getProductListByAgtNo(@Param(value = "agtNo") String agtNo);

    List<ChannelInfo> getChannelInfoById(@Param(value = "channelNo") String channelNo);

	String getproductCode(Map<String, Object> paramMap);

	List<Map<String, Object>> getAdapter(ChargeDto chargeDto);

	List<Map<String, Object>> getChargeAdapter(ChargeDto chargeDto);
}
