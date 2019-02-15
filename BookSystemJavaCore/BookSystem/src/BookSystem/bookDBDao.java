package BookSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class bookDBDao {

	private ConnectionPoolSingleton connectionPoolSingleton = ConnectionPoolSingleton.getInstance();
	
	
	public void AddBook(Book b) {
		String insert = "insert into book (name,title) values(?,?)";
		Connection c = this.connectionPoolSingleton.getConnection();
		try {
			PreparedStatement statement = c.prepareStatement(insert);
			statement.setString(1,b.getName());
			statement.setString(2,b.getTitle());
			statement.execute();
			System.out.println("new book inserted!!");

		} catch (SQLException e) {
			System.out.println("insert problem !!");
		}
	}
	public void deleteBook(String name) {
		Connection c = this.connectionPoolSingleton.getConnection();
		String delete = "delete from book where name = ?";
		try {
			PreparedStatement statement = c.prepareStatement(delete);
			statement.setString(1, name);
			statement.executeUpdate();
			System.out.println("book deleted !!");
		} catch (SQLException e) {
			System.out.println("book deleted problem !!");
		}
		
	}
	public ArrayList<Book> getAllBooks(){
		ArrayList<Book> books = new ArrayList<Book>();
		String select  = "select * from book";
		Connection c = this.connectionPoolSingleton.getConnection();
		Statement statement;
		try {
			statement = c.createStatement();
			ResultSet set = statement.executeQuery(select);
			System.out.println("all books selected");
			while(set.next()) {
				Book book = new Book(set.getString(1),set.getString(2));
				books.add(book);
			}
			System.out.println("Return all books");
			return books;
		} catch (SQLException e) {
			System.out.println("all books selection problem!!");
		}
		
		System.out.println("problem return all books");
		return null;
		
	}
	public void deleteAllBooks() {
		Connection c = this.connectionPoolSingleton.getConnection();
		String Clear  = "delete  from book";
		try {
			Statement statement = c.createStatement();
			statement.executeUpdate(Clear);
			System.out.println("All deleted !!");
		} catch (SQLException e) {
			System.out.println("Deleted All problem !!");
		}
		


	}
	
}
