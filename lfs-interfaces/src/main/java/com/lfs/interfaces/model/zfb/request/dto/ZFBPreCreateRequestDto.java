package com.lfs.interfaces.model.zfb.request.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZFBPreCreateRequestDto implements Serializable {

    private static final long serialVersionUID = 2484062310554825522L;
    /**
     * 商户订单号,64个字符以内、只能包含字母、数字、下划线；需保证在商户端不重复
     */
    private String out_trade_no;
    /**
     * 卖家支付宝用户ID。 如果该值为空，则默认为商户签约账号对应的支付宝用户ID
     */
    private String seller_id;
    /**
     * 订单总金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000] 如果同时传入了【打折金额】，
     * 【不可打折金额】，【订单总金额】三者，则必须满足如下条件：【订单总金额】=【打折金额】+【不可打折金额】
     */
    private BigDecimal total_amount;
    /**
     * 可打折金额. 参与优惠计算的金额，单位为元，精确到小数点后两位，取值范围[0.01,100000000]
     * 如果该值未传入，但传入了【订单总金额】和【不可打折金额】，则该值默认为【订单总金额】-【不可打折金额】
     */
    private BigDecimal discountable_amount;
    /**
     * 订单标题
     */
    private String subject;

    /**
     *
     */
    private ZFBGoodsDetailsDto goods_detail;

    /**
     *
     */
    private String body;
    /**
     *
     */
    private String product_code;
    /**
     *
     */
    private String operator_id;
    /**
     *
     */
    private String store_id;
    /**
     *
     */
    private String disable_pay_channels;
    /**
     *
     */
    private String enable_pay_channels;
    /**
     *
     */
    private String terminal_id;
    /**
     *
     */
    private ZFBExtendParamsDto extend_params;

    /**
     *
     */
    private String timeout_express;
    /**
     *
     */
    private ZFBSettleInfoDto settle_info;
    /**
     *
     */
    private String merchant_order_no;
    /**
     *
     */
    private ZFBBusinessParamsDto business_params;

    /**
     * 该笔订单允许的最晚付款时间，逾期将关闭交易，从生成二维码开始计时。
     * 取值范围：1m～15d。m-分钟，h-小时，d-天，1c-当天（1c-当天的情况下，无论交易何时创建，都在0点关闭）。
     * 该参数数值不接受小数点， 如 1.5h，可转换为 90m。
     */
    private String qr_code_timeout_express;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public BigDecimal getDiscountable_amount() {
        return discountable_amount;
    }

    public void setDiscountable_amount(BigDecimal discountable_amount) {
        this.discountable_amount = discountable_amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public ZFBGoodsDetailsDto getGoods_detail() {
        return goods_detail;
    }

    public void setGoods_detail(ZFBGoodsDetailsDto goods_detail) {
        this.goods_detail = goods_detail;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getProduct_code() {
        return product_code;
    }

    public void setProduct_code(String product_code) {
        this.product_code = product_code;
    }

    public String getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(String operator_id) {
        this.operator_id = operator_id;
    }

    public String getStore_id() {
        return store_id;
    }

    public void setStore_id(String store_id) {
        this.store_id = store_id;
    }

    public String getDisable_pay_channels() {
        return disable_pay_channels;
    }

    public void setDisable_pay_channels(String disable_pay_channels) {
        this.disable_pay_channels = disable_pay_channels;
    }

    public String getEnable_pay_channels() {
        return enable_pay_channels;
    }

    public void setEnable_pay_channels(String enable_pay_channels) {
        this.enable_pay_channels = enable_pay_channels;
    }

    public String getTerminal_id() {
        return terminal_id;
    }

    public void setTerminal_id(String terminal_id) {
        this.terminal_id = terminal_id;
    }

    public ZFBExtendParamsDto getExtend_params() {
        return extend_params;
    }

    public void setExtend_params(ZFBExtendParamsDto extend_params) {
        this.extend_params = extend_params;
    }

    public String getTimeout_express() {
        return timeout_express;
    }

    public void setTimeout_express(String timeout_express) {
        this.timeout_express = timeout_express;
    }

    public ZFBSettleInfoDto getSettle_info() {
        return settle_info;
    }

    public void setSettle_info(ZFBSettleInfoDto settle_info) {
        this.settle_info = settle_info;
    }

    public String getMerchant_order_no() {
        return merchant_order_no;
    }

    public void setMerchant_order_no(String merchant_order_no) {
        this.merchant_order_no = merchant_order_no;
    }

    public ZFBBusinessParamsDto getBusiness_params() {
        return business_params;
    }

    public void setBusiness_params(ZFBBusinessParamsDto business_params) {
        this.business_params = business_params;
    }

    public String getQr_code_timeout_express() {
        return qr_code_timeout_express;
    }

    public void setQr_code_timeout_express(String qr_code_timeout_express) {
        this.qr_code_timeout_express = qr_code_timeout_express;
    }
}
