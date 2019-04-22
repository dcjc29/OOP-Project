package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.user;
import service.Login;

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
			user user=new user();
			
			user.setUserName(request.getParameter("inputUser"));
			user.setUserPass(request.getParameter("inputPassword"));
			
			System.out.println(user.getUserName());
			System.out.println(user.getUserPass());
		
			user=Login.login(user);
			
			if(user.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentUser", user);
				response.sendRedirect("home.jsp");
			}
			else {
				request.setAttribute("errorMessage", "Invalid Credentials!!!");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
