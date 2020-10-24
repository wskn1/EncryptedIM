package com.wangshengkai.encryptedim.client.message;

import com.wangshengkai.encryptedim.client.statics.ClientStatics;

import java.util.ArrayList;

public class MessageFactory {

    public Message getMessage(Action action , ArrayList<String> contant){
        Message message = new Message();
        message.action = action;
        message.content = contant;
        message.ClientUUID = ClientStatics.getCilentUUID();
        return message;
    }

}
