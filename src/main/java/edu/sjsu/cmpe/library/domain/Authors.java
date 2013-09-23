package edu.sjsu.cmpe.dropwizard.library.domain;

public class Authors {
	private int authId = 0;
	private static int n = 0;
	private String name = "Anonymous";
	
	Authors()
	{
	setAuthId();
	}
	
	public int getAuthId() {
		return authId;
	}
	
	public void setAuthId() {
		authId = ++n;
	}


	public String getName() {
		return name;
	}

	public void setName(String nam) {
		name = nam;
	}


}
