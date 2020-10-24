package com.wangshengkai.encryptedim.client.message;

public enum Action {
    CONNECT,
    DISCONNECT,
    SEND_CLIENT_AES_KEY,
    SEND_CLIENT_RSA_PUBLIC_KEY,
    SEND_MESSAGE,
    STATUS,
    VERIFI_SERVER_INFO
}
