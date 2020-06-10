package com.bc.interfaces.order.service;

import com.bc.interfaces.dto.ResultReturn;
import com.bc.interfaces.model.dto.OrderCharge;
import com.bc.interfaces.model.dto.OrderDto;
import com.bc.interfaces.model.dto.OrderNotifyDto;
import com.bc.interfaces.model.vo.OrderInfoVO;

import java.util.List;
import java.util.Map;

public interface OrderBaseService {

    ResultReturn<Integer> updateOrderStatus(OrderDto dto);

    ResultReturn<Long> createOrder(OrderDto dto);

    ResultReturn<Integer> updateOrderAfterCharge(OrderDto dto);

    ResultReturn<Integer> updateOrderAfterQuery(OrderDto dto);

    ResultReturn<Integer> updateOrderAfterNotity(OrderDto dto);

    void sendNotify(OrderNotifyDto dto);

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

}
