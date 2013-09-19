package edu.sjsu.cmpe.dropwizard.library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.dropwizard.library.domain.Books;
import edu.sjsu.cmpe.dropwizard.library.dto.LinksDto;

@JsonPropertyOrder(alphabetic = true)
public class BookDto extends LinksDto {

	 private Books book;

	    /**
	     * @param book
	     */
	    public BookDto(Books book) {
		super();
		this.book = book;
	    }

	    /**
	     * @return the book
	     */
	    public Books getBook() {
		return book;
	    }

	    /**
	     * @param book
	     *            the book to set
	     */
	    public void setBook(Books book) {
		this.book = book;
	    }
}
