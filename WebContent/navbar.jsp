<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Insert title here</title>
</head>
<body>
<!--Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark indigo fixed-top scrolling-navbar">
  <a class="navbar-brand" href="home.jsp">BidWars</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-333"
    aria-controls="navbarSupportedContent-333" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent-333">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="home.jsp">Home
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Daily Deals</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="AddItem.jsp">Sell</a>
      </li>
      
        	<%if(request.getSession(false).getAttribute("currentUser")!=null){%>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">My Bidwars
        </a>
        <div class="dropdown-menu dropdown-default" aria-labelledby="navbarDropdownMenuLink-333">
          <a class="dropdown-item" href="MyBidWarsServlet?value=myBids">My Bids</a>
          <a class="dropdown-item" href="MyBidWarsServlet?value=myItems" >My Items</a>
          <a class="dropdown-item" href="MyBidWarsServlet?value=myWonItems">My Won Bids</a>
          <a class="dropdown-item" href="MyBidWarsServlet?value=myPayments">My Payments</a>
          
          <%}%>
        </div>
      </li>
    </ul>
    <ul class="navbar-nav ml-auto nav-flex-icons">
 	<%if(request.getSession(false).getAttribute("currentUser")!=null){%>
 	<li class="nav-item">
        <p>Welcome <%out.println(session.getAttribute("Name"));%></p>
      </li>
 	<%}else{ %>
 		 <li class="nav-item">
        <a class="nav-link" href="login.jsp">Log In</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="registration.jsp">Register</a>
      </li>
 	<%} %>
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-333" data-toggle="dropdown"
          aria-haspopup="true" aria-expanded="false">
          <i class="fas fa-user"></i>
        </a>
        <div class="dropdown-menu dropdown-menu-right dropdown-default"
          aria-labelledby="navbarDropdownMenuLink-333">
          	<%if(request.getSession(false).getAttribute("currentUser")!=null){%>
 			<a class="dropdown-item" href="LogoutServlet">Logout</a>
          	<a class="dropdown-item" href="#">Change Password</a>
          	<a class="dropdown-item" href="userProfile.jsp">My Profile</a>
     	<%}else{ %>
 			<a class="dropdown-item" href="login.jsp">Login For More Options</a>
 	<%} %>
 	    	 </div>
      </li>
     
    </ul>
  </div>
</nav>
<!--/.Navbar -->

 
</body>
</html>