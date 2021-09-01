package br.com.mesttra.filmesmesttra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class FilmesMesttraApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilmesMesttraApplication.class, args);
	}

}
