package edu.sjsu.cmpe.dropwizard.library.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import edu.sjsu.cmpe.dropwizard.library.domain.Reviews;
import edu.sjsu.cmpe.dropwizard.library.dto.LinksDto;

//@JsonPropertyOrder(alphabetic = true)
public class ReviewDto extends LinksDto {

	 private Reviews review;

	    /**
	     * @param book
	     */
	    public ReviewDto(Reviews review) {
		super();
		this.review = review;
	    }

		/**
	     * @return the book
	     */
	    public Reviews getReview() {
		return review;
	    }

	    /**
	     * @param book
	     *            the book to set
	     */
	    public void setReview(Reviews review) {
		this.review = review;
	    }
}
