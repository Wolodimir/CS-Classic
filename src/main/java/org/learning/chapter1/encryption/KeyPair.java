package org.learning.chapter1.encryption;

public final class KeyPair {

    public final byte[] key1;
    public final byte[] key2;

    KeyPair(byte[] key1, byte[] key2) {
        this.key1 = key1;
        this.key2 = key2;
    }
}
