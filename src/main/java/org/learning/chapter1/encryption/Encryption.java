package org.learning.chapter1.encryption;

import java.util.Random;

public final class Encryption {

    public static void main(String[] args) {
        KeyPair kp = encrypt("Some string for to encryption");
        String result = decrypt(kp);
        System.out.println(result);
    }

    // generate 'length' random bites
    private static byte[] randomKey(int length) {
        byte[] dummy = new byte[length];
        Random random = new Random();
        random.nextBytes(dummy);
        return dummy;
    }

    public static KeyPair encrypt(String original) {
        byte[] originalBytes = original.getBytes();
        byte[] dummyKey = randomKey(originalBytes.length);
        byte[] encryptedKey = new byte[originalBytes.length];
        for (int i = 0; i < originalBytes.length; i++) {
            // XOR operation
            encryptedKey[i] = (byte) (originalBytes[i] ^ dummyKey[i]);
        }
        return new KeyPair(dummyKey, encryptedKey);
    }

    public static String decrypt(KeyPair kp) {
        byte[] decrypted = new byte[kp.key1.length];
        for (int i = 0; i < kp.key1.length; i++) {
            decrypted[i] = (byte) (kp.key1[i] ^ kp.key2[i]);
        }
        return new String(decrypted);
    }
}
