<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.User"%> 
<%@page import="service.UserService"%>
<%@page import="service.UserServiceImpl"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BidWars-Profile</title>



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
        <strong>Update Profile</strong>
    </h5>

    <div class="card-body px-lg-5 pt-0">
    <%
		UserService userService = new UserServiceImpl();
		User user = new User();
		user = userService.getUserById((int)request.getSession(false).getAttribute("currentUser"));
		String[] name = user.getName().split(" ");
	%>

        <form class="md-form" style="color: #4285F4;" action="UpdateUserServlet" method="post">


            <input type="text" id ="inputUser" name="inputUser" value="<%=user.getUserName()%>" class="form-control" >

  
            <input type="text" id="inputFName" name="inputFName" value="<%=name[0]%>" class="form-control" >

			
            <input type="text" id="inputLName" name="inputLName"  value="<%=name[1]%>" class="form-control" >

			
            <input type="email" id="inputEmail" name="inputEmail" value="<%=user.getEmail()%>" class="form-control" >
			
            <input type="text" id="inputMobile" name="inputMobile" value="<%=user.getMobileNo()%>" >
		

            <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Update</button>
        </form>
        <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0 deleteBtn" type="submit">Delete Account</button>
    </div>
</div>

       
      </div>
    </div>
  </div>
  

<div class="modal fade" id="modalDeleteUser" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Delete Account</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="DeleteUserServlet" method="post">
     
      <div class="modal-body mx-3">
       <div class="md-form mb-5">
		<input type="hidden" class="form-control" id="userId" value="<%=request.getSession().getAttribute("currentUser")%>" name="userId">
		<h3>Do You Want To Delete Your Account?</h3>
        </div>
      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button class="btn btn-success"type="submit">Yes</button>
         <button class="btn btn-danger" type="button" data-dismiss="modal">No</button>
      </div>
      </form>
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
<script type="text/javascript">
$('.deleteBtn').on('click',function(){
			
			
			
			$('#modalDeleteUser').modal('toggle');
			
		});
		
		</script>

</body>
</html>