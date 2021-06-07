package miniproject.ciphers;

public class SimpleColumnarCipher implements Cipher {
    @Override
    public String name() {
        return "Simple Columnar Cipher";
    }

    @Override
    public String keyHint() {
        return "Number of columns";
    }

    @Override
    public String encrypt(String plainText, String key) {
        key = key.toLowerCase();
        plainText = plainText.toLowerCase();

        int keyInt = Integer.parseInt(key);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < keyInt; i++) {
            for (int j = i; j < plainText.length(); j += keyInt) {
                builder.append(plainText.charAt(j));
            }
        }

        return builder.toString();
    }

    @Override
    public String decrypt(String cipherText, String key) {
        key = key.toLowerCase();
        cipherText = cipherText.toLowerCase();

        int keyInt = Integer.parseInt(key);

        StringBuilder builder = new StringBuilder(new String(new char[cipherText.length()]));
        for (int i = 0, j = i; i < keyInt; i++) {
            for (int k = i; k < cipherText.length(); j++, k += keyInt) {
                builder.setCharAt(k, cipherText.charAt(j));
            }
        }

        return builder.toString();
    }
}
