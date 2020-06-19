package com.bc.interfaces.order.service.impl;

import com.bc.base.exception.ServiceException;
import com.bc.base.util.HttpClientUtil;
import com.bc.base.util.MD5Utils;
import com.bc.base.util.StringUtils;
import com.bc.interfaces.agent.service.AgentSerivce;
import com.bc.interfaces.common.CommonConstants;
import com.bc.interfaces.common.Constants;
import com.bc.interfaces.dao.AgentDao;
import com.bc.interfaces.dao.BaseChargeDao;
import com.bc.interfaces.dao.OrderChargeDao;
import com.bc.interfaces.dto.ResultReturn;
import com.bc.interfaces.feign.NotifyFeignService;
import com.bc.interfaces.model.Agent;
import com.bc.interfaces.model.AgtWallet;
import com.bc.interfaces.model.OrderNotify;
import com.bc.interfaces.model.dto.OrderCharge;
import com.bc.interfaces.model.dto.OrderDto;
import com.bc.interfaces.model.dto.OrderNotifyDto;
import com.bc.interfaces.model.vo.AgtAccessVo;
import com.bc.interfaces.model.vo.OrderInfoVO;
import com.bc.interfaces.order.service.OrderBaseService;
import com.bc.interfaces.wallet.service.AgentWalletService;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderBaseServiceImpl implements OrderBaseService {

    private Logger log = LoggerFactory.getLogger(OrderBaseServiceImpl.class);

    @Autowired
    private BaseChargeDao baseChargeDao;

    @Autowired
    private OrderChargeDao orderChargeDao;

    @Autowired
    private AgentDao agentDao;

    @Autowired
    private AgentSerivce agentSerivce;

    @Autowired
    private AgentWalletService agentWalletService;

    @Autowired
    private NotifyFeignService notifyFeignService;

    /**
     * 回写订单状态RT0002
     */
    @Override
    public ResultReturn<Integer> updateOrderStatus(OrderDto dto) {
        int update = 0;
        try {
            OrderCharge updateOrder = new OrderCharge();
            updateOrder.setId(dto.getId());
            updateOrder.setErrorCode(dto.getErrorCode());
            updateOrder.setRemark(dto.getRemark());
            updateOrder.setState(dto.getState());
            updateOrder.setAccountBalance(dto.getAccountBalance());
            updateOrder.setUpOrderNo(dto.getUpOrderNo());
            updateOrder.setCheckState(dto.getCheckState());
            if (orderChargeDao.updateOrderStatus(updateOrder) > 0) {
                update = 1;
            } else {
                update = 0;
            }
        } catch (Exception e) {
            update = 0;
        }
        return new ResultReturn<Integer>().setData(update);
    }

    /**
     * 插入订单，扣款，插入资金变动RT0003
     */
    @Override
    public ResultReturn<Long> createOrder(OrderDto dto) {
        Long result = -3L;
        try {
            // 验证通过,插入订单，扣款
            List<Agent> agents = agentDao.getAgentInfoByPhone(dto.getAgtPhone());
            Agent agent = agents.get(0);
            OrderCharge order = new OrderCharge();
            order.setBusinessCode(dto.getBusinessCode());
            order.setProductCode(dto.getProductCode());
            order.setArriveType(dto.getArriveType());
            order.setStockState(dto.getStockState());
            order.setDownOrderNo(dto.getDownOrderNo());
            order.setOrderNo(dto.getOrderNo());
            order.setAgtPhone(dto.getAgtPhone());
            order.setAgtNo(agent.getAgtNo());
            order.setChargeAddr(dto.getChargeAddr());
            order.setChargeMoney(dto.getChargeMoney());// 单位:元
            order.setState(dto.getState());
            order.setExp2(dto.getExp2());

            BigDecimal profit = dto.getProfit();
            order.setProfit(profit);
            order.setPrice(dto.getPrice());
            order.setAmount(dto.getAmount());
            BigDecimal outMoney = dto.getOutMoney();
            order.setOutMoney(outMoney); // 扣款金额
            order.setRemark("提交成功");
            order.setChargeType(dto.getChargeType());
            // 插入订单
            int insert = orderChargeDao.insertOrder(order);
            ;
            if (insert <= 0) {
                // 订单插入失败
                result = -2L;
            }
            result = order.getId();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result = -3L;
        }
        return new ResultReturn<Long>().setData(result);
    }

    /**
     * 充值后回写订单RT0004
     */
    @Override
    public ResultReturn<Integer> updateOrderAfterCharge(final OrderDto dto) {
        Integer result = -3;
        try {
            OrderCharge updateOrder = new OrderCharge();
            updateOrder.setId(dto.getId());
            updateOrder.setErrorCode(dto.getErrorCode());
            updateOrder.setRemark(dto.getRemark());
            updateOrder.setState(dto.getState());
            updateOrder.setAccountBalance(dto.getAccountBalance());
            updateOrder.setUpOrderNo(dto.getUpOrderNo());
            updateOrder.setCheckState(dto.getCheckState());
            updateOrder.setChargeType(dto.getRechargeType());
            updateOrder.setChargeAddr(dto.getChargeAddr());
            result = orderChargeDao.updateOrderStatus(updateOrder);
            long orderId = dto.getId();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result = -3;
        }
        return new ResultReturn<Integer>().setData(result);
    }

    /**
     * 查询后回写订单RT0005
     */
    @Override
    public ResultReturn<Integer> updateOrderAfterQuery(OrderDto dto) {
        Integer result = -3;
        try {
            // 回写订单状态和备注
            OrderCharge updateOrder = new OrderCharge();
            updateOrder.setOrderNo(dto.getOrderNo());
            int state = dto.getState();
            updateOrder.setState(state);
            updateOrder.setCheckState(dto.getCheckState());
            updateOrder.setRemark(dto.getRemark());
            result = orderChargeDao.updateOrderAfterQuery(updateOrder);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result = -3;
        }
        return new ResultReturn<Integer>().setData(result);
    }

    /**
     * 回调后回写订单RT0006
     */
    @Override
    public ResultReturn<Integer> updateOrderAfterNotity(OrderDto dto) {
        Integer result = -3;
        try {
            OrderCharge order = new OrderCharge();
            long orderId = dto.getId();
            order.setOrderNo(dto.getOrderNo());
            order.setState(dto.getState());
            order.setRemark(dto.getRemark());
            order.setUpOrderNo(dto.getUpOrderNo());
            order.setChargeAddr(dto.getChargeAddr());
            order.setExp2(dto.getExp2());
            Integer state = dto.getState();
            result = orderChargeDao.updateOrderAfterNotify(order);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            result = -3;
        }
        return new ResultReturn<Integer>().setData(result);
    }

    /**
     * 发送回调
     */
    @Override
    public String sendNotify(OrderNotifyDto dto) {
        String notifyResult = "fail";
        try {
            // 1、回写回调表订单状态
            OrderNotify notify = new OrderNotify();
            AgtWallet agtWallet = new AgtWallet();
            notify.setAgtPhone(dto.getAgtPhone());
            notify.setReqStreamId(dto.getReqStreamId());
            notify.setState(dto.getState());
            log.info("回调准备发送:" + dto.getAgtPhone() + "|" + dto.getReqStreamId() + "|" + dto.getState());
            // 2、发送一次回调
            OrderNotify orderNotifyInfo = orderChargeDao.getOrderNotifyInfo(notify);
            if (null != orderNotifyInfo) {
                if (orderNotifyInfo.getCount() >= 5) {
                    notify.setFlag(4);
                    log.info("当前订单号={},已经重发回调5次,不再发送回调!", dto.getReqStreamId());
                    // 3、回写回调表发送状态
                    orderChargeDao.updateOrderNotifyAfter(notify);
                    return notifyResult;
                }
            } else {
                log.error("未找到订单号={},回调订单记录", dto.getReqStreamId());
                return notifyResult;
            }
            notify.setCount(1);
            ResultReturn<AgtAccessVo> accessReturn = agentSerivce.getAgtAccessByAgtPhone(notify.getAgtPhone());
            if (accessReturn.getStatus().equals(Constants.SUCCESS)) {
                if (StringUtils.isNotBlank(orderNotifyInfo.getNotifyUrl())) {
                    AgtAccessVo vo = accessReturn.getData();
                    // 其他统一回调
                    orderNotifyInfo.setState(dto.getState());
                    if (dto.getChargeType().equals(CommonConstants.BANK_CARD_TYPE)) {
                        orderNotifyInfo.setPrice(orderNotifyInfo.getPrice());
                    } else {
                        orderNotifyInfo.setPrice(dto.getPrice());
                    }
                    notifyResult = sendNotifyRuitone(orderNotifyInfo, vo.getAppKey());

                    log.info("回调发送完成商户订单号={},回调商户订单状态={},回调结果={}:",dto.getReqStreamId(),dto.getState(),notifyResult);
                    if (StringUtils.isBlank(notifyResult)) {
                        log.info("订单号:{}回调发送成功,下游返回接收结果为空", dto.getOrderNo());
                        notify.setFlag(CommonConstants.NOTIFY_NO_RESPONSE);
                        notifyResult = "fail";
                    } else if (notifyResult.equals(CommonConstants.NOTIFY_DOWN_SUCCESS)) {
                        // 客户方返回接收成功
                        notify.setFlag(CommonConstants.NOTIFY_SUCCESS);
                    } else {
                        notify.setFlag(CommonConstants.NOTIFY_FAIL);
                        log.info("订单号:{}回调发送成功,下游返回接收失败", dto.getOrderNo());
                    }
                    // 3、回写回调表发送状态
                    orderChargeDao.updateOrderNotifyAfter(notify);
                }
            }
            // }
        } catch (Exception e) {
            log.error(dto.getReqStreamId() + " 回调下游异常:" + e.getMessage(), e);
        }
        return notifyResult;
    }


    @Override
    public void updateChannelPrice(OrderDto orderDto) {
        orderChargeDao.updateChannelPrice(orderDto);
    }

    @Override
    public void updateChannelStatus(OrderDto orderDto) {
        orderChargeDao.updateChannelStatus(orderDto);
    }

    @Override
    public List<OrderCharge> getValidOrderForConfirmByBuscodeAndOrderNo(OrderCharge order) {
        return orderChargeDao.getValidOrderForConfirmByBuscodeAndOrderNo(order);
    }

    @Override
    public List<OrderCharge> getGameOrderInfoByOrderNo(OrderCharge order) {
        return baseChargeDao.selectList("OrderChargeMapper.getGameOrderInfoByOrderNo", order);
    }

    @Override
    public String getAgtnoByAgtPhone(String agtPhone) {
        return baseChargeDao.selectOne("OrderChargeMapper.getAgtnoByAgtPhone", agtPhone);
    }

    @Override
    public OrderDto getOrderInfo(String orderNo) {
        return baseChargeDao.selectOne("OrderChargeMapper.getOrderInfoByOrderNo", orderNo);
    }

    /**
     * 拼签名串
     */
    public static String getSignStr(Map<String, Object> paramMap) {
        Map<String, Object> map = new TreeMap<String, Object>(
                new Comparator<String>() {
                    public int compare(String obj1, String obj2) {
                        // 降序排序
                        return obj1.compareTo(obj2);
                    }
                });
        map.putAll(paramMap);

        StringBuffer bf = new StringBuffer();
        Set<String> keySet = map.keySet();
        Iterator<String> iter = keySet.iterator();
        boolean flag = true;
        while (iter.hasNext()) {

            String key = iter.next();
            System.out.println(key + ":" + map.get(key));
            if (flag) {
                bf.append(key).append("=").append(map.get(key));
            } else {
                bf.append("&").append(key).append("=").append(paramMap.get(key));
            }
            flag = false;
        }
        return bf.toString();
    }


    /**
     * 发送回调（统一逻辑规则）
     */
    public String sendNotifyRuitone(OrderNotify orderNotifyInfo, String key) {
        String sign = "";
        if (StringUtils.isNotBlank(key)) {
            sign = orderNotifyInfo.getAgtPhone() + orderNotifyInfo.getReqStreamId() + orderNotifyInfo.getState() + orderNotifyInfo.getOrderNo() + orderNotifyInfo.getPrice() + key;
        } else {
            sign = orderNotifyInfo.getAgtPhone() + orderNotifyInfo.getReqStreamId() + orderNotifyInfo.getState() + orderNotifyInfo.getOrderNo() + orderNotifyInfo.getPrice();
        }

        String notifyUrl = orderNotifyInfo.getNotifyUrl() + "?agtPhone=" + orderNotifyInfo.getAgtPhone()
                + "&reqStreamId=" + orderNotifyInfo.getReqStreamId() + "&state=" + orderNotifyInfo.getState()
                + "&orderNo=" + orderNotifyInfo.getOrderNo() + "&price=" + orderNotifyInfo.getPrice()
                + "&sign=" + MD5Utils.getSignatureByMD5(sign).toLowerCase();
        log.info("SendNotifyUrl=[" + notifyUrl + "]");
        HttpGet httpGet = new HttpGet(notifyUrl);
        httpGet.addHeader("Content-Type", "application/json; charset=utf-8");
        httpGet.addHeader("Accept", "application/json");
        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = HttpClientUtil.getSyncClient().execute(httpGet);
            HttpEntity respEntity = response.getEntity();
            result = EntityUtils.toString(respEntity);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("SendNotifyResult:reqStreamId=[" + orderNotifyInfo.getReqStreamId() + "]exception=["
                    + e.toString() + "]");
        }
        log.info("SendNotifyResult:reqStreamId=[" + orderNotifyInfo.getReqStreamId() + "]result=[" + result + "]");
        return result;
    }

    @Override
    public Map<String, String> getOrderInfoByOrderNo(OrderInfoVO orderInfoVO) {
        Map<String, String> resultMap = orderChargeDao.getOrderInfoByOrderNo(orderInfoVO);
        if (null == resultMap || resultMap.isEmpty()) {
            log.info("该订单已被支付或未找到有效收款银行账号!");
            throw new ServiceException(CommonConstants.BANK_CARD_NOT_EXIST, "该订单已被支付或未找到有效收款银行账号!");
        }
        return resultMap;
    }

    @Override
    public int updateOrderInfo(OrderInfoVO orderInfoVO) {
        return orderChargeDao.updateOrderInfo(orderInfoVO);
    }

    public void updateSendStatus(Map<String, Object> map) {
        orderChargeDao.updateSendStatus(map);
    }

    public void insertGameInfo(Map<String, Object> map) {
        orderChargeDao.insertGameInfo(map);
    }

    public void inserFailOrder(Map<String, Object> map) {
        orderChargeDao.inserFailOrder(map);
    }

    @Override
    public Map<String, Object> selectAgtByOrderNo(String orderNo) {
        return orderChargeDao.selectAgtByOrderNo(orderNo);
    }

    public List<Map<String, Object>> listFailOrder() {
        return orderChargeDao.listFailOrder();
    }

    public void deleteFailOrder(List<Map<String, Object>> failList) {
        orderChargeDao.deleteFailOrder(failList);
    }

    @Override
    public int insertRechargeOrder(OrderDto orderDto) {
        return orderChargeDao.insertRechargeOrder(orderDto);
    }


}
