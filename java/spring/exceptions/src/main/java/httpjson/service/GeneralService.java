package httpjson.service;

import org.springframework.stereotype.Component;

@Component
public class GeneralService {
    public void do1() {
        String a = null;
        a.getBytes();
    }

    public void do2() {
        throw new RuntimeException("Something happened");
    }
}
