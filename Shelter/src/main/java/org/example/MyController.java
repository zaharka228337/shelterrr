package org.example;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @PostMapping("/process")
    public String process(@RequestBody String input) {
        // Вызов метода бизнес-логики и возврат результата в формате JSON
        String result = myService.processRequest(input);
        return "{\"result\": \"" + result + "\"}";
    }
}

