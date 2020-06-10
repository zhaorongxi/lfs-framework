package com.bc.interfaces.product.service;

import com.bc.interfaces.dto.ResultReturn;
import com.bc.interfaces.model.vo.ChannelInfoVo;
import com.bc.interfaces.model.dto.ChargeDto;
import com.bc.interfaces.model.vo.ProductInfoVo;
import com.bc.interfaces.model.vo.ProductVo;

import java.util.List;
import java.util.Map;

public interface ProductService {

    ResultReturn<ProductVo> verifyOrder(ChargeDto dto);

    ResultReturn<ChannelInfoVo> getChannelInfoById(String channelNo);

    ResultReturn<List<ProductInfoVo>> getProductList(String agtPhone);

    String getproductCode(Map<String, Object> paramMap);

    ResultReturn<ProductVo> sendVerifyOrder(ChargeDto dto);

    List<Map<String, Object>> getAdapter(ChargeDto chargeDto);

    ResultReturn<ProductVo> checkAllowCharge(String agtPhone,Integer count);

    List<Map<String, Object>> getChargeAdapter(ChargeDto chargeDto);


}
