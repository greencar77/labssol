package httpjson.helper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtils {

    private static final String DEFAULT_HOST = "http://localhost:8080";

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static String sendGet(String url) {
        if (!url.startsWith("http")) {
            url = DEFAULT_HOST + url;
        }
        System.out.println("Endpoint: " + url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Accept", "application/json")
                .GET()
                .build();

        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("GET response:");
        System.out.println("Status code:" + response.statusCode());
        System.out.println(response.body());
        return response.body();
    }

    public static String sendPost(String url, String jsonBody) {
        if (!url.startsWith("http")) {
            url = DEFAULT_HOST + url;
        }
        System.out.println("Endpoint: " + url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                .build();

        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("POST response:");
        System.out.println("Status code:" + response.statusCode());
        System.out.println(response.body());
        return response.body();
    }

    public static String sendPut(String url) {
        if (!url.startsWith("http")) {
            url = DEFAULT_HOST + url;
        }
        System.out.println("Endpoint: " + url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.noBody())
                .build();

        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("PUT response:");
        System.out.println("Status code:" + response.statusCode());
        System.out.println(response.body());
        return response.body();
    }

    public static String sendDelete(String url) {
        if (!url.startsWith("http")) {
            url = DEFAULT_HOST + url;
        }
        System.out.println("Endpoint: " + url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response;
        try {
            response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("DELETE response:");
        System.out.println("Status code:" + response.statusCode());
        System.out.println(response.body());
        return response.body();
    }
}
