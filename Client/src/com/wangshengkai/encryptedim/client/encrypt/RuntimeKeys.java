package com.wangshengkai.encryptedim.client.encrypt;

import com.wangshengkai.encryptedim.client.tools.CipherHelper;
import com.wangshengkai.encryptedim.client.tools.SecretKeys;

public class RuntimeKeys {
    private static SecretKeys serverSecretKeys;
    private static CipherHelper serverCipher;
    private static SecretKeys clientSecretKeys;
    private static CipherHelper clientCipher;

    public static SecretKeys getServerSecretKeys() {
        return serverSecretKeys;
    }

    protected void setSecretKeys(SecretKeys secretKeys) {
        RuntimeKeys.serverSecretKeys = secretKeys;
        serverCipher = new CipherHelper(secretKeys);
    }

    public static CipherHelper getServerCipher() {
        return serverCipher;
    }

    public static SecretKeys getClientSecretKeys() {
        return clientSecretKeys;
    }

    protected static void setClientSecretKeys(SecretKeys clientSecretKeys) {
        RuntimeKeys.clientSecretKeys = clientSecretKeys;
    }

    public static CipherHelper getClientCipher() {
        return clientCipher;
    }
}
