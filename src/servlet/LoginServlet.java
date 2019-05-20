package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import service.Login;
import util.security;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user=new User();
		security security = new security();
		String input = request.getParameter("inputPassword");
		byte[] salt = Login.getSalt(request.getParameter("inputUser"));
		PrintWriter out = response.getWriter();
		if(salt!=null) {
			String password = security.generateHash(input,salt);
			user.setUserName(request.getParameter("inputUser"));
			user.setUserPass(password);
			user=Login.login(user);
		
			
			if(user.isValid()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentUser", user.getId());
				session.setAttribute("Name", user.getName());
				/*
				 final String ACCOUNT_SID = "ACc265771ca633ed519136dd8b70c7d638";
				    final String AUTH_TOKEN = "29d7518df35ac1e50c7e32bb4b0f5809";

			
				        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);

				        Message message = Message
				                .creator(new PhoneNumber("+94714331418"), // to
				                        new PhoneNumber("+19384448904"), // from
				                        "You Have Logged Into You Account ")
				                .create();*/

				    
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Successfull' ,  'You Have Logged In' ,  'success' );");
				out.println("});");
				out.println("</script>"); 
				request.getRequestDispatcher("home.jsp").include(request, response);
			}
			else {
				out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
				out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
				out.println("<script>");
				out.println("$(document).ready(function(){");
				out.println("swal ( 'Unsuccessfull' ,  'Invalid Password!!!' ,  'danger' );");
				out.println("});");
				out.println("</script>");
				
				request.getRequestDispatcher("login.jsp").include(request, response);
			}
			
		}
		else {
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Unsuccessfull' ,  'Invalid Username!!!' ,  'danger' );");
			out.println("});");
			out.println("</script>");
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		
		
		
		
	}

}
