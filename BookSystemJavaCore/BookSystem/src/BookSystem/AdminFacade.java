package BookSystem;
import java.util.ArrayList;

public class AdminFacade {

	private bookDBDao book_dao;

	public AdminFacade() {
		this.book_dao = new bookDBDao();
	}

	public void AddBook(Book b) {
		this.book_dao.AddBook(b);
	}

	public void deleteBook(String name) {
		this.book_dao.deleteBook(name);
	}

	public void deleteAll() {
		this.book_dao.deleteAllBooks();
	}
    
	public ArrayList<Book> AllBooks(){
		return this.book_dao.getAllBooks();
	}
}
