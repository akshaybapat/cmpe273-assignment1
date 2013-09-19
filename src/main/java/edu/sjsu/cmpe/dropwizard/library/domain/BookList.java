package edu.sjsu.cmpe.dropwizard.library.domain;

import java.util.List;
import java.util.ArrayList;

public class BookList
{
	List<Books> allbooks = new ArrayList<Books>();	
	int index;

	public List<Books> getList()
	{
	return allbooks;
	}

	public void addBook(Books book)
	{
		allbooks.add(book);
		updateIndex();
		
	}

	public void remBook()
	{

		allbooks.remove(index);
		updateIndex();
	}

	public void updateIndex()
	{
		index = allbooks.size();
	}

}


