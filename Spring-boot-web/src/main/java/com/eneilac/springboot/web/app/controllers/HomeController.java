package com.eneilac.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	
	@GetMapping("/")
	public String home() {
		return "forward:/app/index"; // no recarga la pagina ni altera las url
		//return "redirect:/app/index";  esta manera en cambio si te altera la url y recarga la pagina haciendo un redirección.
	}

}
