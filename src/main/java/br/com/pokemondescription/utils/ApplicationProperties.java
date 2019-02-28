package br.com.pokemondescription.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ApplicationProperties {
    @Value("${urlSpecies}")
    private String urlSpecies;

    public String getUrlSpecies() {
	return urlSpecies;
    }

}
