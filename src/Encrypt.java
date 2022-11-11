package src;
// This is a singleton class so that only one instance of this class is ever created and is in use

import java.nio.charset.Charset;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

// If another is attempted it will overwrite the first instance

public class Encrypt {

    // This will create an instance of itself
    private static Encrypt instance = new Encrypt();
    private String source, password, response;
    private IvParameterSpec ivParameterSpec;

    private Encrypt() {

    }

    private void savePassword(String pwd) {
        this.password = pwd;
    }

    private void saveSource(String src) {
        this.source = src;
    }

    private void generatePassword() {
        byte[] array = new byte[15];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));

        this.password = generatedString;
    }

    // It will return the created instance to the user
    public static Encrypt getInstance() {
        return instance;
    }

    // This will encrypt the source using the given password
    public String encrypt(String source, String password)
            throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
            InvalidKeySpecException {
        saveSource(source);
        savePassword(password);

        String salt = "Salt";

        SecretKey key = AES.getKeyFromPassword(password, salt);
        this.ivParameterSpec = AES.generateIv();

        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = AES.encrypt(algorithm, source, key, ivParameterSpec);
        return cipherText;
    }

    // This method can encrypt the source and generate a password
    public String encrypt(String source) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
            InvalidKeySpecException {
        saveSource(source);
        generatePassword();

        String salt = "Salt";

        SecretKey key = AES.getKeyFromPassword(this.password, salt);
        this.ivParameterSpec = AES.generateIv();

        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = AES.encrypt(algorithm, source, key, this.ivParameterSpec);
        return cipherText;
    }

    public String decrypt(String source, String password)
            throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException,
            InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException,
            InvalidKeySpecException {

        String salt = "Salt";

        SecretKey key = AES.getKeyFromPassword(password, salt);
        String algorithm = "AES/CBC/PKCS5Padding";
        String plainText = AES.decrypt(algorithm, source, key, this.ivParameterSpec);
        return plainText;
    }

    // Returns the response in string format
    public String getResponse() {
        return this.response;
    }

    // Returns the Source that is stored
    public String getSource() {
        return this.source;
    }

    // Returns the password that is stored
    public String getPassword() {
        return this.password;
    }

    public IvParameterSpec getIvParameterSpec() {
        return this.ivParameterSpec;
    }
}