package com.bc.interfaces.model.zfb.request.dto;

import java.io.Serializable;

public class ZFBExtendParamsDto implements Serializable {

    private static final long serialVersionUID = 7974592678744854919L;
    /**
     *
     */
    private String sys_service_provider_id;
    /**
     *
     */
    private String card_type;

    public String getSys_service_provider_id() {
        return sys_service_provider_id;
    }

    public void setSys_service_provider_id(String sys_service_provider_id) {
        this.sys_service_provider_id = sys_service_provider_id;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

}
