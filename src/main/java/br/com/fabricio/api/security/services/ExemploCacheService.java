package br.com.fabricio.api.security.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class ExemploCacheService {
	
	public static final Logger log = LoggerFactory.getLogger(ExemploCacheService.class);
	
	@Cacheable("exemploCache")
	public String exemploCache() {
		log.info("#### Executando o serviço...");
		return "Teste de exemplo de cache";
	}

}
