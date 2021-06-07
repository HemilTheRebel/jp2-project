package miniproject.ciphers;

public class VigenereCipher implements Cipher {
    @Override
    public String name() {
        return "Vigenere Cipher";
    }

    @Override
    public String keyHint() {
        return "Key";
    }

    @Override
    public String encrypt(String plainText, String key) {
        key = key.toLowerCase();
        plainText = plainText.toLowerCase();

        StringBuilder builder = new StringBuilder();
        for (int plainTextIndex = 0, keyIndex = 0; plainTextIndex < plainText.length(); plainTextIndex++) {
            final char ch = plainText.charAt(plainTextIndex);
            final int increment = key.charAt(keyIndex % key.length()) - 'a' + 1;

            if (Character.isSpaceChar(ch)) {
                /// If the character is a space, we wont use up the key index
                builder.append(ch);
            } else {
                builder.append((char)(('a' + (ch - 'a' + increment) % 26)));
                /// If the character is not a space, we will use up the key index
                keyIndex++;
            }
        }

        return builder.toString();
    }

    @Override
    public String decrypt(String cipherText, String key) {
        key = key.toLowerCase();
        cipherText = cipherText.toLowerCase();

        StringBuilder builder = new StringBuilder();
        for (int ciperIndex = 0, keyIndex = 0; ciperIndex < cipherText.length(); ciperIndex++) {
            final char ch = cipherText.charAt(ciperIndex);
            final int decrement = key.charAt(keyIndex % key.length()) - 'a' + 1;

            if (Character.isSpaceChar(ch)) {
                /// If the character is a space, we wont use up the key index
                builder.append(ch);
            } else {
                if (ch - decrement >= 'a') {
                    builder.append((char)(('a' + (ch - 'a' - decrement) % 26)));
                } else {
                    builder.append((char)('z' + (ch - 'a' - decrement + 1)));
                }
                /// If the character is not a space, we will use up the key index
                keyIndex++;
            }
        }

        return builder.toString();
    }
}
