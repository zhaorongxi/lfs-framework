package com.lfs.interfaces.order.service;

import com.lfs.interfaces.dto.ResultReturn;
import com.lfs.interfaces.model.dto.OrderCharge;
import com.lfs.interfaces.model.dto.OrderDto;
import com.lfs.interfaces.model.dto.OrderNotifyDto;
import com.lfs.interfaces.model.vo.OrderInfoVO;

import java.util.List;
import java.util.Map;

public interface OrderBaseService {

    ResultReturn<Integer> updateOrderStatus(OrderDto dto);

    ResultReturn<Long> createOrder(OrderDto dto);

    ResultReturn<Integer> updateOrderAfterCharge(OrderDto dto);

    ResultReturn<Integer> updateOrderAfterQuery(OrderDto dto);

    ResultReturn<Integer> updateOrderAfterNotity(OrderDto dto);

    String sendNotify(OrderNotifyDto dto);

    void updateChannelPrice(OrderDto orderDto);

    void updateChannelStatus(OrderDto orderDto);

    Map<String,Object> selectAgtByOrderNo(String orderNo);

    void updateSendStatus(Map<String, Object> map);

    void inserFailOrder(Map<String, Object> map);

    List<Map<String, Object>> listFailOrder();

    void deleteFailOrder(List<Map<String, Object>> failList);

    List<OrderCharge> getValidOrderForConfirmByBuscodeAndOrderNo(OrderCharge order);

    int insertRechargeOrder(OrderDto orderDto);

    List<OrderCharge> getGameOrderInfoByOrderNo(OrderCharge order);

    String getAgtnoByAgtPhone(String agtPhone);

    OrderDto getOrderInfo(String orderNo);

    Map<String,String> getOrderInfoByOrderNo(OrderInfoVO orderInfoVO);

    int updateOrderInfo(OrderInfoVO orderInfoVO);

}
