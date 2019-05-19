package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bid;
import model.User;
import service.BidService;
import service.BidServiceImpl;

/**
 * Servlet implementation class PlaceABidServlet
 */
@WebServlet("/PlaceABidServlet")
public class PlaceABidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceABidServlet() {
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
		Bid bid = new Bid();
		User user =new User();
		user.setId((int) request.getSession().getAttribute("currentUser"));
		bid.setItemID(Integer.parseInt(request.getParameter("itemId")));
		bid.setBidderID(user.getId());
		bid.setMessage(request.getParameter("userMsg"));
		bid.setBidAmount(Double.parseDouble(request.getParameter("amount")));
		
		BidService bidService = new BidServiceImpl();
		String message=bidService.placeBid(bid);
		

		if(message.equals("success")) {
			request.getRequestDispatcher("MyBidWarsServlet?value=myBids").forward(request, response);
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
	
	}

}
