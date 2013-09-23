package edu.sjsu.cmpe.dropwizard.library.domain;

public class Reviews {
	private int revId = 0;
	private static int n = 0;
	private int rating = 0;
	private String comment = "Unrated";
	
	Reviews ()
	{
		setRevId();
	}
	public int getRevId() {
		return revId;
	}
	
	public void setRevId() {
		revId = ++n;
	}


	public String getComment() {
		return comment;
	}

	public void setComment(String msg) {
		comment = msg;
	}

	public int getRating() {
		return rating;
	}
	
	public void setRating(int rat) { 
		rating = rat;
	}
	}
