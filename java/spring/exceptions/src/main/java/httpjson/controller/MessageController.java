package httpjson.controller;

import httpjson.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import httpjson.domain.Message;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private GeneralService service;

    private Message storedMessage = new Message("Hello");

    @GetMapping("/message")
    public Message getMessage() {
        return storedMessage;
    }

    @GetMapping("/negative")
    public Message getNegative() {
        service.do1();
        return storedMessage;
    }

    @PostMapping("/message")
    public Message setMessage(@RequestBody Message newMessage) {
        storedMessage = newMessage;
        return storedMessage;
    }
}
