package com.bc.interfaces.model.zfb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ZFBNotifyDto implements Serializable {


    private static final long serialVersionUID = 1209543466782100797L;

    /**
     * 通知的发送时间。格式为yyyy-MM-dd HH:mm:ss
     */
    private Date notify_time;

    /**
     * 通知的类型
     */
    private String notify_type;

    /**
     *通知校验 ID
     */
    private String notify_id;

    /**
     *商户生成签名字符串所使用的签名算法类型，目前支持RSA2和RSA，推荐使用RSA2（如果开发者手动验签，不使用 SDK 验签，可以不传此参数）
     */
    private String sign_type;

    /**
     *请参考异步返回结果的验签（如果开发者手动验签，不使用 SDK 验签，可以不传此参数）
     */
    private String sign;

    /**
     *支付宝交易凭证号
     */
    private String trade_no;

    /**
     *支付宝分配给开发者的应用Id
     */
    private String app_id;
    /**
     *原支付请求的商户订单号
     */
    private String out_trade_no;
    /**
     *商户业务ID，主要是退款通知中返回退款申请的流水号
     */
    private String out_biz_no;
    /**
     *买家支付宝账号对应的支付宝唯一用户号。以 2088 开头的纯 16 位数字
     */
    private String buyer_id;
    /**
     *买家支付宝账号
     */
    private String buyer_logon_id;
    /**
     *卖家支付宝用户号
     */
    private String seller_id;
    /**
     *卖家支付宝账号
     */
    private String seller_email;
    /**
     *交易目前所处的状态
     */
    private String trade_status;
    /**
     *本次交易支付的订单金额，单位为人民币（元）
     */
    private BigDecimal total_amount;
    /**
     *商家在交易中实际收到的款项，单位为元
     */
    private BigDecimal receipt_amount;
    /**
     *用户在交易中支付的可开发票的金额
     */
    private BigDecimal invoice_amount;
    /**
     *用户在交易中支付的金额
     */
    private BigDecimal buyer_pay_amount;
    /**
     *使用集分宝支付的金额
     */
    private BigDecimal point_amount;
    /**
     *退款通知中，返回总退款金额，单位为元，支持两位小数
     */
    private BigDecimal refund_fee;
    /**
     *商户实际退款给用户的金额，单位为元，支持两位小数
     */
    private BigDecimal send_back_fee;
    /**
     *商品的标题/交易标题/订单标题/订单关键字等，是请求时对应的参数，原样通知回来
     */
    private String subject;
    /**
     *该订单的备注、描述、明细等。对应请求时的body参数，原样通知回来
     */
    private String body;
    /**
     *该笔交易创建的时间。格式为yyyy-MM-dd HH:mm:ss
     */
    private Date gmt_create;
    /**
     *该笔交易的买家付款时间。格式为yyyy-MM-dd HH:mm:ss
     */
    private Date gmt_payment;
    /**
     *该笔交易的退款时间。格式为yyyy-MM-dd HH:mm:ss.S
     */
    private Date gmt_refund;
    /**
     *该笔交易结束时间。格式为yyyy-MM-dd HH:mm:ss
     */
    private Date gmt_close;
    /**
     *支付成功的各个渠道金额信息，详见资金明细信息说明
     */
    private String fund_bill_list;

    public Date getNotify_time() {
        return notify_time;
    }

    public void setNotify_time(Date notify_time) {
        this.notify_time = notify_time;
    }

    public String getNotify_type() {
        return notify_type;
    }

    public void setNotify_type(String notify_type) {
        this.notify_type = notify_type;
    }

    public String getNotify_id() {
        return notify_id;
    }

    public void setNotify_id(String notify_id) {
        this.notify_id = notify_id;
    }

    public String getSign_type() {
        return sign_type;
    }

    public void setSign_type(String sign_type) {
        this.sign_type = sign_type;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getOut_biz_no() {
        return out_biz_no;
    }

    public void setOut_biz_no(String out_biz_no) {
        this.out_biz_no = out_biz_no;
    }

    public String getBuyer_id() {
        return buyer_id;
    }

    public void setBuyer_id(String buyer_id) {
        this.buyer_id = buyer_id;
    }

    public String getBuyer_logon_id() {
        return buyer_logon_id;
    }

    public void setBuyer_logon_id(String buyer_logon_id) {
        this.buyer_logon_id = buyer_logon_id;
    }

    public String getSeller_id() {
        return seller_id;
    }

    public void setSeller_id(String seller_id) {
        this.seller_id = seller_id;
    }

    public String getSeller_email() {
        return seller_email;
    }

    public void setSeller_email(String seller_email) {
        this.seller_email = seller_email;
    }

    public String getTrade_status() {
        return trade_status;
    }

    public void setTrade_status(String trade_status) {
        this.trade_status = trade_status;
    }

    public BigDecimal getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(BigDecimal total_amount) {
        this.total_amount = total_amount;
    }

    public BigDecimal getReceipt_amount() {
        return receipt_amount;
    }

    public void setReceipt_amount(BigDecimal receipt_amount) {
        this.receipt_amount = receipt_amount;
    }

    public BigDecimal getInvoice_amount() {
        return invoice_amount;
    }

    public void setInvoice_amount(BigDecimal invoice_amount) {
        this.invoice_amount = invoice_amount;
    }

    public BigDecimal getBuyer_pay_amount() {
        return buyer_pay_amount;
    }

    public void setBuyer_pay_amount(BigDecimal buyer_pay_amount) {
        this.buyer_pay_amount = buyer_pay_amount;
    }

    public BigDecimal getPoint_amount() {
        return point_amount;
    }

    public void setPoint_amount(BigDecimal point_amount) {
        this.point_amount = point_amount;
    }

    public BigDecimal getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(BigDecimal refund_fee) {
        this.refund_fee = refund_fee;
    }

    public BigDecimal getSend_back_fee() {
        return send_back_fee;
    }

    public void setSend_back_fee(BigDecimal send_back_fee) {
        this.send_back_fee = send_back_fee;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_payment() {
        return gmt_payment;
    }

    public void setGmt_payment(Date gmt_payment) {
        this.gmt_payment = gmt_payment;
    }

    public Date getGmt_refund() {
        return gmt_refund;
    }

    public void setGmt_refund(Date gmt_refund) {
        this.gmt_refund = gmt_refund;
    }

    public Date getGmt_close() {
        return gmt_close;
    }

    public void setGmt_close(Date gmt_close) {
        this.gmt_close = gmt_close;
    }

    public String getFund_bill_list() {
        return fund_bill_list;
    }

    public void setFund_bill_list(String fund_bill_list) {
        this.fund_bill_list = fund_bill_list;
    }
}
