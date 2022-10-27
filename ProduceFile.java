// This is a singleton class so that only one instance of this class is ever created and is in use
// if another is attempted it will overwrite the first instance

public class ProduceFile {

    // This will create an instance of itself
    private static ProduceFile instance = new ProduceFile();
    private String password;

    private ProduceFile() {
    }

    // It will return the created instance to the user
    public static ProduceFile getInstance() {
        return instance;
    }

    // Returns the generated password as a stirng
    public String getEncryption() {
        return password;
    }
}