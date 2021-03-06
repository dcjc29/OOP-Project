package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.BidController;
import model.Bid;

/**
 * Servlet implementation class UpdateBidServlet
 */
@WebServlet("/UpdateBidServlet")
public class UpdateBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBidServlet() {
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
		
		bid.setItemID( Integer.parseInt(request.getParameter("itemId")));
		bid.setBidderID((int) request.getSession(false).getAttribute("currentUser"));
		bid.setBidAmount(Double.parseDouble(request.getParameter("bidAmount")));
		bid.setMessage(request.getParameter("msg"));
		
		boolean message = BidController.updateBid(bid);
		
		
		if(message==true) {
			request.getRequestDispatcher("MyBidWarsServlet?value=myBids").forward(request, response);
			
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("MyBidWarsServlet?value=myBids").forward(request, response);
		}
		
		
	}

}
