package edu.sjsu.cmpe.dropwizard.library.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.dropwizard.library.domain.Reviews;
import edu.sjsu.cmpe.dropwizard.library.dto.LinksDto;

@JsonPropertyOrder(alphabetic = true)
public class ReviewsDto extends LinksDto {

	 private List<Reviews> reviews;

	    /**
	     * @param book
	     */
	    

	    public ReviewsDto(List<Reviews> reviews) {
	    	this.reviews = reviews;
		}

		/**
	     * @return the book
	     */
	    public List<Reviews> getReviews() {
		return reviews;
	    }

	    /**
	     * @param book
	     *            the book to set
	     */
	    public void setReviews(List<Reviews> reviews) {
		this.reviews = reviews;
	    }
}
