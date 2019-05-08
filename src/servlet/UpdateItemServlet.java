package servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.Item;
import service.ItemService;
import service.ItemServiceImpl;

/**
 * Servlet implementation class UpdateItemServlet
 */
@WebServlet("/UpdateItemServlet")

public class UpdateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateItemServlet() {
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
		
		
		Item item = new Item();
		ItemService itemService = new ItemServiceImpl();
		
		item.setItemId(Integer.parseInt(request.getParameter("itemId")));
		item.setItemTitle(request.getParameter("itemTitle"));
		item.setNoOfItem(Integer.parseInt(request.getParameter("noOfItems")));
		item.setItemCondition(Integer.parseInt(request.getParameter("itemCondition")));
		item.setItemDescription(request.getParameter("itemDescription"));
		item.setMinBid(Double.parseDouble(request.getParameter("minimumBid")));
		item.setEndDate(request.getParameter("endDate"));
		item.setStartDate(request.getParameter("startDate"));
		item.setItemDelivery(request.getParameter("itemDelivery"));
		item.setCategory(request.getParameter("itemCategory"));
		
		String message = itemService.updateItem(item);
		
	
		if(message.equals("success")) {
			request.getRequestDispatcher("home.jsp").forward(request, response);
			
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("myItems.jsp").forward(request, response);
		}
	}

}
