package com.example.LearnSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("prod")
public class MySimpleController {

//    @Autowired
//    private Calculator calculator;
    private final Calculator calculator;

    public MySimpleController(Calculator calculator) {
        this.calculator = calculator;
    }

    @RequestMapping("/home")
    public String home() {
        return "Hello world -- You are in PRODUCTION";
    }

    @GetMapping("/sum")
    public int sum(@RequestParam("a") int a, @RequestParam("b") int b) {
//        old method
//        int sum = a + b;
//        return sum;
        return calculator.calculateSum(a, b);
    }
}
