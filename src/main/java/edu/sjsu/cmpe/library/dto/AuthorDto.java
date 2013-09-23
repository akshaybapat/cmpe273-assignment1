package edu.sjsu.cmpe.dropwizard.library.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.dropwizard.library.domain.Authors;
import edu.sjsu.cmpe.dropwizard.library.dto.LinksDto;

//@JsonPropertyOrder(alphabetic = true)
public class AuthorDto extends LinksDto {

	 private Authors Author;

	    /**
	     * @param book
	     */
	    public AuthorDto(Authors Author) {
		super();
		this.Author = Author;
	    }

		/**
	     * @return the book
	     */
	    public Authors getAuthor() {
		return Author;
	    }

	    /**
	     * @param book
	     *            the book to set
	     */
	    public void setAuthor(Authors Author) {
		this.Author = Author;
	    }
}
