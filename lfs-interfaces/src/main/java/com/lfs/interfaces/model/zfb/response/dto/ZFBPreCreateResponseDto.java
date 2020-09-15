package com.lfs.interfaces.model.zfb.response.dto;

import java.io.Serializable;

public class ZFBPreCreateResponseDto implements Serializable {
    private static final long serialVersionUID = -9122712995755428956L;

    /**
     * 商户的订单号
     */
    private String out_trade_no;

    /**
     * 当前预下单请求生成的二维码码串，可以用二维码生成工具根据该码串值生成对应的二维码
     */
    private String qr_code;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getQr_code() {
        return qr_code;
    }

    public void setQr_code(String qr_code) {
        this.qr_code = qr_code;
    }
}
