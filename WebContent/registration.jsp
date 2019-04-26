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


  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="css/mdb.min.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="css/style.css" rel="stylesheet">
  
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
    <div class="container justify-content-center">
    
      <div class="col-sm-9 col-md-7 col-lg-6 mx-auto">
        <div class="card card-signin my-5">
  <div class="card">

    <h5 class="card-header info-color white-text text-center py-4">
        <strong>Sign up</strong>
    </h5>

    <div class="card-body px-lg-5 pt-0">

        <form class="md-form" style="color: #4285F4;" action="RegistrationServlet">


            <input type="text" id ="inputUser" name="inputUser" class="form-control" placeholder="Username">

     
            <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password">

    
            <input type="password" id="inputPasswordC" name="inputPasswordC" class="form-control" placeholder="Confirm Password">

        
            <input type="text" id="inputFName" name="inputFName" class="form-control" placeholder="First Name">


            <input type="text" id="inputLName" name="inputLName" class="form-control" placeholder="Last Name">


            <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email Address">


            <textarea class="form-control md-textarea" id="inputAddress" name="inputAddress" placeholder="Address Separeted By Comma Ex:-173/1/D,Siyane Road,Gampaha,Sri Lanka"></textarea>


            <input type="text" id="inputMobile" name="inputMobile" class="form-control" placeholder="Mobile Number">


            <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Sign Up</button>

            <div class="text-center">
                <p>or sign up with:</p>

                <a type="button" class="btn-floating btn-fb btn-sm">
                    <i class="fab fa-facebook-f"></i>
                </a>
                <a type="button" class="btn-floating btn-tw btn-sm">
                    <i class="fab fa-twitter"></i>
                </a>
                <a type="button" class="btn-floating btn-li btn-sm">
                    <i class="fab fa-linkedin-in"></i>
                </a>
                <a type="button" class="btn-floating btn-git btn-sm">
                    <i class="fab fa-github"></i>
                </a>

                <hr>

                <p>By clicking
                    <em>Sign up</em> you agree to our
                    <a href="" target="_blank">terms of service</a> and
                    <a href="" target="_blank">terms of service</a>. </p>
            </div>

        </form>
    </div>
</div>

       
      </div>
    </div>
  </div>
  






   <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>
</body>
</html>