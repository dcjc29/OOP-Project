package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Bid;
import service.BidService;
import service.BidServiceImpl;

/**
 * Servlet implementation class DeleteBidServlet
 */
@WebServlet("/DeleteBidServlet")
public class DeleteBidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBidServlet() {
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
		BidService bidService = new BidServiceImpl();
		
		bid.setItemID( Integer.parseInt(request.getParameter("iId")));
		bid.setBidderID((int) request.getSession(false).getAttribute("currentUser"));
		
		String message = bidService.deleteBid(bid);
		
		
		if(message.equals("success")) {
			request.getRequestDispatcher("MyBidWarsServlet?value=myBids").forward(request, response);
			
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("MyBidWarsServlet?value=myBids").forward(request, response);
		}
		
		
	}

}
