package com.eneilac.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
	
	@GetMapping(value={"/index","/","home"}) //en caso de querer mapear solo 1 quitariamos los corchetes.
	public String index(Model model) {
		
		model.addAttribute("titulo", "Hola Spring Framework"); //lo primero es el nombre del contenedor y lo segundo su valor.
		
		return "index"; //*En este caso tendriamos que tener una plantilla o vista que se llame index .
	}

}
