package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.ItemController;
import model.Item;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String category = request.getParameter("inputCategory");
		String keywords = request.getParameter("inputKeyword");
		

		
		ArrayList<Item> list = new ArrayList<Item>();
		
		if(!category.isEmpty() && !keywords.isEmpty()) {
			list =ItemController.getItemsBySearch(category,keywords);
		}
		else if(category.isEmpty() && !keywords.isEmpty()) {
			list =ItemController.getItemsBySearch(keywords);
		}
		else if(!category.isEmpty() && keywords.isEmpty()) {
			list =ItemController.getItemsByCategory(category);
		}
		else {
			//Nothing Get To The List
		}
		
		request.setAttribute("items", list);
		request.getRequestDispatcher("searchResults.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
