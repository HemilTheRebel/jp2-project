package miniproject;

import miniproject.ciphers.VigenereCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VigenereCipherTest {
    @Test
    public void encryptTest() {
        assertEquals(
                "qicowa uacg iddhb upbh",
                new VigenereCipher().encrypt("attack from south east", "point")
        );
    }

    @Test
    public void decryptTest() {
        assertEquals(
                "attack from south east",
                new VigenereCipher().decrypt("qicowa uacg iddhb upbh", "point")
        );
    }

    @Test
    public void all_alphabets() {
        final String text = "the quick brown fox jumps over the lazy dog";
        VigenereCipher cipher = new VigenereCipher();
        final String cipherText = cipher.encrypt(text, "point");
        assertEquals(
                text,
                cipher.decrypt(cipherText, "point")
        );
    }
}