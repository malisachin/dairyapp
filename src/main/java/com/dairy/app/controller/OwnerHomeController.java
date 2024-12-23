package com.dairy.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OwnerHomeController {

	
	@GetMapping("/")
    public String home() {
        return "index.html"; // This tells Spring to look for index.html in the templates folder
    }
}
