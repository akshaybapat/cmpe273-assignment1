package edu.sjsu.cmpe.dropwizard.library.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.dropwizard.library.domain.Authors;
import edu.sjsu.cmpe.dropwizard.library.dto.LinksDto;

@JsonPropertyOrder(alphabetic = true)
public class AuthorsDto extends LinksDto {

	 private List<Authors> Authors;

	    /**
	     * @param book
	     */
	    

	    public AuthorsDto(List<Authors> Authors) {
	    	this.Authors = Authors;
		}

		/**
	     * @return the book
	     */
	    public List<Authors> getAuthors() {
		return Authors;
	    }

	    /**
	     * @param book
	     *            the book to set
	     */
	    public void setAuthors(List<Authors> Authors) {
		this.Authors = Authors;
	    }
}
