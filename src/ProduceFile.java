package src;
// This is a singleton class so that only one instance of this class is ever created and is in use

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

// if another is attempted it will overwrite the first instance

public class ProduceFile {

    // This will create an instance of itself
    private static ProduceFile instance = new ProduceFile();
    private String password, apiCall;
    HttpResponse<String> getResponse;

    private ProduceFile() {

    }

    // It will return the created instance to the user
    public static ProduceFile getInstance() {
        return instance;
    }

    // This will create the call to the api thats requested and save the result
    public void sendCall(String apiCall) throws URISyntaxException, IOException, InterruptedException {
        HttpRequest getRequest = HttpRequest.newBuilder()
                .uri(new URI(apiCall))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        this.getResponse = httpClient.send(getRequest, BodyHandlers.ofString());
    }

    public HttpResponse<String> getJson() {
        return this.getResponse;
    }

    // Returns the generated password as a stirng
    public String getEncryption() {
        return password;
    }
}