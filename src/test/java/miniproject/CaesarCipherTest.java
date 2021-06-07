package miniproject;

import miniproject.ciphers.CaesarCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarCipherTest {
    @Test
    public void test_encrypt_hello_world_with_key_3_returns_khoor_zruog() {
        assertEquals("khoor zruog", new CaesarCipher().encrypt("hello world", "3"));
    }

    @Test
    public void test_decrypt_khoor_zruog_with_key_negative_3_returns_hello_world() {
        assertEquals("hello world", new CaesarCipher().decrypt("khoor zruog", "3"));
    }

    @Test
    public void all_alphabets() {
        final String text = "the quick brown fox jumps over the lazy dog";
        CaesarCipher cipher = new CaesarCipher();
        final String cipherText = cipher.encrypt(text, "3");
        assertEquals(
                text,
                cipher.decrypt(cipherText, "3")
        );
    }
}