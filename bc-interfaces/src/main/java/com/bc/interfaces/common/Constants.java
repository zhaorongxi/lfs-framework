package com.bc.interfaces.common;

import com.bc.base.util.RandomUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;


public class Constants {

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

    /**
     * 根据businessCode获取accountType
     */
    public static Integer getAccountTypeByBusinessCode(String businessCode) {
        Integer accountType = 20;
        switch (businessCode) {
            case "GDYD":
                accountType = 1;
                break;
            case "GDLT":
                accountType = 2;
                break;
            case "GDDX":
                accountType = 3;
                break;
            case "QGCZ":
                accountType = 4;
                break;
            case "QBCZ":
                accountType = 5;
                break;
            case "ALIPAY":
                accountType = 6;
                break;
            case "GYCZ":
                accountType = 10;
                break;
            case "DXGH":
                accountType = 12;
                break;
            case "LTGH":
                accountType = 13;
                break;
            case "LLYD":
                accountType = 28;
                break;
            case "LLLT":
                accountType = 30;
                break;
            case "LLDX":
                accountType = 31;
                break;
            case "LLQGYD":
                accountType = 32;
                break;
            case "LLQGLT":
                accountType = 33;
                break;
            case "LLQGDX":
                accountType = 34;
                break;
            case "ZHYD":
                accountType = 1;
                break;
            case "ZHQSYD":
                accountType = 1;
                break;
            case "JYYD":
                accountType = 1;
                break;
            case "FSYD":
                accountType = 1;
                break;
            case "SZYD":
                accountType = 1;
                break;
            case "ZJYD":
                accountType = 4;
                break;
            case "QGCZ1":
                accountType = 4;
                break;
            case "HNYD":
                accountType = 4;
                break;
            default:
                accountType = 20;
                break;
        }
        return accountType;
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
