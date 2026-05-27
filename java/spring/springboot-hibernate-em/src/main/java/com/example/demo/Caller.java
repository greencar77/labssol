package com.example.demo;

import com.example.demo.helper.DynamicCaller;

import static com.example.demo.helper.HttpUtils.*;

public class Caller {

    public static void main(String[] args) {
        DynamicCaller.executeDynamically(Caller.class);
    }

    private static void doGetCustomer() {
        sendGet(DEFAULT_HOST + "/api/customers/100");
    }

    private static void doGetCustomerOrders() {
        sendGet(DEFAULT_HOST + "/api/customers/100/orders");
    }

    private static void doPostCreate() {
        String json = """
                {
                                      "customerName": "John Smith",
                                      "customerEmail": "john@example.com",
                                      "productName": "Laptop",
                                      "amount": 999.99
                                    }
                """;
        sendPost(DEFAULT_HOST + "/api/create", json);
    }

    private static void doPutUpdate() {
        sendPut(DEFAULT_HOST + "/api/update?customerId=100&orderId=100&email=new@y.com&amount=77");
    }

    private static void doDelete() {
        String id = "100";
        sendDelete(DEFAULT_HOST + "/api/orders" + "/" + id);
    }
}
