package com.sistema.quiz;

import com.sistema.quiz.entities.Rol;
import com.sistema.quiz.entities.Usuario;
import com.sistema.quiz.entities.UsuarioRol;
import com.sistema.quiz.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class SistemaQuizBackendApplication implements CommandLineRunner {

	@Autowired
	private UsuarioService usuarioService;
	public static void main(String[] args) {
		SpringApplication.run(SistemaQuizBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario	usuario = new Usuario();
		usuario.setNombre("Ivan");
		usuario.setApellido("Alvarez");
		usuario.setPassword("12345");
		usuario.setEmail("ia@gmail.com");
		usuario.setTelefono("1231231234");
		usuario.setPerfil("foto.png");

		Rol rol = new Rol();
		rol.setId(1L);
		rol.setNombre("ADMIN");

		Set<UsuarioRol> usuarioRoles = new HashSet<>();
		UsuarioRol usuarioRol = new UsuarioRol();
		usuarioRol.setRol(rol);
		usuarioRol.setUsuario(usuario);
		usuarioRoles.add(usuarioRol);

		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
		System.out.println(usuarioGuardado.getUsername());
	}
}
