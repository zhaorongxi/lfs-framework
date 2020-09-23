package com.lfs.common.constant;

import com.lfs.common.utils.RandomUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

public class Constant {

    // http连接超时时间
    public static final int SO_TIMEOUT = 30 * 1000;
    // 数据传输超时时间
    public static final int SO_TIMEOUT_DATA = 60 * 1000;

    public static final String ORDER_SEND_READY = "1";// 待发
    public static final String ORDER_SEND_SEND = "2";// 已发
    public static final String ORDER_SEND_SUCCESS = "6";// 成功
    public static final String ORDER_SEND_FAIL = "4";// 失败
    public static final String ORDER_SEND_FENG = "5";// 风控

    public static final String REC_SEND_READY = "0";// 待发
    public static final String REC_SEND_SEND = "1";// 已发
    public static final String REC_SEND_SUCCESS = "2";// 成功
    public static final String REC_SEND_REPEAT = "3";// 重发
    public static final String REC_SEND_FAIL = "4";// 失败

    public static final int ADAPTER_SUCCESS = 0;// 适配器解析成功
    public static final int ADAPTER_ERROR = 1;// 适配器解析失败

    public static final String DEL_REDIS_URL = "del_redis_url";
    public static final String ADD_REDIS_URL = "add_redis_url";
    public static final String GET_REDIS_URL = "get_redis_url";
    public static final String DELALL = "DELALL";
    public static final String T_CHANNEL_SUPPLIER = "channel_supplier";// 表
    public static final String T_SMS_TEMPLATE = "sms_template";// 表
    public static final String HASH_APP_AUTH_LIST = "hash:appAuthList";
    public static final String HASH_BANK_INFO_LIST = "hash:bankInfoList";
    public static final String HASH_BANK_INFO_COUNT = "hash:bankInfoCount";
    public static final String HASH_AGENT_INFO_LIST = "hash:agtInfoList";
    public static final String HASH_AGENT_APP_KEY = "hash:agentAppKey";

    public static String getMilliSecond() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSSS", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getTimeStamp() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmssSSS", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getDateTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getSecond() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getSecond2() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmmss", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getSecondTime() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static String getHourAndMinute() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HHmm", Locale.CHINA);
        return simpleDateFormat.format(date);
    }

    public static Long getDateDifferenceOfMinute(String sDate, String eDate) {
        try {
            DateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
            Date d1 = simpleDateFormat.parse(eDate);
            Date d2 = simpleDateFormat.parse(sDate);
            Long diff = d1.getTime() - d2.getTime();
            return diff / (60 * 1000);
        } catch (Exception e) {
            return (long) -1;
        }
    }

    /**
     * 获取时间戳+5为随机数
     */
    public static String getOrderNo() {
        String date = String.valueOf(System.currentTimeMillis());
        return date + getVerificationCode(5);
    }

    /**
     * 获取时间戳+4为随机数
     */
    public static String getOrderNo17() {
        String date = String.valueOf(System.currentTimeMillis());
        return date + getVerificationCode(4);
    }

    /**
     * 随机生成4位数的验证码
     */
    public static String getVerificationCode(int length) {
        StringBuffer vcode = new StringBuffer();
        vcode.append(RandomUtils.randomNumber(length));
        return vcode.toString();
    }

    /**
     * 20位长度流水号
     */
    public static String getStreamId20() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmssSSSS", Locale.CHINA);
        return simpleDateFormat.format(date) + getVerificationCode(2);
    }

    /* 获取guid */
    public static String getGuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().toLowerCase().replace("-", "");
    }

    /**
     * 获取自1970年1月1号以来的毫秒数
     *
     * @return
     */
    public static String getTimestampStr() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = formater.parse("1970-01-01 00:00:00");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long time = System.currentTimeMillis() - date.getTime();
        return String.valueOf(time).substring(0, 10);
    }

    public static final int SUCCESS = 0;

    public static final int FAILED = 1;

    public static final int ERROR = 2;

    public static final int EXCEPTION = 3;

    public static final int WRONG = 4;

    public static final int VERFITY = 5;

    public static final int BALANCE = 6;

    public static final int RESERVALCOUNT = 8;

    public static final int VALIDBUSINESS = 7;

    public static final int PROFITBALANCE = 9;

    public static final String DATE_PATTERN = "yyyy-MM-dd";

    public static final String DATETime_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final String RET_SUCCESS = "success";

    public static final String RET_FAIL = "fail";

    public static final String RET_ERROR = "error";

    public static final String RET_EXCEPTION = "exception";

    public static final String ENCODING_UTF8 = "UTF-8";

    public static final String GDYDREVERSAL = "GDYDCL";

    public static final String GDLTREVERSAL = "GDLTCL";

    public static final String GDDXREVERSAL = "GDDXCL";

    public static final String GDDXGHREVERSAL = "GDDXGHCL";// 电信固话冲正 编码

    public static final String GDLTGHREVERSAL = "GDLTGHCL"; // 联通固话冲正 编码

    public static final Long QBPRODUCTID=65L;
    public static final Long ZFBPRODUCTID=66L;
    /* 财付通网关支付Key */

    public static final String TENPAY_PARTER = "1205209401"; // 商户号

    public static final String TENPAY_KEY = "72e8b44461ac10ab28e4c0f46f400f44";// 商户秘钥

    // 限制充值号码黑名单
    public static String limitNums = "15707550148,15707550104,14715000155,14715000154,13802881256,13500253864,13500254864,13527626997,15088002035,18207543545,18807666104,18807666007,13537987031,13537983647,13537986540";

    //当天单个充值号码限制次数
    public static final int LIMIT_NUM = 10;

    public static final int USER_ENABLE_STATUE = 0;

    public static final int USER_UNENABLE_STATUE = 1;
}
