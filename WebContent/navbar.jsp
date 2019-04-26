<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="home.jsp">BidWars</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
      <%if(request.getSession(false).getAttribute("currentUser")==null){%>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="login.jsp">Sign In</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="registration.jsp">Register</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#contact">Help Center</a>
          </li>
          <%}else{ %>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#contact">My BidWars</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#contact">Help Center</a>
          </li>
          	<li>Welcome <%out.println(session.getAttribute("Name"));%><br/><a href="LogoutServlet">Logout</a></li>
          <%} %>
          <li><a href="AddItem.jsp"><button type="button" class="btn btn-warning">List An Item</button></a></li>
        </ul>
      </div>
    </div>
  </nav>
</body>
</html>