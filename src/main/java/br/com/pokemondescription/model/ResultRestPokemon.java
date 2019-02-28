package br.com.pokemondescription.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultRestPokemon implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer count;
    @JsonProperty("next")
    private String nextRest;
    @JsonProperty("previous")
    private String previousRest;
    private List<NamedAPIResource> results;

    public Integer getCount() {
	return count;
    }

    public void setCount(Integer count) {
	this.count = count;
    }

    public String getNextRest() {
	return nextRest;
    }

    public void setNextRest(String nextRest) {
	this.nextRest = nextRest;
    }

    public String getPreviousRest() {
	return previousRest;
    }

    public void setPreviousRest(String previousRest) {
	this.previousRest = previousRest;
    }

    public List<NamedAPIResource> getResults() {
	return results;
    }

    public void setResults(List<NamedAPIResource> results) {
	this.results = results;
    }

}
