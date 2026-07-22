package httpjson.helper;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SuppressWarnings("unused")
public class RestTemplateHttpUtils {

    private static final String DEFAULT_HOST = "http://localhost:8080";

    private static final RestTemplate REST = new RestTemplate();

    public static String sendGet(String url) {
        if (!url.startsWith("http")) {
            url = DEFAULT_HOST + url;
        }
        System.out.println("Endpoint: " + url);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        ResponseEntity<String> response = REST.getForEntity(url, String.class, headers);

        System.out.println("GET response:");
        System.out.println("Status code:" + response.getStatusCode());
        System.out.println(response.getBody());
        return response.getBody();
    }

    public static String sendPost(String url, String jsonBody) {
        if (!url.startsWith("http")) {
            url = DEFAULT_HOST + url;
        }
        System.out.println("Endpoint: " + url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(jsonBody, headers);

        ResponseEntity<String> response = REST.postForEntity(url, request, String.class, headers);

        System.out.println("POST response:");
        System.out.println("Status code:" + response.getStatusCode());
        System.out.println(response.getBody());
        return response.getBody();
    }

    public static String sendPut(String url) {
        if (!url.startsWith("http")) {
            url = DEFAULT_HOST + url;
        }
        System.out.println("Endpoint: " + url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = REST.exchange(url, HttpMethod.PUT, request, String.class, headers);

        System.out.println("PUT response:");
        System.out.println("Status code:" + response.getStatusCode());
        System.out.println(response.getBody());
        return response.getBody();
    }

    public static String sendDelete(String url) {
        if (!url.startsWith("http")) {
            url = DEFAULT_HOST + url;
        }
        System.out.println("Endpoint: " + url);

        ResponseEntity<String> response = REST.exchange(url, HttpMethod.DELETE, null, String.class);

        System.out.println("DELETE response:");
        System.out.println("Status code:" + response.getStatusCode());
        System.out.println(response.getBody());
        return response.getBody();
    }
}
