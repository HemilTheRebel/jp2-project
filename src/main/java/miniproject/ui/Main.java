package miniproject.ui;

import miniproject.ciphers.CaesarCipher;
import miniproject.ciphers.Cipher;
import miniproject.ciphers.SimpleColumnarCipher;
import miniproject.ciphers.VigenereCipher;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public Main(List<Cipher> ciphers) {
        JFrame frame = new JFrame("Mini project - Ciphers");

        AtomicReference<Cipher> cipher = new AtomicReference<>();

        JPanel cipherRadioButtons = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();

        for (final Cipher c : ciphers) {
            JRadioButton radioButton = new JRadioButton(c.name());
            radioButton.addActionListener(a -> cipher.set(c));
            cipherRadioButtons.add(radioButton);
            buttonGroup.add(radioButton);
        }

        frame.add(cipherRadioButtons);

        JTextArea plainText = new JTextArea(3, 30);
        plainText.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel encryptionPane = new JPanel();
        encryptionPane.add(new JLabel("Plain Text:  "));
        encryptionPane.add(plainText);

        frame.add(encryptionPane);

        JTextField key = new JTextField(30);
        key.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel keyPane = new JPanel();
        keyPane.add(new JLabel("Key: "));
        keyPane.add(key);

        frame.add(keyPane);

        JTextArea cipherText = new JTextArea(3, 30);
        cipherText.setBorder(BorderFactory.createLineBorder(Color.black));
        JPanel decryptionPane = new JPanel();
        decryptionPane.add(new JLabel("Cipher Text: "));
        decryptionPane.add(cipherText);

        frame.add(decryptionPane);

        JPanel buttons = new JPanel();

        JButton encrypt = new JButton("Encrypt");
        encrypt.addActionListener(a -> {
            if (cipher.get() == null) {
                JOptionPane.showMessageDialog(frame, "Please select a cipher first");
                return;
            }

            if (plainText.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Plain text cannot be empty");
                return;
            }

            if (key.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Key cannot be empty");
                return;
            }

            try {
                cipherText.setText(cipher.get().encrypt(plainText.getText(), key.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Invalid key or plain text");
            }
        });
        buttons.add(encrypt);

        JButton decrypt = new JButton("Decrypt");
        decrypt.addActionListener(a -> {
            if (cipher.get() == null) {
                JOptionPane.showMessageDialog(frame, "Please select a cipher first");
                return;
            }

            if (cipherText.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Cipher text cannot be empty");
                return;
            }

            if (key.getText().equals("")) {
                JOptionPane.showMessageDialog(frame, "Key cannot be empty");
                return;
            }

            try {
                plainText.setText(cipher.get().decrypt(cipherText.getText(), key.getText()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(frame, "Invalid key or plain text");
            }
        });
        buttons.add(decrypt);

        frame.add(buttons);

        BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        frame.setLayout(layout);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        List<Cipher> ciphers = new ArrayList<>();
        ciphers.add(new CaesarCipher());
        ciphers.add(new SimpleColumnarCipher());
        ciphers.add(new VigenereCipher());
        new Main(ciphers);
    }
}
