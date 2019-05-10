package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bid;
import model.Item;
import service.BidService;
import service.BidServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

/**
 * Servlet implementation class MyBidWarsServlet
 */
@WebServlet("/MyBidWarsServlet")
public class MyBidWarsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyBidWarsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) request.getSession(false).getAttribute("currentUser");
		String req = null;
		req = request.getParameter("value");
		if(req.equals("myItems")) {
			
			ItemService itemService = new ItemServiceImpl();
	
			ArrayList<Item> list =itemService.getItemsByUserId(id);
			
			request.setAttribute("items", list);
			request.getRequestDispatcher("myItems.jsp").forward(request, response);
		}
		
		req = request.getParameter("value");
		if(req.equals("myBids")) {
			
			BidService bidService = new BidServiceImpl();
		
			ArrayList<Bid> list =bidService.getBidsByUserId(id);
			
			request.setAttribute("bids", list);
			request.getRequestDispatcher("myBids.jsp").forward(request, response);
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
