package src;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

// This is a child of Encryption class 

public class AES extends Encryption {

    // Overwrites the Encrypt class to implement the encryption of AES

    static byte[] cipherText;
    static byte[] plainText;

    public static String encrypt(String algorithm, String input, SecretKey key,
            IvParameterSpec iv) {

        Cipher cipher;
        try {
            cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, key, iv);
            cipherText = cipher.doFinal(input.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Base64.getEncoder()
                .encodeToString(cipherText);
    }

    // Overwrites the Decrypt class to implement the encryption of AES

    public static String decrypt(String algorithm, String cipherText, SecretKey key,
            IvParameterSpec iv) {

        Cipher cipher;
        try {
            cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, key, iv);
            plainText = cipher.doFinal(Base64.getDecoder()
                    .decode(cipherText));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new String(plainText);
    }
}
