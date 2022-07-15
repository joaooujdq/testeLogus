package com.example.testeLogus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import com.example.testeLogus.models.Usuario;
import com.example.testeLogus.repositories.UsuarioDAO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;

@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class TesteLogusApplication implements CommandLineRunner {
	@Autowired
	private UsuarioDAO usuarioDAO;

	public static void main(String[] args) {
		SpringApplication.run(TesteLogusApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception{
		Usuario u1 = new Usuario(1, "usuario1", "login1@email.com", "abcdef1$");
		Usuario u2 = new Usuario(2, "usuario2", "login2@email.com", "abcdef2$");
		usuarioDAO.saveAll(Arrays.asList(u1,u2));
	}
}
