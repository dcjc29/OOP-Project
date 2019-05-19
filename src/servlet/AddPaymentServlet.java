package servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.Payment;
import service.BidService;
import service.BidServiceImpl;
import service.ItemService;
import service.ItemServiceImpl;

/**
 * Servlet implementation class AddPaymentServlet
 */
@WebServlet("/AddPaymentServlet")
public class AddPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPaymentServlet() {
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
		int itemId=Integer.parseInt(request.getParameter("itemId"));
		ItemService itemService=new ItemServiceImpl();
		Item item = new Item();
		item = itemService.getItemByID(itemId);
		Payment payment = new Payment();
		payment.setItem(itemId);
		payment.setPayee(item.getSeller());
		payment.setPayer((int)request.getSession().getAttribute("currentUser"));
		payment.setAddress(request.getParameter("address"));
		payment.setName(request.getParameter("name"));
		payment.setAmount(Double.parseDouble(request.getParameter("amount")));
		payment.setCard(request.getParameter("card"));
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		payment.setDate(date);
		
		BidService bidService =  new BidServiceImpl();
		
		String message = bidService.makePayment(payment);
		
		
		if(message.equals("success")) {
			request.getRequestDispatcher("MyBidWarsServlet?value=myPayments").forward(request, response);
			
		}
		else {
			request.setAttribute("errorMessage", message);
			request.getRequestDispatcher("MyBidWarsServlet?value=myWonItems").forward(request, response);
		}
	}

}
