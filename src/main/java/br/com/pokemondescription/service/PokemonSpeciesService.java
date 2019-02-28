package br.com.pokemondescription.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.ResponseBody;

import br.com.pokemondescription.model.NamedAPIResource;
import br.com.pokemondescription.model.ResultRestPokemon;
import br.com.pokemondescription.utils.ApplicationProperties;

@Service
public class PokemonSpeciesService {

    @Autowired
    private ApplicationProperties appProperties;

    public List<NamedAPIResource> getAllPokemonSpecies() throws IOException {
	OkHttpClient httpClient = new OkHttpClient();
	Request request = new Request.Builder().url(this.appProperties.getUrlSpecies()).build();
	ResponseBody body = httpClient.newCall(request).execute().body();
	ResultRestPokemon pokemonResult = new ObjectMapper().readValue(body.string().toString(), ResultRestPokemon.class);
	return pokemonResult.getResults();
    }

    public List<String> getAllPokemonNames() throws IOException {
	List<NamedAPIResource> restPokemon = getAllPokemonSpecies();
	List<String> pokemonsNames = restPokemon.stream().map(obj -> obj.getName()).collect(Collectors.toList());
	return pokemonsNames;
    }
}
