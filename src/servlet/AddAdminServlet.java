package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.AdminService;
import service.AdminServiceImpl;
import util.security;

/**
 * Servlet implementation class AddAdminServlet
 */
@WebServlet("/AddAdminServlet")
public class AddAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAdminServlet() {
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
		
		String input = request.getParameter("password");
		byte[] salt = security.createSalt();
		String password = security.generateHash(input, salt);
		
		User user = new User();
		
		user.setUserName(request.getParameter("user_name"));
		user.setUserPass(password);
		user.setEmail(request.getParameter("email"));
		user.setMobileNo(request.getParameter("mobile"));
		
		
		AdminService adminService = new AdminServiceImpl();
		
		
		String message = adminService.addAdmin(user,salt,0);	
		if(message.equals("success")) {
			request.getRequestDispatcher("adminPanel.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("adminAdd.jsp").forward(request, response);
		}
	}
}
