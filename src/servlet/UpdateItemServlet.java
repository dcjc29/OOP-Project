package servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import controller.ItemController;
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
		
		
		item.setItemId(Integer.parseInt(request.getParameter("itemId")));
		item.setItemTitle(request.getParameter("itemTitle"));
		item.setItemCondition(Integer.parseInt(request.getParameter("itemCondition")));
		item.setItemDescription(request.getParameter("itemDescription"));
		item.setMinBid(Double.parseDouble(request.getParameter("minimumBid")));
		item.setEndDate(request.getParameter("endDate"));
		item.setStartDate(request.getParameter("startDate"));
		item.setItemDelivery(request.getParameter("itemDelivery"));
		item.setCategory(request.getParameter("itemCategory"));
		
		
		boolean message = ItemController.updateItem(item);
		PrintWriter out = response.getWriter();
	
		if(message==true) {
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Successfull' ,  'You Have Updated Item' ,  'success' );");
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
			request.getRequestDispatcher("myItems.jsp").include(request, response);
		}
	}

}
