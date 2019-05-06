package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.item;
import service.ItemService;
import service.ItemServiceImpl;

/**
 * Servlet implementation class DeleteItemServlet
 */
@WebServlet("/DeleteItemServlet")
public class DeleteItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteItemServlet() {
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
	
		item item=new item();
		ItemService itemService = new ItemServiceImpl();
		item.setItemId(Integer.parseInt(request.getParameter("iId")));
		System.out.println(item.getItemId());
		String message =itemService.deleteItem(item);
		
		if(message.equals("success")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("myItems.jsp").forward(request, response);
		}
	}

}