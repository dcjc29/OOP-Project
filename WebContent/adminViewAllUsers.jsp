<%@page import="service.UserServiceImpl"%>
<%@page import="service.UserService"%>
<%@page import="service.AdminServiceImpl"%>
<%@page import="service.AdminService"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.*"%>
<%@page import="model.User"%>  
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>BidWars</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="css/adminCss/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="css/adminCss/vendors/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- inject:css -->
  <link rel="stylesheet" href="css/adminCss/css/style.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="css/adminCss/images/favicon.png" />
  <link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/css/mdb.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/addons/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="css/addons/editor.dataTables.css">


<script
  src="https://code.jquery.com/jquery-1.12.4.js"
  integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
  crossorigin="anonymous"></script>

 
<script type="text/javascript" src="js/addons/datatables.min.js"></script>








</head>
<body>

<%if(request.getSession(false).getAttribute("currentUser")!=null){%>
 	
 	
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <nav class="navbar default-layout-navbar col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
        <a href="adminPanel.jsp"><h3>BidWars</h3></a>
      </div>
     
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item nav-profile">
            <a href="#" class="nav-link">
              <div class="nav-profile-text d-flex flex-column">
                <span class="font-weight-bold mb-2">Welcome <%out.println(session.getAttribute("userName"));%></span>
                <span class="text-secondary text-small">Administrator</span>
              </div>
              <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="adminPanel.jsp">
              <span class="menu-title">Dashboard</span>
              <i class="mdi mdi-home menu-icon"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="adminAdd.jsp">
              <span class="menu-title">Add A New Admin</span>
              <i class="mdi mdi-contacts menu-icon"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="adminEdit.jsp">
              <span class="menu-title">Edit Profile</span>
              <i class="mdi mdi-pencil menu-icon"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="adminRemove.jsp">
              <span class="menu-title">Remove Admin</span>
              <i class="mdi mdi-delete menu-icon"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="adminViewAllUsers.jsp">
              <span class="menu-title">Users List</span>
              <i class="mdi mdi-table-large menu-icon"></i>
            </a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="LogoutServlet">
              <span class="menu-title">Logout</span>
              <i class="mdi mdi-logout menu-icon"></i>
            </a>
          </li>
         
         
        </ul>
      </nav>
      <!-- partial -->
      <div class="main-panel">
        <div class="content-wrapper">
          
          <div class="page-header">
            <h3 class="page-title">
              <span class="page-title-icon bg-gradient-primary text-white mr-2">
                <i class="mdi mdi-home"></i>                 
              </span>
         Users List
            </h3>
          </div>
          
          <div class="row">
            <div class="col-md-7 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <div class="clearfix">
                    <table id="dtBasicExample" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
      <tr>
        <th class="th-sm">Username</th>
        <th class="th-sm">Name</th>
        <th class="th-sm">Email</th>
        <th class="th-sm">Address</th>
        <th class="th-sm">Mobile No</th>
      </tr>
    </thead>
    <tbody>
<%
	UserService userService = new UserServiceImpl();
	
	ArrayList<User> list = userService.getAllUsers(); 
	if(list!=null){
		for(User user:list){
	
%>
	 <tr id="<%=user.getId()%>">
      
      
        <td data-target="itemTitle"><%out.println(user.getUserName());%></td>
        <td data-target="itemTitle"><%out.println(user.getName());%></td>
        <td data-target="noOfItems"><%out.println(user.getEmail());%></td>
        <td data-target="noOfItems"><%out.println(user.getAddress());%></td>
        <td data-target="itemDescription"><%out.println(user.getMobileNo());%></td>
      </tr>
<%

		}
	}

%>
</tbody>
</table>





             
        <!-- content-wrapper ends -->
        <!-- partial:partials/_footer.html -->
        <footer class="footer">
          <div class="d-sm-flex justify-content-center justify-content-sm-between">
            <span class="text-muted text-center text-sm-left d-block d-sm-inline-block">Copyright © 2019 <a href="https://www.bootstrapdash.com/" target="_blank">BSid Wars</a>. All rights reserved.</span>
           
          </div>
        </footer>
        <!-- partial -->
      </div>
      <!-- main-panel ends -->
    </div>
    <!-- page-body-wrapper ends -->
  </div>
  <!-- container-scroller -->


<div class="modal fade" id="modalDeleteAdmin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Delete Admin</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="DeleteAdminServlet" method="post">
     
      <div class="modal-body mx-3">
       <div class="md-form mb-5">
		<input type="hidden" class="form-control" id="adminId" name="adminId">
		<h3>Do You Want To Delete This Administrator?</h3>
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
<%}else{ 
	response.sendRedirect("adminLogin.jsp");
}%>
  <!-- plugins:js -->
  <script src="css/adminCss/vendors/js/vendor.bundle.base.js"></script>
  <script src="css/adminCss/vendors/js/vendor.bundle.addons.js"></script>
  <!-- endinject -->
  <!-- Plugin js for this page-->
  <!-- End plugin js for this page-->
  <!-- inject:js -->
  <script src="css/adminCss/js/off-canvas.js"></script>
  <script src="css/adminCss/js/misc.js"></script>
  <!-- endinject -->
  <!-- Custom js for this page-->
  <script src="css/adminCss/js/dashboard.js"></script>
  <!-- End custom js for this page-->



</body>

</html>
