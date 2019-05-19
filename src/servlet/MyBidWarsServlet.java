package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BidController;
import controller.ItemController;
import model.Bid;
import model.Item;
import model.Payment;

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
			
			
			
			ArrayList<Item> list = ItemController.getItemsByUserId(id);
			
			request.setAttribute("items", list);
			request.getRequestDispatcher("myItems.jsp").forward(request, response);
		}
		
		
		if(req.equals("myBids")) {
			
		
			ArrayList<Bid> list =BidController.getBidsByUserId(id);
			
			request.setAttribute("bids", list);
			request.getRequestDispatcher("myBids.jsp").forward(request, response);
		}
		
	
		if(req.equals("myWonItems")) {
			
			
			ArrayList<Bid> list = BidController.getWonBidsByUserId(id);
			
			request.setAttribute("wonbids", list);
			request.getRequestDispatcher("myWonItems.jsp").forward(request, response);
		}
		
			if(req.equals("myPayments")) {
			
		
			ArrayList<Payment> list =BidController.getPaymentsByUserId(id);
			
			request.setAttribute("payments", list);
			request.getRequestDispatcher("myPayments.jsp").forward(request, response);
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
