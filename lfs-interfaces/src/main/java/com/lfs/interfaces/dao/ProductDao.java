package com.lfs.interfaces.dao;

import com.lfs.interfaces.model.ChannelInfo;
import com.lfs.interfaces.model.Product;
import com.lfs.interfaces.model.dto.ChargeDto;
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
