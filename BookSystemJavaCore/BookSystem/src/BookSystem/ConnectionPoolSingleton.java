package BookSystem;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.sun.org.apache.regexp.internal.recompile;

public class ConnectionPoolSingleton {

	private static ConnectionPoolSingleton instance = null;
	private Collection<Connection> pool;
	private ConnectionPoolSingleton() {
	}
	
	public static ConnectionPoolSingleton getInstance() {
		if (instance == null) {
			instance = new ConnectionPoolSingleton();

			try {
				instance.init();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return instance;
	}
	
	private void init() throws Exception {
		pool = new ArrayList<Connection>();

		for (int i = 0; i < 10; i++) {
			pool.add(createConnection());
		}
	}
	
	private Connection createConnection() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksDB", "root", "root");
		return connection;
	}
	
	public synchronized Connection getConnection() {
		while (pool.isEmpty()) {

			try {
				System.out.println(" createing connections!!");
				wait();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection connection = pool.iterator().next();
		pool.remove(connection);
		
		System.out.println("connection in Active");
		notifyAll();
		return connection;
	}
	
	
	
}
