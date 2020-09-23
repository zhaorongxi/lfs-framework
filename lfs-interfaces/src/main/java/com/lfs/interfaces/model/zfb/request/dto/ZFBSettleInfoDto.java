package com.lfs.interfaces.model.zfb.request.dto;

import java.io.Serializable;

public class ZFBSettleInfoDto implements Serializable {

    private static final long serialVersionUID = -56702916949225689L;

    /**
     *
     */
    private String settle_detail_infos;
    /**
     *
     */
    private String trans_in_type;
    /**
     *
     */
    private String trans_in;
    /**
     *
     */
    private String summary_dimension;
    /**
     *
     */
    private String settle_entity_id;
    /**
     *
     */
    private String sttle_entity_type;
    /**
     *
     */
    private String amount;
    /**
     *
     */
    private String settle_period_time;

    public String getSettle_detail_infos() {
        return settle_detail_infos;
    }

    public void setSettle_detail_infos(String settle_detail_infos) {
        this.settle_detail_infos = settle_detail_infos;
    }

    public String getTrans_in_type() {
        return trans_in_type;
    }

    public void setTrans_in_type(String trans_in_type) {
        this.trans_in_type = trans_in_type;
    }

    public String getTrans_in() {
        return trans_in;
    }

    public void setTrans_in(String trans_in) {
        this.trans_in = trans_in;
    }

    public String getSummary_dimension() {
        return summary_dimension;
    }

    public void setSummary_dimension(String summary_dimension) {
        this.summary_dimension = summary_dimension;
    }

    public String getSettle_entity_id() {
        return settle_entity_id;
    }

    public void setSettle_entity_id(String settle_entity_id) {
        this.settle_entity_id = settle_entity_id;
    }

    public String getSttle_entity_type() {
        return sttle_entity_type;
    }

    public void setSttle_entity_type(String sttle_entity_type) {
        this.sttle_entity_type = sttle_entity_type;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getSettle_period_time() {
        return settle_period_time;
    }

    public void setSettle_period_time(String settle_period_time) {
        this.settle_period_time = settle_period_time;
    }
}
