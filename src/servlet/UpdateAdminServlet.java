package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.AdminController;
import model.User;


/**
 * Servlet implementation class UpdateAdminServlet
 */
@WebServlet("/UpdateAdminServlet")
public class UpdateAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServlet() {
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
		User admin = new User();
		admin.setId((int) request.getSession().getAttribute("currentUser"));
		admin.setUserName(request.getParameter("user_name"));
		admin.setEmail(request.getParameter("email"));
		admin.setMobileNo(request.getParameter("mobile"));
		

		

		boolean message = AdminController.updateAdmin(admin);
		
		if(message==true) {
			request.getRequestDispatcher("adminEdit.jsp").forward(request, response);
			
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("adminEdit.jsp").forward(request, response);
		}
		
	}

}
