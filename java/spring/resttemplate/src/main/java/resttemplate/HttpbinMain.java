package resttemplate;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class HttpbinMain {
    public static void main(String[] args) {
        get();
    }

    private static void get() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://httpbin.org/get";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody());
    }

    private static void post() {
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://httpbin.org/post";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", "John");
        requestBody.put("age", 30);

        HttpEntity<Map<String, Object>> request = new HttpEntity<>(requestBody, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(url, request, String.class);

        System.out.println("Status: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody());
    }
}
