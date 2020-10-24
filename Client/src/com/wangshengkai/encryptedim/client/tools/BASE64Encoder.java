package com.wangshengkai.encryptedim.client.tools;

import java.util.Base64;

public class BASE64Encoder {
    public String encode(byte[] bytes){
        return new String(Base64.getEncoder().encode(bytes));
    }
}
