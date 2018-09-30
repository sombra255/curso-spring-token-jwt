package br.com.fabricio.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import br.com.fabricio.api.security.entities.Usuario;
import br.com.fabricio.api.security.enums.PerfilEnum;
import br.com.fabricio.api.security.repositories.UsuarioRepository;
import br.com.fabricio.api.security.services.ExemploCacheService;
import br.com.fabricio.api.utils.SenhaUtils;

@SpringBootApplication
@EnableCaching
public class SringBootTokenJwtApplication {
	
	@Autowired
	private ExemploCacheService exemploCacheService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(SringBootTokenJwtApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			
			Usuario usuario = new Usuario();
			usuario.setEmail("usuario@email.com");
			usuario.setPerfil(PerfilEnum.ROLE_USUARIO);
			usuario.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(usuario);
			
			Usuario admin = new Usuario();
			admin.setEmail("admin@email.com");
			admin.setPerfil(PerfilEnum.ROLE_ADMIN);
			admin.setSenha(SenhaUtils.gerarBCrypt("123456"));
			this.usuarioRepository.save(admin);
			
			
			
			System.out.println("Executando o serviço pela primeira vez: ");
			System.out.println(exemploCacheService.exemploCache());
			
			
			System.out.println("Executando o serviço pela segunda vez: ");
			System.out.println(exemploCacheService.exemploCache());
			
		};
	}
}
