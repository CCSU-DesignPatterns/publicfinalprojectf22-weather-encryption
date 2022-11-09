package src;
// This is a singleton class so that only one instance of this class is ever created and is in use

// If another is attempted it will overwrite the first instance

public class Encrypt {

    // This will create an instance of itself
    private static Encrypt instance = new Encrypt();
    private String source, password, response;

    private Encrypt() {

    }

    private void savePassword(String x) {
        this.password = x;
    }

    private void saveSource(String x) {
        this.source = x;
    }

    private void generatePassword() {
        this.password = "Password";
    }

    // It will return the created instance to the user
    public static Encrypt getInstance() {
        return instance;
    }

    // This will encrypt the source using the given password
    public String encrypt(String source, String password) {
        saveSource(source);
        savePassword(password);

        // Do Encryption
        return "";
    }

    // This method can encrypt the source and generate a password
    public String encrypt(String source) {
        saveSource(source);
        generatePassword();

        // Do Encryption
        return "";
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
}