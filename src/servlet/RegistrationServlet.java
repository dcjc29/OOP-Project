package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.Register;
import util.security;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		security security = new security();
		
		String input = request.getParameter("inputPassword");
		byte[] salt = security.createSalt();
		String password = security.generateHash(input, salt);
		
		User user = new User();
		
		user.setUserName(request.getParameter("inputUser"));
		user.setUserPass(password);
		user.setName(request.getParameter("inputFName")+" "+request.getParameter("inputLName"));
		user.setEmail(request.getParameter("inputEmail"));
		user.setAddress(request.getParameter("inputAddress"));
		user.setMobileNo(request.getParameter("inputMobile"));
		

		
		String message = Register.register(user,salt);
		
		if(message.equals("success")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("registration.jsp").forward(request, response);
		}
	}

}
