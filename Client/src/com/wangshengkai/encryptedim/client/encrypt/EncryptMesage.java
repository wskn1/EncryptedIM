package com.wangshengkai.encryptedim.client.encrypt;

import com.google.gson.Gson;
import com.wangshengkai.encryptedim.client.message.Action;
import com.wangshengkai.encryptedim.client.tools.CipherHelper;

import java.util.ArrayList;

public class EncryptMesage {
    private String encryptedMessage;
    private String sign;
    public EncryptMesage(Action action , String ClientUUID , ArrayList<String> content) throws Exception {
        CipherHelper serverCipher = RuntimeKeys.getServerCipher();
        CipherHelper clientCipher = RuntimeKeys.getClientCipher();
        MessageNoSign message = new MessageNoSign();
        message.content = content;
        message.action = action;
        message.ClientUUID = ClientUUID;
        encryptedMessage = serverCipher.RSA_encrypt_public(new Gson().toJson(message));
        sign = clientCipher.sign_with_RSA_private(encryptedMessage);
    }

    public String getEncryptedMessage() {
        return encryptedMessage;
    }

    public String getSign() {
        return sign;
    }
}
