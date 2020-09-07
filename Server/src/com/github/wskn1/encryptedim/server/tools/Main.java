package org.wsk.crypto.encrypt;


import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
//        new Main().go();
        CipherHelper c = new CipherHelper("12345" , "12345");
        SecretKeys key = c.getKeys();
        System.out.println("RSA公钥：" + key.getRSA_Public_Key());
        System.out.println("RSA私钥：" + key.getRSA_Private_Key());
        System.out.println("AES秘钥：" + key.getAES_Key());
    }

    public void go() throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println("请选择模式：1：读取已有秘钥 2：创建新的秘钥");
        int i = s.nextInt();
        String aes = null;
        String rsapu = null;
        String rsapr = null;
        if(i == 1){
            System.out.println("请输入秘钥路径：");
            String s1 = s.next();
            File f = new File(s1);
            ObjectInputStream ois = new ObjectInputStream (new FileInputStream(f));
            SecretKeys keys = (SecretKeys)ois.readObject();
            CipherHelper c = new CipherHelper(keys);
            for(;;){
                System.out.println("开始加密&解密，输入stop结束，输入en来进行加密，输入de来进行解密");
                s1 = s.next();
                if(s1.equals("en")){
                    System.out.println("请输入明文：");
                    s1 = s.next();
                    System.out.println(c.AES_encrypt(s1));
                }else if(s1.equals("de")){
                    System.out.println("请输入密文：");
                    s1 = s.next();
                    System.out.println(c.AES_decrypt(s1));
                }else{
                    break;
                }
            }
        }else{
            System.out.println("请选择身份：1：AES秘钥产生者 2：RSA秘钥对产生者");
            i = s.nextInt();
            if(i == 1){
                System.out.println("请输入秘钥种子：");
                String s2 = s.next();
                System.out.println("请输入RSA公钥：");
                String s3 = s.next();
                aes = AESUtil.getStrKeyAES(s2);
                SecretKeys key = new SecretKeys(s3 , "" , "");
                CipherHelper c = new CipherHelper(key);
                System.out.println(c.RSA_encrypt_public(aes));
            }else{
                System.out.println("请输入秘钥种子：");
                String s2 = s.next();
                Map<String , Object> kp = RSAUtil.genKeyPair(s2);
                rsapu = RSAUtil.getPublicKey(kp);
                rsapr = RSAUtil.getPrivateKey(kp);
                System.out.println(rsapu);
                System.out.println("请输入AES秘钥：");
                aes = s.next();
            }
            SecretKeys key = new SecretKeys(rsapu , rsapr , aes);
            System.out.println("请输入保存路径：");
            String path = s.next();
            File f = new File(path);
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
            oos.writeObject(key);
            for(;;){
                System.out.println("开始加密&解密，输入stop结束，输入en来进行加密，输入de来进行解密");
                String s1 = s.next();
                CipherHelper c = new CipherHelper(key);
                if(s1.equals("en")){
                    System.out.println("请输入明文：");
                    s1 = s.next();
                    System.out.println(c.AES_encrypt(s1));
                }else if(s1.equals("de")){
                    System.out.println("请输入密文：");
                    s1 = s.next();
                    System.out.println(c.AES_decrypt(s1));
                }else{
                    break;
                }
            }
        }
    }
}
