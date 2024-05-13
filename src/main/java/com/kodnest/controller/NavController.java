package com.kodnest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavController {
@GetMapping("/login")
public String login() {
	return "Login";
}
@GetMapping("/registration")
public String registration() {
	return "registration";
}
@GetMapping("/addsong")
public String song() {
	return "song";
}
}
