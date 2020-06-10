package com.bc.base.enums;

public enum ExportTypeEnums {

    SUM_CHANNEL_EXPORT_TYPE(1),
    CHANNEL_DETAIL_EXPORT_TYPE(2),
    SUM_EXPORT_TYPE(3);

    private Integer typeCode;

    ExportTypeEnums(Integer typeCode) {
        this.typeCode = typeCode;
    }
    public Integer getTypeCode() {
        return this.typeCode;
    }
}
