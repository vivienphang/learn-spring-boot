package com.example.LearnSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("dev")
public class MySimpleDevController {

    @RequestMapping("/home")
    public String home() {
        return "Hello world -- You are entering the dev platform";
    }

    @RequestMapping("/test")
    public String test() {
        return "Testing -- You are testing in the dev platform";
    }
}
