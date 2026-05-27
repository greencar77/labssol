package com.example.demo;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Caller {

    private static final String HOST = "http://localhost:8080";

    private static final HttpClient CLIENT = HttpClient.newHttpClient();

    public static void main(String[] args) throws Exception {
//        post();
//        get();
        delete();
    }

    private static void get() throws Exception {
        String getResponse = sendGet(HOST + "/api/customers/1/orders");
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
                {
                                      "customerName": "John Smith",
                                      "customerEmail": "john@example.com",
                                      "productName": "Laptop",
                                      "amount": 999.99
                                    }
                """;
        String postResponse = sendPost(HOST + "/api/create", json);
        System.out.println("\nPOST response:");
        System.out.println(postResponse);
    }

    private static String sendPost(String url, String jsonBody) throws IOException, InterruptedException {

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

    private static void delete() throws Exception {
        String id = "1";
        String postResponse = sendDelete(HOST + "/api/orders" + "/"  +id);
        System.out.println("\nDelete response:");
        System.out.println(postResponse);
    }

    private static String sendDelete(String url) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();

        HttpResponse<String> response = CLIENT.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();
    }
}
