package com.bc.interfaces.product.service.impl;

import com.bc.interfaces.common.CommonConstants;
import com.bc.interfaces.dto.ResultReturn;
import com.bc.interfaces.agent.service.AgentSerivce;
import com.bc.interfaces.dao.OrderChargeDao;
import com.bc.interfaces.dao.ProductDao;
import com.bc.interfaces.model.ChannelInfo;
import com.bc.interfaces.model.Product;
import com.bc.interfaces.model.dto.ChargeDto;
import com.bc.interfaces.model.dto.OrderCharge;
import com.bc.interfaces.model.vo.*;
import com.bc.interfaces.product.service.ProductService;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

	@Resource
	private AgentSerivce agentSerivce;

	@Resource
	private ProductDao productDao;
	@Resource
	private OrderChargeDao chargeDao;

	/**
	 * 查询用户产品列表
	 */
	@Override
	public ResultReturn<List<ProductInfoVo>> getProductList(String agtPhone) {
		ResultReturn<List<ProductInfoVo>> resultReturn = new ResultReturn<>();
		List<ProductInfoVo> list = new ArrayList<>();
		try {
			List<AgentVo> agents = agentSerivce.getAgentInfoByPhone(agtPhone).getData();
			if (CollectionUtils.isNotEmpty(agents)) {
				AgentVo agent = agents.get(0);
				// 查询产品
				List<Product> products = productDao.getProductListByAgtNo(agent.getAgtNo());
				for (Product product : products) {
					ProductInfoVo vo = new ProductInfoVo();
					vo.setArriveType(product.getArriveType());
					vo.setBusinessCode(product.getBusinessCode());
					vo.setBusinessName(product.getBusinessName());
					vo.setDiscount(product.getDiscount());
					vo.setPrice(product.getPrice());
					vo.setProductCode(product.getProductCode());
					vo.setTradeFace(product.getTradeFace());
					list.add(vo);
				}
				resultReturn.setStatus(CommonConstants.RESP_CHARGE_SUCCESS).setData(list).setMsg("产品查询成功");
			} else {
				resultReturn.setStatus(CommonConstants.RESP_CHARGE_FAIL).setData(list).setMsg("代理商账户有误");
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			resultReturn.setStatus(CommonConstants.RESP_CHARGE_EXCETION).setData(list).setMsg("查询异常");
		}
		return resultReturn;
	}

	/**
	 * 校验交易信息（代理商个人信息、密码、余额、产品权限、价格）
	 */
	@Override
	public ResultReturn<ProductVo> verifyOrder(ChargeDto dto) {
		ResultReturn<ProductVo> resp = new ResultReturn<>();
		ProductVo vo = new ProductVo();
		try {
			OrderCharge queryOrder = new OrderCharge();
			queryOrder.setAgtPhone(dto.getAgtPhone());
			queryOrder.setDownOrderNo(dto.getReqStreamId());
			List<OrderCharge> orders = chargeDao.getOrderInfo(queryOrder);
			if (CollectionUtils.isNotEmpty(orders)) {
				resp.setStatus(CommonConstants.RESP_CHARGE_SAMEreq_stream_id).setMsg("不允许重复流水号提交").setData(vo);
			} else {
				List<AgtSecurityVo> securities = agentSerivce.verifyOrder(dto.getAgtPhone());
				if (securities.size() > 0) {
					if (securities.get(0).getState() == 0) {
						// 查询产品
						Map<String, Object> map = new HashMap<>();
						map.put("agtNo", securities.get(0).getAgtNo());
						map.put("productCode", dto.getProductCode());
						map.put("chargeType", dto.getChargeType());
						log.info("【校验订单信息】,agtNo={},productCode={},chargeType={}", securities.get(0).getAgtNo(),
								dto.getProductCode(), dto.getChargeType());
						List<Product> products = productDao.getProductRightByAgtNo(map);
						if (CollectionUtils.isNotEmpty(products)) {
							Product product = products.get(0);
							vo.setArriveType(product.getArriveType());
							vo.setBusinessCode(product.getBusinessCode());
							vo.setDiscount(product.getDiscount());
							vo.setPrice(product.getPrice());
							vo.setProductCode(product.getProductCode());
							vo.setTradeFace(product.getTradeFace());
							vo.setUpChannel(product.getUpChannel());
							vo.setProductType(product.getProductType());
							resp.setStatus(CommonConstants.RESP_CHARGE_SUCCESS).setMsg("产品信息获取成功")
									.setData(vo);
						} else {
							resp.setStatus(CommonConstants.RESP_CHARGE_VALIDPRODUCT).setMsg("产品未上架").setData(vo);
						}
					} else {
						resp.setStatus(CommonConstants.RESP_CHARGE_WRONG).setMsg("代理账号被冻结").setData(vo);
					}
				} else {
					resp.setStatus(CommonConstants.RESP_CHARGE_VERFITY).setMsg("代理账号不存在").setData(vo);
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			resp.setStatus(CommonConstants.RESP_CHARGE_FAIL).setMsg("获取产品信息失败").setData(vo);
		}
		return resp;
	}
	


	/**
	 * 查询供应商渠道详情
	 */
	@Override
	public ResultReturn<ChannelInfoVo> getChannelInfoById(String channelNo) {
		ResultReturn<ChannelInfoVo> resultReturn = new ResultReturn<>();
		ChannelInfoVo vo = new ChannelInfoVo();
		try {
			List<ChannelInfo> channelInfos = productDao.getChannelInfoById(channelNo);
			if (CollectionUtils.isNotEmpty(channelInfos)) {
				ChannelInfo info = channelInfos.get(0);
				vo.setChannelDetail(info.getChannelDetail());
				vo.setChannelName(info.getChannelName());
				vo.setChannelNo(info.getChannelNo());
				vo.setChannelState(info.getChannelState());
				resultReturn.setStatus(CommonConstants.SUCCESS).setMsg("获取供应商信息成功").setData(vo);
			} else {
				resultReturn.setStatus(CommonConstants.FAIL).setMsg("获取供应商信息失败").setData(vo);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			resultReturn.setStatus(CommonConstants.EXCEPTION).setMsg("获取供应商信息失败").setData(vo);
		}
		return resultReturn;
	}

	public String getproductCode(Map<String, Object> paramMap) {
		return productDao.getproductCode(paramMap);
	}

	public ResultReturn<ProductVo> sendVerifyOrder(ChargeDto dto) {
		ResultReturn<ProductVo> resp = new ResultReturn<>();
		ProductVo vo = new ProductVo();
		try {
			OrderCharge queryOrder = new OrderCharge();
			queryOrder.setAgtPhone(dto.getAgtPhone());
			queryOrder.setDownOrderNo(dto.getReqStreamId());
			List<AgtSecurityVo> securities = agentSerivce.verifyOrder(dto.getAgtPhone());
			if (securities.size() > 0) {
				if (securities.get(0).getState() == 0) {
					// 查询产品
					Map<String, Object> map = new HashMap<>();
					map.put("agtNo", securities.get(0).getAgtNo());
					map.put("productCode", dto.getProductCode());
					List<Product> products = productDao.getProductRightByAgtNo(map);
					if (CollectionUtils.isNotEmpty(products)) {
						Product product = products.get(0);
						vo.setArriveType(product.getArriveType());
						vo.setBusinessCode(product.getBusinessCode());
						vo.setDiscount(product.getDiscount());
						vo.setPrice(product.getPrice());
						vo.setProductCode(product.getProductCode());
						vo.setTradeFace(product.getTradeFace());
						vo.setUpChannel(product.getUpChannel());
						vo.setProductType(product.getProductType());
						resp.setStatus(CommonConstants.RESP_CHARGE_SUCCESS).setMsg("产品信息获取成功").setData(vo);

					} else {
						resp.setStatus(CommonConstants.RESP_CHARGE_VALIDPRODUCT).setMsg("产品未上架").setData(vo);
					}
				} else {
					resp.setStatus(CommonConstants.RESP_CHARGE_VERFITY).setMsg("代理账号冻结").setData(vo);
				}
			} else {
				resp.setStatus(CommonConstants.RESP_CHARGE_WRONG).setMsg("代理账号信息不存在").setData(vo);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			resp.setStatus(CommonConstants.RESP_CHARGE_FAIL).setMsg("获取产品信息失败").setData(vo);
		}
		return resp;
	}

	public List<Map<String, Object>> getAdapter(ChargeDto chargeDto) {
		return productDao.getAdapter(chargeDto);
	}


	/**
	 * 查询手机号码是否允许提交订单
	 */
	@Override
	public ResultReturn<ProductVo> checkAllowCharge(String mobile, Integer count) {
		ResultReturn<ProductVo> resp = new ResultReturn<>();
		ProductVo vo = new ProductVo();
		try {
			Integer result = agentSerivce.checkAllowCharge(mobile);
			if (result >= count) {
				resp.setStatus(CommonConstants.RESP_NO_ALLOW_CHARGE).setMsg("当天充值失败次数达到10次").setData(vo);
			} else {
				resp.setStatus(CommonConstants.RESP_CHARGE_SUCCESS).setMsg("校验通过").setData(vo);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			resp.setStatus(CommonConstants.RESP_CHARGE_FAIL).setMsg("获取当天充值失败次数异常").setData(vo);
		}
		return resp;
	}

	@Override
	public List<Map<String, Object>> getChargeAdapter(ChargeDto chargeDto) {
		return productDao.getChargeAdapter(chargeDto);
	}

}
