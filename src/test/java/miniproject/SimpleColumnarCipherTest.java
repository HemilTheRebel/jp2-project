package miniproject;

import miniproject.ciphers.SimpleColumnarCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleColumnarCipherTest {
    @Test
    void encrypt() {
        assertEquals(
                "gntsenao u ltvlseiehedt nv eai ec",
                new SimpleColumnarCipher().encrypt("golden statue is in eleventh cave", "5")
        );
    }

    @Test
    void decrypt() {
        assertEquals(
                "golden statue is in eleventh cave",
                new SimpleColumnarCipher().decrypt("gntsenao u ltvlseiehedt nv eai ec" , "5")
        );
    }

    @Test
    void allAlphabets() {
        final String text = "the quick brown fox jumps over the lazy dog";
        SimpleColumnarCipher cipher = new SimpleColumnarCipher();
        final String cipherText = cipher.encrypt(text, "3");
        assertEquals(
                text,
                cipher.decrypt(cipherText, "3")
        );
    }
}