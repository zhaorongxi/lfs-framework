package com.bc.interfaces.model.dto;

/**
 * Copyright: Copyright (c) 2019  Dylan
 * @ClassName: TokenDateModelDTO
 * @Description: token解析DTO
 * @version: v1.0.0
 * @date 2019年2月28日18:44:10
 */
public class TokenDateModelDTO {
    /**
     * token类型
     */
    private Integer type;
    /**
     * 用户token
     */
    private  String accessToken;
    /**
     * 用户ID
     */
    private  Integer userId;

    public Integer getType() {
        return type;
    }

    public TokenDateModelDTO setType(Integer type) {
        this.type = type;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public TokenDateModelDTO setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public TokenDateModelDTO(Integer type, String accessToken) {
        this.type = type;
        this.accessToken = accessToken;
    }

    public Integer getUserId() {
        return userId;
    }

    public TokenDateModelDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public TokenDateModelDTO() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TokenDateModelDTO{");
        sb.append("type=").append(type);
        sb.append(", accessToken='").append(accessToken).append('\'');
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
