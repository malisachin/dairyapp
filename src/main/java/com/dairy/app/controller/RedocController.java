package com.dairy.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RedocController {

	@RequestMapping("/docs")
    public String redoc() {
        return "redirect:/static/redoc.html";
    }
}
