package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import br.com.alura.screenmatch.service.SerieService;
import br.com.alura.screenmatch.service.traducao.TranslationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScreenmatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Bean
	CommandLineRunner run(SerieService serieService) {
		return args -> {
			Principal principal = new Principal(serieService); // Agora passamos o serviço corretamente
			principal.exibeMenu();
		};
	}

	@Bean
	public SerieService serieService() {
		return new SerieService(new TranslationService()); // Criando dependências corretamente
	}
}
