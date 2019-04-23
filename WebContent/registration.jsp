<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>

<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>BidWars</title>

  <!-- Bootstrap core CSS -->
  <link href="CSS/bootstrap.min.css" rel="stylesheet">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="CSS/main.css" rel="stylesheet">
  
</head>
<body>
<!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav" style="margin-bottom: 10rem">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="home.jsp">BidWars</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="login.jsp">Sign In</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="registration.jsp">Register</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#contact">My BidWars</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#contact">Help Center</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>
    <div class="container justify-content-center">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Register</h5>
            <form class="form-register" method="post" action="RegistrationServlet">
              <div class="form-label-group">
              <span style="color:red"><%=(request.getAttribute("errorMessage") == null) ? ""
 : request.getAttribute("errorMessage")%></span>
              	<label>Username</label><br>
                <input type="text" id ="inputUser" name="inputUser" class="form-control" placeholder="Username"  autofocus>
              </div>
              <div class="form-label-group">
              	<label>Password</label><br>
                <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password" >
              </div>
               <div class="form-label-group">
              	<label>Confirm Password</label><br>
                <input type="password" id="inputPasswordC" name="inputPasswordC" class="form-control" placeholder="Confirm Password" >
              </div>
                 <div class="form-label-group">
              	<label>First Name</label><br>
                <input type="text" id="inputFName" name="inputFName" class="form-control" placeholder="First Name" >
              </div>
                 <div class="form-label-group">
              	<label>Last Name</label><br>
                <input type="text" id="inputLName" name="inputLName" class="form-control" placeholder="Last Name" >
              </div>
                 <div class="form-label-group">
              	<label>Email</label><br>
                <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email" >
              </div>
                 <div class="form-label-group">
              	<label>Address</label><br>
                <textarea id="inputAddress" name="inputAddress" class="form-control"></textarea>
              </div>
                 <div class="form-label-group">
              	<label>Mobile Number</label><br>
                <input type="text" id="inputMobile" name="inputMobile" class="form-control" placeholder="Mobile Number" >
              </div>
              
           
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit" >Register</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  


</body>
</html>