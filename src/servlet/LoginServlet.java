package servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.annotation.Generated;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.Login;
import util.security;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user=new User();
		security security = new security();
		String input = request.getParameter("inputPassword");
		byte[] salt = Login.getSalt(request.getParameter("inputUser"));
		if(salt!=null) {
			String password = security.generateHash(input,salt);
			user.setUserName(request.getParameter("inputUser"));
			user.setUserPass(password);
			user=Login.login(user);
			
			if(user.isValid()) {
				HttpSession session = request.getSession(true);

				session.setAttribute("currentUser", user.getId());
				session.setAttribute("Name", user.getName());
				response.sendRedirect("home.jsp");
			}
			else {
				request.setAttribute("errorMessage", "Invalid Password!!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
		}
		else {
			request.setAttribute("errorMessage", "Invalid Username!!!");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
		
		
	}

}
