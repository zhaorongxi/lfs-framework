package com.bc.interfaces.dao;

import com.bc.interfaces.model.OrderNotify;
import com.bc.interfaces.model.dto.OrderCharge;
import com.bc.interfaces.model.dto.OrderDto;
import com.bc.interfaces.model.vo.OrderInfoVO;

import java.util.List;
import java.util.Map;

public interface OrderChargeDao {

    /* 订单表 */
    List<OrderCharge> getOrderInfo(OrderCharge order);

    List<OrderCharge> getValidOrderForConfirmByBuscodeAndOrderNo(OrderCharge order);

    List<OrderCharge> getOrderInfoAfterQuery(OrderCharge order);

    Map<String,Object> selectAgtByOrderNo(String OrderNo);

    int updateOrderState(OrderCharge order);

    int updateOrderAfterNotify(OrderCharge order);

    /* 回调表 */

    int updateOrderNotifyState(OrderNotify orderNotify);

    int updateOrderNotifyAfter(OrderNotify orderNotify);

    OrderNotify getOrderNotifyInfo(OrderNotify orderNotify);

    int updateOrderStatus(OrderCharge order);

    int insertOrder(OrderCharge order);

    int updateOrderAfterQuery(OrderCharge updateOrder);

    void updateChannelPrice(OrderDto orderDto);

    void updateChannelStatus(OrderDto orderDto);

    void updateSendStatus(Map<String, Object> map);

    void insertGameInfo(Map<String, Object> map);

    void inserFailOrder(Map<String, Object> map);

    List<Map<String, Object>> listFailOrder();

    void deleteFailOrder(List<Map<String, Object>> failList);

    int insertRechargeOrder(OrderDto orderDto);

    Map<String,String> getOrderInfoByOrderNo(OrderInfoVO orderInfoVO);

}
