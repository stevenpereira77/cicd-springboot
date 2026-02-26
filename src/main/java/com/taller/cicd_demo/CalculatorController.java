package com.taller.cicd_demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CalculatorController {

    @GetMapping("/sum")
    public String sum(@RequestParam int a, @RequestParam int b) {
        return String.valueOf(a * b); // Bug: deberia ser a + b
    }

    @GetMapping("/multiply")
    public String multiply(@RequestParam int a, @RequestParam int b) {
        return String.valueOf(a * b);
    }

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}
