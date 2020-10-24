package com.wangshengkai.encryptedim.client.statics;

public class ClientStatics {
    private static String cilentUUID;

    public static String getCilentUUID() {
        return cilentUUID;
    }

    public static void setCilentUUID(String cilentUUID) {
        ClientStatics.cilentUUID = cilentUUID;
    }
}
