package com.web.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
// Book System Example import from Jar file 
import BookSystem.*;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BookSystemSingleton system;
	
	
    @Override
	public void init() throws ServletException {
		
			system = BookSystemSingleton.getInstance();
		       System.out.println("Book System on");
	}
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);

		if (session != null) {
			session.invalidate();
		}
		// create new session for new user access 
		session = request.getSession(true); 
		// Get input details from html file 
		String username = request.getParameter("usr");
		String password = request.getParameter("pwd");
		String userType = request.getParameter("type");
		AdminFacade facade = system.login(username, password, userType);
			if (facade != null) {
				session.setAttribute("facade", facade);
				// Example Just for Admin , the same idea for other users 
				if(userType.equals("Admin")){
					System.out.println("In");
					request.getRequestDispatcher("Admin.html").forward(request, response);}

			else {
				// if facade  == null return to Home Page 
				response.sendRedirect("login.html");
			}

		}

	}
    


}
