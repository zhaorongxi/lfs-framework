package com.bc.interfaces.common;

/**
 * Redis存放KEY
 *
 * @CreatedTime 2018/8/16 下午2:08
 * @Author dany
 * @Description TODO
 **/
public class RedisConstants {
    /**
     * redis 默认次数
     */
    public static final Integer vailCount = 5;
    /**
     * 登录用户信息
     */
    public static final String USER_INFO = "hash:userInfo";

    /**
     * 用户token
     */
    public static final String JWT_TOKEN = "string:jwtToken";

    /**
     * 锁定用户记录次数
     */
    public static final String LOCK_USER_COUNT = "string:lockUserCount:";

    /**
     * 重置密码
     */
    public static final String SEND_REST_PWD_CODE = "string:restPwdCode:";
    /**
     * 修改手机号
     */
    public static final String SEND_UPDATE_MOBILE__CODE = "string:updateMobileCode:";
    /**
     * 验证码60秒
     */
    public static final String SEND_SIXTY_CODE = ":sixtyCode";

}
