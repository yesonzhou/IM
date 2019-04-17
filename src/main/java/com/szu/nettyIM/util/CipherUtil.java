package com.szu.nettyIM.util;

import com.sun.org.apache.xerces.internal.impl.dv.util.HexBin;

import javax.crypto.Cipher;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

/**
 * Created by Richard.Fu on 2019/4/15
 */
public class CipherUtil {

    private static final String ALGORITHM_RSA = "RSA";
    private static final String ALGORITHM_MD5 = "MD5";
    private static final int KEY_SIZE = 512;

    public static RSAKeyPair generateRSAKeyPair() {
        try {
            //RSA密钥生成
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(ALGORITHM_RSA);
            keyPairGenerator.initialize(KEY_SIZE);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) keyPair.getPrivate();
            RSAPublicKey rsaPublicKey = (RSAPublicKey) keyPair.getPublic();
            //base64编码
            String base64PrivateKey = Base64.getEncoder().encodeToString(rsaPrivateKey.getEncoded());
            String base64PublicKey = Base64.getEncoder().encodeToString(rsaPublicKey.getEncoded());
            return new RSAKeyPair(base64PrivateKey, base64PublicKey);
        } catch (NoSuchAlgorithmException e) {
            //异常处理
            e.printStackTrace();
            return new RSAKeyPair("", "");
        }
    }

    /**
     * @param publicKeyBase64 经过base64编码的密钥
     * @see #encryptPublicKey(String, String)
     */
    public static String encryptPublicKey(String publicKeyBase64, String plaintext) {
        if (TextUtils.isEmpty(publicKeyBase64) || TextUtils.isEmpty(plaintext))
            return "";
        return encryptPublicKey(Base64.getDecoder().decode(publicKeyBase64), plaintext);
    }

    /**
     * RSA公钥加密
     *
     * @param publicKeyByte 加密公钥
     * @param plaintext     明文
     * @return 经Base64编码的密文
     */
    public static String encryptPublicKey(byte[] publicKeyByte, String plaintext) {
        if (TextUtils.isEmpty(publicKeyByte) || TextUtils.isEmpty(plaintext))
            return "";

        try {
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicKeyByte);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] cipherText = cipher.doFinal(plaintext.getBytes());
            return Base64.getEncoder().encodeToString(cipherText);
        } catch (Exception e) {
            //todo:分异常处理
            e.printStackTrace();
            return "";
        }
    }


    /**
     * @param cipherTextBase64 经过base64编码的密钥
     * @see #decryptPrivateKey(String, String)
     */
    public static String decryptPrivateKey(String privateKeyBase64, String cipherTextBase64) {
        if (TextUtils.isEmpty(privateKeyBase64) || TextUtils.isEmpty(cipherTextBase64))
            return "";
        return decryptPrivateKey(Base64.getDecoder().decode(privateKeyBase64), cipherTextBase64);
    }

    /**
     * RSA私钥解密
     *
     * @param cipherTextBase64 密文
     * @param privateKeyByte   解密密钥
     * @return 明文
     */
    public static String decryptPrivateKey(byte[] privateKeyByte, String cipherTextBase64) {
        if (TextUtils.isEmpty(privateKeyByte) || TextUtils.isEmpty(cipherTextBase64))
            return "";

        try {
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateKeyByte);
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM_RSA);
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(ALGORITHM_RSA);
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] cipherText = Base64.getDecoder().decode(cipherTextBase64);
            byte[] plainText = cipher.doFinal(cipherText);
            return new String(plainText);
        } catch (Exception e) {
            //todo:分异常处理
            e.printStackTrace();
            return "";
        }
    }

    /**
     * md5算法
     *
     * @param plainText 明文
     * @return 经过Base64编码过的密文
     */
    public static String md5(String plainText) {
        if (TextUtils.isEmpty(plainText))
            return "";

        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_MD5);
            byte[] md5Bytes = md.digest(plainText.getBytes());
            String hexMD5 = HexBin.encode(md5Bytes);//要先转16进制，否则会有乱码
            return Base64.getEncoder().encodeToString(hexMD5.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static class RSAKeyPair {
        private String privateKeyBase64;
        private String publicKeyBase64;

        private RSAKeyPair(String privateKeyBase64, String publicKeyBase64) {
            this.privateKeyBase64 = privateKeyBase64;
            this.publicKeyBase64 = publicKeyBase64;
        }

        public String getPrivateKeyBase64() {
            return privateKeyBase64;
        }

        public String getPublicKeyBase64() {
            return publicKeyBase64;
        }

        public byte[] getPublcKey() {
            return Base64.getDecoder().decode(publicKeyBase64);
        }

        public byte[] getPrivateKey() {
            return Base64.getDecoder().decode(privateKeyBase64);
        }
    }

    public static void main(String[] args) {
        //todo:junit
        RSAKeyPair rsaKeyPair = generateRSAKeyPair();
        long startTime = System.currentTimeMillis();
        String src = "这是一段测试用的文字";
        String cipherText = encryptPublicKey(rsaKeyPair.getPublicKeyBase64(), src);
        String plainText = decryptPrivateKey(rsaKeyPair.getPrivateKeyBase64(), cipherText);
        long endTime = System.currentTimeMillis();
        System.out.println("spend time:" + (endTime - startTime));
        System.out.println("rsa cipherText:" + cipherText);
        System.out.println("rsa plainText:" + plainText);
        System.out.println("md5:" + md5(src));
    }
}
