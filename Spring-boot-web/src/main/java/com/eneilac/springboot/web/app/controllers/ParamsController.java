package com.eneilac.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class ParamsController {

	@GetMapping("/")
	public String index() {
		return "params/index";
	}

	@GetMapping("/string")
	public String param(
			@RequestParam(name = "texto", required = false, defaultValue = "Valor por defecto") String texto,
			Model model) {

		model.addAttribute("resultado", "el texto enviado: " + texto);

		return "params/ver"; // si la vista esta en un nivel de directorio inferior hay que indicarlo.
	}

	@GetMapping("/mix-params") // --> Manera 1
	public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model) {

		model.addAttribute("resultado", "el saludo enviado: '" + saludo + "'y el numero es'" + numero + "'");

		return "params/ver"; // si la vista esta en un nivel de directorio inferior hay que indicarlo.
	}

	@GetMapping("/mix-params-request") // --> Manera 2
	public String param(HttpServletRequest request, Model model) {

		String saludo = request.getParameter("saludo");
		Integer numero = null;

		try {

			numero = Integer.parseInt(request.getParameter("numero")); // cada vez que usemos un parseo lo suyo es
																		// usar un try catch

		} catch (NumberFormatException e) {
			numero = 0;
		}

		model.addAttribute("resultado", "el saludo enviado: '" + saludo + "'y el numero es'" + numero + "'");
		return "params/ver"; // si la vista esta en un nivel de directorio inferior hay que indicarlo.
	}
}