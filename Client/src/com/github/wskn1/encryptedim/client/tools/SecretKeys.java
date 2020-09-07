package com.github.wskn1.encryptedim.client.tools;

import java.io.Serializable;

public class SecretKeys implements Serializable {
    private String RSA_Public_Key;
    private String RSA_Private_Key;
    private String AES_Key;

    public SecretKeys(String RSA_Public_Key, String RSA_Private_Key, String AES_Key) {
        this.RSA_Public_Key = RSA_Public_Key;
        this.RSA_Private_Key = RSA_Private_Key;
        this.AES_Key = AES_Key;
    }

    public SecretKeys(String RSA_Public_Key, String AES_Key) {
        this.RSA_Public_Key = RSA_Public_Key;
        this.AES_Key = AES_Key;
    }

    public String getRSA_Public_Key() {
        return RSA_Public_Key;
    }

    public void setRSA_Public_Key(String RSA_Public_Key) {
        this.RSA_Public_Key = RSA_Public_Key;
    }

    public String getRSA_Private_Key() {
        return RSA_Private_Key;
    }

    public void setRSA_Private_Key(String RSA_Private_Key) {
        this.RSA_Private_Key = RSA_Private_Key;
    }

    public String getAES_Key() {
        return AES_Key;
    }

    public void setAES_Key(String AES_Key) {
        this.AES_Key = AES_Key;
    }

}
