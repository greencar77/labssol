package resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceholderMain {
    public static void main(String[] args) {
        get();
//        post();
    }

    private static void get() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://jsonplaceholder.typicode.com/posts/1";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody());
    }

    private static void post() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://jsonplaceholder.typicode.com/posts";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> payload = new HashMap<>();
        payload.put("title", "foo");
        payload.put("body", "bar");
        payload.put("userId", 1);

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(payload, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(url, request, String.class);

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Response: " + response.getBody());
    }
}
