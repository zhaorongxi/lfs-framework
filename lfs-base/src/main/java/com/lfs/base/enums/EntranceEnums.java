package com.lfs.base.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum  EntranceEnums {
    PC(0,"PC端","string:pcUser:"),
    APP(1,"APP端","string:appUser:"),
    MINI(3,"小程序","string:miniProgram:");

    private Integer entranceId;

    private String description;

    private String redisKey;

    private static final Map lookMap = new HashMap();

    static {
        for (EntranceEnums e : EnumSet.allOf(EntranceEnums.class)){
            lookMap.put(e.getEntranceId(),e);
        }
    }

    public String getRedisKey(){return redisKey;}

    public Integer getEntranceId(){return entranceId;}

    public String getDescription(){return description;}

    EntranceEnums(Integer entranceId,String description,String redisKey){
        this.entranceId = entranceId;
        this.description = description;
        this.redisKey = redisKey;
    }
}
