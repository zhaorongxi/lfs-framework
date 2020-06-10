package com.bc.dao.enums;

/**
 * 删除标示
 * @ClassName IsDelEnums
 * @CreatedTime 2018/8/3 上午10:38
 * @Author v-mol01
 * @Description TODO
 **/
public enum IsDelEnums {
    //删除
    DELETED(1,"删除"),
    //正常呢
    NORMAL(0,"正常")
    ;

    private Integer code;

    private String label;

    public Integer getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }
    IsDelEnums(Integer code, String label){
        this.code = code;
        this.label = label;
    }
}
