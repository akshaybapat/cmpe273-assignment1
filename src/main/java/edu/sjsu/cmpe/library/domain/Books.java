package edu.sjsu.cmpe.dropwizard.library.domain;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Books {
	private int isbn = 0;
	private String title = "Untitled";
	@JsonProperty("publication-date")
	private String pubDate = "";
	private String status = "available";
	private List<Authors> authors = new ArrayList<Authors>();
	private List<Reviews> reviews = new ArrayList<Reviews>();
	
	public Books()
	{
		
	}
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int n) {
		isbn = n;
	}

	public String getPubDate() {
		return pubDate;
	}
	public void setPubDate(String date) {
		this.pubDate = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String tit) {
		title = tit;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String stat) {
		status = stat;
	}
	
	public Authors getAuthor(int i)
	{
		return authors.get(i);
	}
	
	public List<Authors> getAuthors()
	{
		return authors;
	}
	
	public void setAuthors(List<Authors> authlist)
	{
		authors = authlist;
	}
	
	public Reviews getReview(int i)
	{
		return reviews.get(i);
	}
	
	public List<Reviews> getReviews()
	{
		return reviews;
	}
	
	public void setReview(Reviews review)
	{
		reviews.add(review);
	}
	
	
	}
