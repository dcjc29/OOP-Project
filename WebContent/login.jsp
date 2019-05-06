<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

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
  <title>BidWars-Login</title>
  
  <script> 
function validate()
{ 
 var username = document.getElementById('inputUser').value; 
 var password = document.getElementById('inputPassword').value;
 
 if (username==null || username=="")
 { 
 alert("Username cannot be blank"); 
 return false; 
 }
 else if(password==null || password=="")
 { 
 alert("Password cannot be blank"); 
 return false; 
 } 
}
</script> 
</head>
<body>
 <jsp:include page="navbar.jsp"></jsp:include>
    <div class="container justify-content-center">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card">

    <h5 class="card-header info-color white-text text-center py-4">
        <strong>Sign in</strong>
    </h5>
<span style="color:red"><%=(request.getAttribute("errorMessage") == null) ? ""
 : request.getAttribute("errorMessage")%></span>
    <div class="card-body px-lg-5 pt-0">

        <form class="md-form" style="color: #4285F4;" action="LoginServlet" method="post">

            <input type="text" id ="inputUser" name="inputUser" class="form-control" placeholder="Username">


            <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password">


            <div class="d-flex align-items-center justify-content-between">
                <div>
                    <a href="">Forgot password?</a>
                </div>
            </div>


            <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit" onClick="validate();">Sign in</button>

            <div class="text-center">
                <p>Not a member?
                    <a href="registration.jsp">Register</a>
                </p>

                <p>or sign in with:</p>
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
            </div>
        </form>
    </div>
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