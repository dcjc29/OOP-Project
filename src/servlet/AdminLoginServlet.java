package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.AdminLogin;
import service.Login;
import util.security;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
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

		User user=new User();
		security security = new security();
		String input = request.getParameter("inputPassword");
		byte[] salt = AdminLogin.getSalt(request.getParameter("inputUser"));
		if(salt!=null) {
			String password = security.generateHash(input,salt);
			user.setUserName(request.getParameter("inputUser"));
			user.setUserPass(password);
			user=AdminLogin.login(user);
			
			if(user.isValid()) {
				HttpSession session = request.getSession(true);

				session.setAttribute("currentUser", user.getId());
				session.setAttribute("userName", user.getUserName());
				response.sendRedirect("adminPanel.jsp");
			}
			else {
				request.setAttribute("errorMessage", "Invalid Password!!!");
				request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
			}
			
		}
		else {
			request.setAttribute("errorMessage", "Invalid Username!!!");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}
		
		
		
		
	}
	
}
