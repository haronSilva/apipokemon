package br.com.pokemondescription.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.pokemondescription.response.ResponsePokemonSpecies;
import br.com.pokemondescription.service.PokemonSpeciesService;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonSpeciesService speciesService;

    @RequestMapping(value = "/species", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<ResponsePokemonSpecies> getAllPokemonSpecies() {
	ResponsePokemonSpecies response = new ResponsePokemonSpecies();
	try {
	    response.setSpeciesList(this.speciesService.getAllPokemonSpecies());
	    return new ResponseEntity<ResponsePokemonSpecies>(response, HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<ResponsePokemonSpecies>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }

    @RequestMapping(value = "/species/names", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> getAllPokemonNames() {
	try {
	    List<String> names = this.speciesService.getAllPokemonNames();
	    return new ResponseEntity<List<String>>(names, HttpStatus.OK);
	} catch (Exception e) {
	    return new ResponseEntity<List<String>>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
    }
}
