package com.eneilac.springboot.web.app.controllers;

//import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eneilac.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app") // ruta de primer nivel
public class IndexController {

	// Inyeccion de dependencias
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;

	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;

	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;

	@GetMapping(value = { "/index", "/", "home" }) // en caso de querer mapear solo 1 quitariamos los corchetes. ruta de
													// segundo nivel
	public String index(Model model) {

		model.addAttribute("titulo", textoIndex); // lo primero es el nombre del contenedor y lo segundo su
													// valor.

		return "index"; // *En este caso tendriamos que tener una plantilla o vista que se llame index .
	}

	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario = new Usuario(); // instanciacion del objeto
		usuario.setNombre("edu");
		usuario.setApellidos("neila"); // establecemos valores al objeto
		usuario.setEmail("ejemplo@gmail.com");

		model.addAttribute("usuario", usuario); // Pasamos el objeto a la interfaz model para poder tratar esos datos en
												// la vista.
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre())); // lo primero es el nombre del
																				// contenedor y lo segundo
																				// su

		return "perfil";
	}

	@RequestMapping("/lista")
	public String listar(Model model) {

		// List<Usuario> usuarios = new ArrayList<>();
		// usuarios.add(new Usuario("Eduardo","Neila","edu@gmail.com"));
		// usuarios.add(new Usuario("Moises","Sanchez","moises@gmail.com"));
		// usuarios.add(new Usuario("Alejandro","Lopez","Alejandro@gmail.com"));

		model.addAttribute("titulo", textoListar);
		return "lista";
	}

	@ModelAttribute("usuarios") // da acceso a todas las vistas que necesiten los usuarios.
	public List<Usuario> pasarUsuarios() {

		List<Usuario> usuarios = Arrays.asList(new Usuario("Eduardo", "Neila", "edu@gmail.com"), // seria mas simple
																									// hacerlo asi con
																									// la clase Arrays
																									// de java util
				new Usuario("Moises", "Sanchez", "moises@gmail.com"),
				new Usuario("Alejandro", "Lopez", "Alejandro@gmail.com"));

		return usuarios;

	}

}
