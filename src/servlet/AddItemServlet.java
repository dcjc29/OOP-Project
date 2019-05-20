package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import controller.ItemController;
import model.Item;
import model.User;
import service.ItemService;
import service.ItemServiceImpl;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
@MultipartConfig
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
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
		User seller = new User();
	
		
		seller.setId((int) request.getSession(false).getAttribute("currentUser"));
		
		item.setItemTitle(request.getParameter("itemTitle"));
		item.setItemCondition(Integer.parseInt(request.getParameter("itemCondition")));
		item.setItemDescription(request.getParameter("itemDescription"));
		item.setMinBid(Double.parseDouble(request.getParameter("minimumBid")));
		item.setEndDate(request.getParameter("endDate"));
		item.setStartDate(request.getParameter("startDate"));
		item.setItemDelivery(request.getParameter("itemDelivery"));
		item.setCategory(request.getParameter("itemCategory"));
		Part part = request.getPart("itemImage");
		InputStream in = null;
		
		if(part != null ) {
			in = part.getInputStream();
		}
		boolean message = ItemController.addItem(item, in, seller);
		PrintWriter out = response.getWriter();
		
		if(message==true) {
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Successfull' ,  'You Have Added An Item' ,  'success' );");
			out.println("});");
			out.println("</script>");
			request.getRequestDispatcher("home.jsp").include(request, response);
		}
		else {
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Unsuccessfull' ,  'Something Went Wrong' ,  'danger' );");
			out.println("});");
			out.println("</script>");
			request.getRequestDispatcher("AddItem.jsp").include(request, response);
		}
	}

	
}
