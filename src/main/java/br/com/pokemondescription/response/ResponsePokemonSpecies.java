package br.com.pokemondescription.response;

import java.io.Serializable;
import java.util.List;

import br.com.pokemondescription.model.NamedAPIResource;

public class ResponsePokemonSpecies implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public List<NamedAPIResource> getSpeciesList() {
	return speciesList;
    }

    public void setSpeciesList(List<NamedAPIResource> speciesList) {
	this.speciesList = speciesList;
    }

    private List<NamedAPIResource> speciesList;

}
