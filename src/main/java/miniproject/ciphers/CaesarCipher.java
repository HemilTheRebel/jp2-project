package miniproject.ciphers;

public class CaesarCipher implements Cipher {
    @Override
    public String name() {
        return "Caesar Cipher";
    }

    @Override
    public String keyHint() {
        return "Alphabets to shift";
    }

    @Override
    public String encrypt(String plainText, String key) {
        key = key.toLowerCase();
        plainText = plainText.toLowerCase();

        int keyInt = Integer.parseInt(key);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            final char ch = plainText.charAt(i);
            if (Character.isSpaceChar(ch)) {
                builder.append(ch);
            } else {
                builder.append((char)(ch + keyInt));
            }
        }

        return builder.toString();
    }

    @Override
    public String decrypt(String cipherText, String key) {
        key = key.toLowerCase();
        cipherText = cipherText.toLowerCase();

        int keyInt = Integer.parseInt(key);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < cipherText.length(); i++) {
            final char ch = cipherText.charAt(i);
            if (Character.isSpaceChar(ch)) {
                builder.append(ch);
            } else {
                builder.append((char)(ch - keyInt));
            }
        }

        return builder.toString();
    }
}
