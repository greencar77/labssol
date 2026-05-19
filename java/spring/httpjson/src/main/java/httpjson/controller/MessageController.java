package httpjson.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import httpjson.domain.Message;

@RestController
@RequestMapping("/api")
public class MessageController {

    private Message storedMessage = new Message("Hello");

    @GetMapping("/message")
    public Message getMessage() {
        return storedMessage;
    }

    @PostMapping("/message")
    public Message setMessage(@RequestBody Message newMessage) {
        storedMessage = newMessage;
        return storedMessage;
    }
}
