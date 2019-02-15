package com.web.services;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import BookSystem.AdminFacade;
import BookSystem.Book;

@Path("/admin")
public class AdminService {
     
	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	//get admin facade 
	private AdminFacade getFacade() {
		AdminFacade admin = null;
		admin = (AdminFacade) request.getSession(false).getAttribute("facade");
		return admin;
	}

	// Create new book
	@GET
	@Path("createbook")
	@Produces(MediaType.TEXT_PLAIN)
	public String createbook(@QueryParam("name") String Name, @QueryParam("title") String title) {

		AdminFacade admin = getFacade();

		Book book = new Book(Name,title);
		admin.AddBook(book);
	
		return "Book Added";

	}
	
	// remove book by name
	@GET
	@Path("removebook")
	@Produces(MediaType.TEXT_PLAIN)
	public String createbook(@QueryParam("name") String Name) {

		AdminFacade admin = getFacade();

		admin.deleteBook(Name);
	
		return "Book deleted";

	}
	
	//get All books from DB 
	
	@GET
	@Path("allbooks")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllCompanies() {

		AdminFacade admin = getFacade();
			ArrayList<Book> books = admin.AllBooks();
			return new Gson().toJson(books);

	}

}
