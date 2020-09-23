package com.lfs.common.utils.sign;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Md5加密方法
 * 
 * @author linxi
 */
public class Md5Utils
{
    private static final Logger log = LoggerFactory.getLogger(Md5Utils.class);

    private static byte[] md5(String s)
    {
        MessageDigest algorithm;
        try
        {
            algorithm = MessageDigest.getInstance("MD5");
            algorithm.reset();
            algorithm.update(s.getBytes("UTF-8"));
            byte[] messageDigest = algorithm.digest();
            return messageDigest;
        }
        catch (Exception e)
        {
            log.error("MD5 Error...", e);
        }
        return null;
    }

    private static final String toHex(byte hash[])
    {
        if (hash == null)
        {
            return null;
        }
        StringBuffer buf = new StringBuffer(hash.length * 2);
        int i;

        for (i = 0; i < hash.length; i++)
        {
            if ((hash[i] & 0xff) < 0x10)
            {
                buf.append("0");
            }
            buf.append(Long.toString(hash[i] & 0xff, 16));
        }
        return buf.toString();
    }

    public static String hash(String s)
    {
        try
        {
            return new String(toHex(md5(s)).getBytes("UTF-8"), "UTF-8");
        }
        catch (Exception e)
        {
            log.error("not supported charset...{}", e);
            return s;
        }
    }

    /**
     * MD5加密
     **/
    public static String getSignatureByMD5(String originString) {
        if (originString != null) {
            try {
                // 创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                // 将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toUpperCase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public static String getSignatureByMD5Low(String originString) {
        if (originString != null) {
            try {
                // 创建具有指定算法名称的信息摘要
                MessageDigest md = MessageDigest.getInstance("MD5");
                // 使用指定的字节数组对摘要进行最后更新，然后完成摘要计算
                byte[] results = md.digest(originString.getBytes());
                // 将得到的字节数组变成字符串返回
                String resultString = byteArrayToHexString(results);
                return resultString.toLowerCase();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 字符串 SHA 加密
     *
     * @param strSourceText
     * @return
     */
    public static String SHA(final String strText, final String strType) {
        // 返回值
        String strResult = null;

        // 是否是有效字符串
        if (strText != null && strText.length() > 0) {
            try {
                // SHA 加密开始
                // 创建加密对象 并传入加密类型
                MessageDigest messageDigest = MessageDigest.getInstance(strType);
                // 传入要加密的字符串
                messageDigest.update(strText.getBytes());
                // 得到 byte 类型结果
                byte byteBuffer[] = messageDigest.digest();

                // 將 byte 转换为 string
                StringBuffer strHexString = new StringBuffer();
                // 遍历 byte buffer
                for (int i = 0; i < byteBuffer.length; i++) {
                    String hex = Integer.toHexString(0xff & byteBuffer[i]);
                    if (hex.length() == 1) {
                        strHexString.append('0');
                    }
                    strHexString.append(hex);
                }
                // 得到返回結果
                strResult = strHexString.toString();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }

        return strResult;
    }

    /**
     * Aes128 加密
     * @param src
     * @param key
     * @param iv
     * @return
     * @throws Exception
     */
    public static String encrypt( String src, String key, String iv ) throws Exception {
        if( key == null || key.length( ) != 16 ) {
            throw new InvalidKeyException( "key is wrong" );
        }
        if( iv == null || iv.length( ) != 16 ) {
            throw new InvalidAlgorithmParameterException( "iv  is wrong" );
        }
        SecretKeySpec sKeySpec = new SecretKeySpec( key.getBytes( "UTF-8" ), "AES" );
        Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
        IvParameterSpec ivSpec = new IvParameterSpec( iv.getBytes( "UTF-8" ) );
        cipher.init( Cipher.ENCRYPT_MODE, sKeySpec, ivSpec );
        return org.apache.commons.codec.binary.Base64.encodeBase64String( cipher.doFinal( src.getBytes( "UTF-8" ) ) );
    }

    /**
     * aes128解密
     * @param src
     * @param key
     * @param iv
     * @return
     * @throws Exception
     */
    public static String decrypt( String src, String key, String iv ) throws Exception {
        if( key == null || key.length( ) != 16 ) {
            throw new InvalidKeyException( "key is wrong" );
        }
        if( iv == null || iv.length( ) != 16 ) {
            throw new InvalidAlgorithmParameterException( "iv  is wrong" );
        }
        SecretKeySpec sKeySpec = new SecretKeySpec( key.getBytes( "UTF-8" ), "AES" );
        Cipher cipher = Cipher.getInstance( "AES/CBC/PKCS5Padding" );
        IvParameterSpec ivSpec = new IvParameterSpec( iv.getBytes( "UTF-8" ) );
        cipher.init( Cipher.DECRYPT_MODE, sKeySpec, ivSpec );
        byte[] content = cipher.doFinal( Base64.decodeBase64( src.getBytes( "UTF-8" ) ) );
        return new String( content );
    }

    /**
     * 转换字节数组为十六进制字符串
     *
     * @param 字节数组
     * @return 十六进制字符串
     */
    private static String byteArrayToHexString(byte[] b) {
        StringBuffer resultSb = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            resultSb.append(byteToHexString(b[i]));
        }
        return resultSb.toString();
    }

    /** 将一个字节转化成十六进制形式的字符串 */
    private static String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }

    // 十六进制下数字到字符的映射数组
    private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d",
            "e", "f" };

    public static void main(String[] args) {
        try {
            String pwd = Md5Utils.encrypt("123456!@#","1234123412ABCDEF","1234123412ABCDEF");
            System.out.println(pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
