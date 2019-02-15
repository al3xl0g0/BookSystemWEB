package BookSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		
		BookSystemSingleton systemSingleton = BookSystemSingleton.getInstance();
		// Login Test 
		AdminFacade facade = systemSingleton.login("Admin", "1234", "Admin");
		
		if(facade!=null) {
			//Clear all from book table , Start 
			facade.deleteAll();
			
			//insert to book table  example
			facade.AddBook(new Book("name1", "title1"));
			facade.AddBook(new Book("name2", "title2"));
			facade.AddBook(new Book("name3", "title3"));
			facade.AddBook(new Book("name4", "title4"));
			
			//remove from book table example "last added book4" 
			facade.deleteBook("name4");
			
			//get all books from table example 
			ArrayList<Book> books = facade.AllBooks();
			System.out.println(books);
		}



	
		

	}

}
