package com.lfs.interfaces.model.zfb.request.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZFBGoodsDetailsDto implements Serializable {


    private static final long serialVersionUID = 747706847762656818L;

    /**
     *
     */
    private String goods_id;
    /**
     *
     */
    private String goods_name;
    /**
     *
     */
    private Integer quantity;
    /**
     *
     */
    private BigDecimal price;
    /**
     *
     */
    private String goods_category;
    /**
     *
     */
    private String categories_tree;
    /**
     *
     */
    private String body;
    /**
     *
     */
    private String show_url;

    public String getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(String goods_id) {
        this.goods_id = goods_id;
    }

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getGoods_category() {
        return goods_category;
    }

    public void setGoods_category(String goods_category) {
        this.goods_category = goods_category;
    }

    public String getCategories_tree() {
        return categories_tree;
    }

    public void setCategories_tree(String categories_tree) {
        this.categories_tree = categories_tree;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getShow_url() {
        return show_url;
    }

    public void setShow_url(String show_url) {
        this.show_url = show_url;
    }
}
