package com.wangshengkai.encryptedim.client.tools;

import java.util.Base64;

public class BASE64Decoder {
    public byte[] decodeBuffer(String str){
        return Base64.getDecoder().decode(str);
    }
}
