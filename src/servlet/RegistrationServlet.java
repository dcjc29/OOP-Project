package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UserController;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import model.User;
import util.security;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
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
		
		security security = new security();
		
		String input = request.getParameter("inputPassword");
		byte[] salt = security.createSalt();
		String password = security.generateHash(input, salt);
		
		User user = new User();
		
		user.setUserName(request.getParameter("inputUser"));
		user.setUserPass(password);
		user.setName(request.getParameter("inputFName")+" "+request.getParameter("inputLName"));
		user.setEmail(request.getParameter("inputEmail"));
		user.setAddress(request.getParameter("inputAddress"));
		user.setMobileNo(request.getParameter("inputMobile"));
		

		
		int id = UserController.addUser(user,salt);
		PrintWriter out = response.getWriter();
		
		
		if(id!=0) {
			
			user = UserController.getUserById(id);
			
			//Mail function begins
			Properties props = new Properties();
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.socketFactory.port", "465");
			props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.port", "465");
			
			Session session1 = Session.getDefaultInstance(props,
					new javax.mail.Authenticator() {
						protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
							return new javax.mail.PasswordAuthentication("bidwarssl@gmail.com", "BidWars1234");
						}				
					}
					);
			
			try {
				Message msg = new MimeMessage(session1);
				msg.setFrom(new InternetAddress("bidwarssl@gmail.com"));
				msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(user.getEmail()));
				msg.setSubject("BidWars Registration");
				msg.setText("Welcome "+user.getName()+ " to BidWars and Thanks For Registering.You can access your Bidding Features once you login.. .\r\n" + "Thankyou");
				Transport.send(msg);
				
				
				
				
			}catch(Exception e) {
				
			}	
			
			
			//Mail function ends
			
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Successfull' ,  'You Have Registerd' ,  'success' );");
			out.println("});");
			out.println("</script>"); 
			request.getRequestDispatcher("login.jsp").include(request, response);
		}
		else {
			out.println("<script src='https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/6.11.4/sweetalert2.all.js'></script>");
			out.println("<script src='https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js'></script>");
			out.println("<script>");
			out.println("$(document).ready(function(){");
			out.println("swal ( 'Unsuccessfull' ,  'Something Went Wrong!' ,  'danger' );");
			out.println("});");
			out.println("</script>");
			request.getRequestDispatcher("registration.jsp").include(request, response);
		}
	}

}
