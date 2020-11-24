package com.lfs.common.constant;

import com.lfs.common.utils.RandomUtils;

public class CommonConstants {
    public static final int DEFAULT = -1;
    public static final int SUCCESS = 0;
    public static final int FAIL = 1;
    public static final int HANDLE = 2;
    public static final int EXCEPTION = 3;
    public static final int CALL_BACK_SUCCESS = 5;
    public static final int CALL_BACK_FAIL = 6;

    public static final int NOTIFY_WAIT = 0;
    public static final int NOTIFY_NO_RESPONSE = 1;
    public static final int NOTIFY_SUCCESS = 2;
    public static final int NOTIFY_SENDING = 3;
    public static final int NOTIFY_FAIL = 4;
    public static final int NOTIFY_WAIT_CHECK_MONEY = 5;
    public static final int NOTIFY_CHECK_MONEY = 6;

    public static final Integer ADAPTER_NOTIFY_STATUS = 1;

    /**
     * 银行卡状态
     */
    public static final int BANK_INFO_ENABLE = 0;
    public static final int BANK_INFO_NOT_ENABLE = 1;
    public static final int BANK_INFO_FORBIDDEN = 2;

    /**
     * 提现申请审批状态
     */
    public static final int WALLET_APPROVE_HANDLE = 0;
    public static final int WALLET_APPROVE_CANCEL = 1;
    public static final int WALLET_APPROVE_SUCCESS = 2;

    /**
     * 加密类型
     */
    public static final int SECURITY_FOR_JAVA = 1;
    public static final int SECURITY_FOR_C = 2;
    public static final int SECURITY_FOR_PYTHON = 3;
    public static final int SECURITY_FOR_PHP = 4;


    /**
     * 调用下游告诉下游失败
     */

    public static final String DOWN_STREAM="fail";
    public static final String NOTIFY_DOWN_SUCCESS="success";
    public static final Integer RESP_CHARGE_SUCCESS = 1000;
    public static final Integer RESP_CHARGE_FAIL = 1001;
    public static final Integer RESP_CHARGE_ERROR = 1002;
    public static final Integer RESP_CHARGE_EXCETION = 1003;
    public static final Integer RESP_CHARGE_WRONG = 1004;
    public static final Integer RESP_CHARGE_VERFITY = 1005;
    public static final Integer RESP_CHARGE_VALIDBUSINESS = 1006;
    public static final Integer RESP_CHARGE_VALID_SUCCESS = 1007;
    public static final Integer RESP_CHARGE_VALIDPRODUCT = 1008;
    public static final Integer RESP_CHARGE_VALID_FAIL = 1009;
    public static final Integer RESP_CHARGE_BALANCE = 1010;
    public static final Integer RESP_CHARGE_HANDLE = 1011;
    public static final Integer RESP_CHARGE_VALIDAGT = 1013;
    public static final Integer RESP_CHARGE_TIMEOUT = 1014;
    public static final Integer RESP_CHARGE_NOORDER = 1015;
    public static final Integer RESP_CHARGE_SAMEreq_stream_id = 1016;
    public static final Integer RESP_CHARGE_REQUESTTOFAST = 1017;
    public static final Integer RESP_CHARGE_REVERSAL = 1018;
    public static final Integer RESP_QUERY_CLOSE = 1019;
    public static final Integer RESP_NOT_IP = 1020;
    public static final Integer YD_AUTH_FAIL = 1021;
    public static final Integer YD_CHARGE_FAIL = 1022;
    public static final Integer RESP_NO_ALLOW_CHARGE = 1023;
    public static final Integer REPEAT_BANK_CARD = 1024;
    public static final Integer BANK_CARD_NOT_EXIST = 1025;
    public static final Integer NOT_ENOUGH_BALANCE = 1026;
    public static final Integer ACCOUNT_TYPE_COMPANY = 2;
    public static final String ALIPAY_TYPE = "1";
    public static final String WE_CHAT_TYPE = "2";
    public static final String BANK_CARD_TYPE = "3";

    /**
     * 日志类型
     */

    /**
     * 新增日志
     */
    public static final int LOG_ADD_TYPE = 0;

    /**
     * 修改日志
     */
    public static final int LOG_UPDATE_TYPE = 1;

    /**
     * 删除日志
     */
    public static final int LOG_DELETE_TYPE = 2;

    /**
     * 提现申请操作日志
     */
    public static final int LOG_CASH_TYPE = 0;

    /**
     * 审批操作日志
     */
    public static final int LOG_APPROVE_TYPE = 1;

    /**
     * 回调确认操作日志
     */
    public static final int LOG_CALL_BACK_TYPE = 2;

    /**
     * 确认订单金额操作日志
     */
    public static final int LOG_CHECK_MONEY_TYPE = 3;

    /**
     * 新增代理商日志
     */
    public static final int LOG_AGENT_TYPE = 4;

    /**
     * 产品组操作日志
     */
    public static final int LOG_PRODUCT_GROUP_TYPE = 5;

    /**
     * 产品操作日志
     */
    public static final int LOG_PRODUCT_TYPE = 6;

    /**
     * 参数管理 cache key
     */
    public static final String SYS_CONFIG_KEY = "sys_config:";

    /**
     * 字典管理 cache key
     */
    public static final String SYS_DICT_KEY = "sys_dict:";


    public CommonConstants() {
    }

    public static String getOrderNo() {
        String date = String.valueOf(System.currentTimeMillis());
        return date + getVerificationCode(5);
    }

    public static String getVerificationCode(int length) {
        StringBuffer vcode = new StringBuffer();
        vcode.append(RandomUtils.randomNumber(length));
        return vcode.toString();
    }

}
