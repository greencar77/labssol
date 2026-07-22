package httpjson;

import httpjson.helper.DynamicCaller;

import static httpjson.helper.RestTemplateHttpUtils.sendGet;
import static httpjson.helper.RestTemplateHttpUtils.sendPost;

@SuppressWarnings("unused")
public class RestTemplateCaller {

    public static void main(String[] args) {
        DynamicCaller.executeDynamically(RestTemplateCaller.class);
    }

    private static void doGet() {
        sendGet("/api/message");
    }

    private static void doNPE() {
        sendGet("/api/negative");
    }

    private static void doPost() {
        String json = """
                {"text":"New value"}
                """;
        sendPost("/api/message", json);
    }
}
