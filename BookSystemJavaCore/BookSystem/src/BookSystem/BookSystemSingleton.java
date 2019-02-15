package BookSystem;

public class BookSystemSingleton {

	private static BookSystemSingleton instance = null;
	
	
	
	
	public static BookSystemSingleton getInstance() {
		if (instance == null) {
			instance = new BookSystemSingleton();
		}
		return instance;
	}
	
	// Example for Admin Facade , use abstract class for all possible users !!!
	// Type can be Enum , login example as string 
	public AdminFacade login(String user,String pass,String type) {
		
		if(type.equals("Admin")) {
			return new AdminFacade();
		}
		return null;
		// else , any users type 
		
	}
	
}
