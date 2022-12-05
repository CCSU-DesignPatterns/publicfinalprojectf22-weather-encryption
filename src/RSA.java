package src;

import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

public class RSA extends Encryption {

    public static String encrypt(String algorithm, String input, SecretKey key,
            IvParameterSpec iv) {
        return "";
    }

    public static String decrypt(String algorithm, String cipherText, SecretKey key,
            IvParameterSpec iv) {
        return "";
    }

}
