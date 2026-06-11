package httpjson;

import httpjson.helper.DynamicCaller;

import static httpjson.helper.HttpUtils.sendGet;
import static httpjson.helper.HttpUtils.sendPost;

public class Caller {

    public static void main(String[] args) {
        DynamicCaller.executeDynamically(Caller.class);
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
