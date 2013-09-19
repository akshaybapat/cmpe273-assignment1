package edu.sjsu.cmpe.dropwizard.library.api.resources;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.yammer.dropwizard.jersey.params.LongParam;
import com.yammer.metrics.annotation.Timed;

import edu.sjsu.cmpe.dropwizard.library.domain.Authors;
import edu.sjsu.cmpe.dropwizard.library.domain.Books;
import edu.sjsu.cmpe.dropwizard.library.domain.Reviews;
import edu.sjsu.cmpe.dropwizard.library.dto.AuthorDto;
import edu.sjsu.cmpe.dropwizard.library.dto.AuthorsDto;
import edu.sjsu.cmpe.dropwizard.library.dto.BookDto;
import edu.sjsu.cmpe.dropwizard.library.dto.LinkDto;
import edu.sjsu.cmpe.dropwizard.library.dto.LinksDto;
import edu.sjsu.cmpe.dropwizard.library.dto.ReviewDto;
import edu.sjsu.cmpe.dropwizard.library.dto.ReviewsDto;

@Path("/v1/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
	
	 public static HashMap<Integer, Books> booklist = new HashMap<Integer,Books>();
	 public static HashMap<Integer, Authors> authorlist = new HashMap<Integer,Authors>();
     public static HashMap<Integer, List<Reviews>> reviewlist = new HashMap<Integer,List<Reviews>>();
     static int index = 0;
     
    public BookResource() {
	// do nothing
    }
    
    @GET
    public HashMap<Integer, Books> getBookList()
    {
    	return booklist;
    }
        
    @POST
    @Timed(name = "create-book")
    public Response postBookByIsbn(Books b) {
    b.setIsbn(++index);
    booklist.put(new Integer(index),b);
     
	LinksDto linksResponse = new LinksDto(); 
	linksResponse.addLink(new LinkDto("view-book", "/books/" + b.getIsbn(),
		"GET"));
	linksResponse.addLink(new LinkDto("update-book",
		"/books/" + b.getIsbn(), "POST"));
	linksResponse.addLink(new LinkDto("delete-book", "/books/" + b.getIsbn(),
			"DELETE"));
		linksResponse.addLink(new LinkDto("create-review",
			"/books/" + b.getIsbn(), "POST"));
	
		return Response.status(201).entity(linksResponse).build();
    }
    
    @GET
    @Path("/{isbn}")
    @Timed(name = "view-book") 
    
    public BookDto getBookByIsbn(@PathParam("isbn") int isbn) {
    	Books book = booklist.get(isbn);
    	BookDto bookResponse = new BookDto(book);
    	bookResponse.addLink(new LinkDto("view-book", "/books/" + book.getIsbn(),
    		"GET"));
    	bookResponse.addLink(new LinkDto("update-book",
    		"/books/" + book.getIsbn(), "POST"));
    	bookResponse.addLink(new LinkDto("delete-book", "/books/" + book.getIsbn(),
    			"DELETE"));
    		bookResponse.addLink(new LinkDto("create-review",
    			"/books/" + book.getIsbn(), "POST"));
    	

    	return bookResponse;
        }
    
    @DELETE
    @Path("/{isbn}")
    @Timed(name = "delete-book") 
    
    public LinksDto delBookByIsbn(@PathParam("isbn") int isbn) {
    	booklist.remove(isbn);
    	LinksDto links = new LinksDto();
    	links.addLink(new LinkDto("create-book", "/books", "POST"));

    	return links;
    }
    
    @PUT
    @Path("/{isbn}")
    @Timed(name = "put-book") 
    
    public LinksDto updateBookByIsbn(@PathParam("isbn") int isbn,@QueryParam("status") String status) {
    	Books book = booklist.get(isbn);
    	book.setStatus(status);
    	booklist.put(isbn,book);
    	LinksDto links = new LinksDto();
    	links.addLink(new LinkDto("view-book", "/books" + book.getIsbn(), "GET"));
    	links.addLink(new LinkDto("update-book", "/books" + book.getIsbn(), "PUT"));
    	links.addLink(new LinkDto("delete-book", "/books" + book.getIsbn(), "DELETE"));
    	links.addLink(new LinkDto("create-review", "/books" + book.getIsbn() + "/reviews", "POST"));
    	if (!book.getReviews().isEmpty()) {
    	links.addLink(new LinkDto("view-all-reviews", "/books" + book.getIsbn() + "/reviews", "POST"));
    	}
    	return links;
    }
    
    @POST
    @Path("/{isbn}/reviews")
    @Timed(name = "create-review")
    public Response postReviewByIsbn(@PathParam("isbn") int isbn,Reviews r) {
    Books book = booklist.get(isbn);
    book.setReview(r);
   	LinksDto linksResponse = new LinksDto(); 
	linksResponse.addLink(new LinkDto("view-reviews", "/books/" + book.getIsbn() + "/reviews/" + r.getRevId(),
		"GET"));
	
		
	return Response.status(201).entity(linksResponse).build();
    }
    
    
    @GET
    @Path("/{isbn}/reviews")
    @Timed(name = "view-reviews")
    public ReviewsDto getAllReviewsByIsbn(@PathParam("isbn") int isbn){
    	Books book = booklist.get(isbn);
        List<Reviews> review = book.getReviews();
        ReviewsDto reviewResponse = new ReviewsDto(review); 
        return reviewResponse;
    }
   
    @GET
    @Path("/{isbn}/reviews/{id}")
    @Timed(name = "view-review")
    public ReviewDto getReviewById(@PathParam("isbn") int isbn,@PathParam("id") int id) {
    Books book = booklist.get(isbn);
    Reviews review = book.getReview(id-1);
    ReviewDto reviewResponse = new ReviewDto(review); 
	reviewResponse.addLink(new LinkDto("view-reviews", "/books/" + isbn + "/reviews/" + id,
		"GET"));
	
		
	return reviewResponse;
    }
    
    @GET
    @Path("/{isbn}/authors")
    @Timed(name = "view-authors")
    public AuthorsDto getAllauthorsByIsbn(@PathParam("isbn") int isbn){
    	Books book = booklist.get(isbn);
        List<Authors> author = book.getAuthors();
        AuthorsDto authorResponse = new AuthorsDto(author); 
        return authorResponse;
    }
   
    @GET
    @Path("/{isbn}/authors/{id}")
    @Timed(name = "view-author")
    public AuthorDto getauthorById(@PathParam("isbn") int isbn,@PathParam("id") int id) {
    Books book = booklist.get(isbn);
    Authors author = book.getAuthor(id-1);
    AuthorDto authorResponse = new AuthorDto(author); 
	authorResponse.addLink(new LinkDto("view-authors", "/books/" + isbn + "/authors/" + id,
		"GET"));
	
		
	return authorResponse;
    }
}
