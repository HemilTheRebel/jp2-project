package miniproject.ciphers;

public interface Cipher {
    String name();
    String keyHint();
    String encrypt(String plainText, String key);
    String decrypt(String cipherText, String key);
}
