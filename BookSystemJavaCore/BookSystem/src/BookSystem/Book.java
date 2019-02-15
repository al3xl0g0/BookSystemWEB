package BookSystem;

public class Book {
	String name;
	String title;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", title=" + title + "]";
	}

	public Book(String name, String title) {
		super();
		this.name = name;
		this.title = title;
	}

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

}
