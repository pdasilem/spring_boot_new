package ru.pdasilem.spring_boot_new.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

    @GetMapping()
    public String welcomePage() {
        return "welcome/hello";
    }
}
