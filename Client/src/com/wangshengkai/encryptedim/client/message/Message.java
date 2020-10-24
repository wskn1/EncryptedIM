package com.wangshengkai.encryptedim.client.message;

import com.google.gson.Gson;
import com.wangshengkai.encryptedim.client.encrypt.EncryptMesage;

import java.util.ArrayList;

public class Message {
    protected Action action;
    protected String ClientUUID;
    protected ArrayList<String> content;
    protected String sign;
    protected Message() {

    }

    @Override
    public String toString() {
        Gson gson = new Gson();
        EncryptMesage mesage = null;
        try {
            mesage = new EncryptMesage(action , ClientUUID , content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gson.toJson(mesage);
    }
}
