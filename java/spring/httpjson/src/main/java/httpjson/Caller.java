package httpjson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Caller {

    private static final String HOST = "http://localhost:8080";

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
        get();
//        post();
    }

    private static void get() throws Exception {
        String getResponse = sendGet(HOST + "/api/message");
        System.out.println("GET response:");
        System.out.println(getResponse);
    }

    private static String sendGet(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }

    private static void post() throws Exception {
        String json = """
                {"text":"New value"}
                """;
        String postResponse = sendPost(HOST + "/api/message", json);
        System.out.println("\nPOST response:");
        System.out.println(postResponse);
    }

    public static String sendPost(String url, String jsonBody) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }
}
