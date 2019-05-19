package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;
import model.User;

/**
 * Servlet implementation class UpdateUserServlet
 */
@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
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
		
		User user = new User();
		
		user.setId((int)request.getSession().getAttribute("currentUser"));
		user.setUserName(request.getParameter("inputUser"));
		user.setName(request.getParameter("inputFName")+" "+request.getParameter("inputLName"));
		user.setEmail(request.getParameter("inputEmail"));
		user.setMobileNo(request.getParameter("inputMobile"));
		

		
		boolean message = UserController.updateUser(user);
		
		if(message==true) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("userProfile.jsp").forward(request, response);
		}
	}

}
