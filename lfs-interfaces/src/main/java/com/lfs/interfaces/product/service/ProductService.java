package com.lfs.interfaces.product.service;

import com.lfs.interfaces.dto.ResultReturn;
import com.lfs.interfaces.model.vo.ChannelInfoVo;
import com.lfs.interfaces.model.dto.ChargeDto;
import com.lfs.interfaces.model.vo.ProductVo;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ResultReturn<ProductVo> verifyOrder(ChargeDto dto);

    ResultReturn<ChannelInfoVo> getChannelInfoById(String channelNo);

    ResultReturn<List<ProductVo>> getProductList(String agtPhone);

    String getproductCode(Map<String, Object> paramMap);

    ResultReturn<ProductVo> sendVerifyOrder(ChargeDto dto);

    List<Map<String, Object>> getAdapter(ChargeDto chargeDto);

    ResultReturn<ProductVo> checkAllowCharge(String agtPhone,Integer count);

    List<Map<String, Object>> getChargeAdapter(ChargeDto chargeDto);


}
