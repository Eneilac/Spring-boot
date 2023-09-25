package com.eneilac.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class RutasVariablesController {
	
	@GetMapping("/string/{texto}") // es importante que el nombre del parametro sea el mismo que el del mapeado.
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("titulo","Recibir parametros de la ruta (@PathVariable)");
		model.addAttribute("resultado","El texto enviado en la ruta es: "+texto);
		
		return "variables/ver";
	}

}
