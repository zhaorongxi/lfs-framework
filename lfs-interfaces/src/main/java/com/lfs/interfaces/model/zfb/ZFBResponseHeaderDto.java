package com.lfs.interfaces.model.zfb;

import java.io.Serializable;

public class ZFBResponseHeaderDto implements Serializable {
    private static final long serialVersionUID = -2631989860173965864L;

    /**
     * 网关返回码,详见文档
     */
    private String code;

    /**
     * 网关返回码描述,详见文档
     */
    private String msg;

    /**
     * 业务返回码，参见具体的API接口文档
     */
    private String sub_cdoe;

    /**
     * 业务返回码描述，参见具体的API接口文档
     */
    private String sub_msg;

    /**
     * 签名,详见文档
     */
    private String sign;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getSub_cdoe() {
        return sub_cdoe;
    }

    public void setSub_cdoe(String sub_cdoe) {
        this.sub_cdoe = sub_cdoe;
    }

    public String getSub_msg() {
        return sub_msg;
    }

    public void setSub_msg(String sub_msg) {
        this.sub_msg = sub_msg;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
