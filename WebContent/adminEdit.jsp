<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
<%@page import="model.User"%> 
<%@page import="service.AdminService"%>
<%@page import="service.AdminServiceImpl"%> 
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
             Edit Profile
            </h3>
           
          </div>
          
          <div class="row">
            <div class="col-md-7 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <div class="clearfix">
                    





              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Edit Profile</h4>
                 




<!---------------------------------------------------------------------------------------------------------->

	<%
		AdminService adminService = new AdminServiceImpl();
		User administrator = new User();
		administrator = adminService.getAdminById((int)request.getSession(false).getAttribute("currentUser"));
	%>
  <form  method="POST" action="UpdateAdminServlet"  role="form">
                                        
                                        
                    <div class="form-group">
                           <label>User name</label>
                              <input  type="text" name="user_name" id="user_name" value=<%=administrator.getUserName() %> class="form-control" placeholder="Enter User name">
                    </div>
                                          
                    <div class="form-group">
                             <label> Email Address</label>
                              <input  type="text" name="email"  id="email" value=<%=administrator.getEmail() %> class="form-control" placeholder="Ex :example@gmail.com">
                    </div>
                                        
                                                  
                     <div class="form-group">
                             <label>Mobile No</label>
                              <input type="text" name="mobile" id="mobile" value=<%=administrator.getMobileNo() %> class="form-control" placeholder="Ex :0712345678">
                    </div>
                  
                  
                                        
             <table>                           
                                        
            <tr>


        <td colspan="2"><input type="submit" value="Update Profile" class="btn btn-gradient-primary mr-2" /> </td>
      
        <td colspan="2"><input type="reset" value="Reset" class="btn btn-gradient-primary mr-2" /></td>
      </tr>

    </table>
                                                               
    </form>
 
 


<!---------------------------------------------------------------------------------------------------------->

             
 </div>
</div>
          






















<!---------------------------------------------------------------------------------------------------------->
                                                         
                  </div>
                </div>
              </div>
            </div>
            <div class="col-md-5 grid-margin stretch-card">
              <div class="card">
                <div class="card-body">
                  <h4 class="card-title">Admistrators List</h4>
                                            <%
				
	
				ArrayList<User> list = adminService.getAllAdmins(); 
				if(list!=null){
				for(User admin:list){
	
%>
	 <tr id="<%=admin.getId()%>">
      
      
        <%out.println(admin.getUserName());%><br>
   
<%
		}
	}

%>
                              
                </div>
              </div>
            </div>
          </div>
          
          
          
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
