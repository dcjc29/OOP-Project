
<%@page import="service.ItemServiceImpl"%>
<%@page import="service.ItemService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
<%@page import="model.Item"%>
<%@page import="model.Payment"%>
<%@page import="model.User"%>    
<%@page import="service.UserService"%>
<%@page import="service.UserServiceImpl"%>      
<%@page import = "java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<<!-- Font Awesome -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css">
<!-- Bootstrap core CSS -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
<!-- Material Design Bootstrap -->
<link href="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/css/mdb.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/addons/datatables.min.css"/>
<link rel="stylesheet" type="text/css" href="css/addons/editor.dataTables.css">

<script
  src="https://code.jquery.com/jquery-1.12.4.js"
  integrity="sha256-Qw82+bXyGq6MydymqBxNPYTaUXXq7c8v3CwiYwLLNXU="
  crossorigin="anonymous">
  </script>

 
<script type="text/javascript" src="js/addons/datatables.min.js"></script>
<script>
$(document).ready( function () {
    $('#dtBasicExample').DataTable(
    );
} );



</script>
<title>BidWars-My Payments</title>
</head>
<body>


<jsp:include page="navbar.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
 <h2 class="h1-responsive font-weight-bold text-center my-5">My Payments</h2>

<div class="wrapper-editor">

  <div class="block my-4">
    
<table id="dtBasicExample" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
      <tr>
       	<th class="th-sm">Item Title</th>
        <th class="th-sm">Item Image</th>
        <th class="th-sm">Amonut</th>
        <th class="th-sm">Card</th>
        <th class="th-sm">Seller</th>
      </tr>
    </thead>
    <tbody>
<%
	ArrayList<Payment> list =(ArrayList<Payment>) request.getAttribute("payments"); 
	if(list!=null){
		for(Payment pay: list){
			Item item = new Item();
			User user = new User();
			ItemService itemService=new ItemServiceImpl();
			item = itemService.getItemByID(pay.getItem());
			UserService userService = new UserServiceImpl();
			user = userService.getUserById(item.getSeller());
			
	 		byte[] imgData = item.getItemIn().getBytes(1,(int) item.getItemIn().length());
		    String encode = Base64.getEncoder().encodeToString(imgData);
		    request.setAttribute("imgBase", encode);
%>
	 <tr id="<%=item.getItemId()%>">
      	<td data-target="itemTitle"><%out.println(item.getItemTitle());%></td>
        <td data-targer="itemImage"> <img src="data:image/jpeg;base64,${imgBase}" height="120" width="120"></td>
        <td data-target="bidAmount"><%out.println(pay.getAmount());%></td>
        <td data-target="bidAmount"><%out.println(pay.getCard());%></td>
        <td data-target="seller"><%out.println(user.getName());%></td>
        
      </tr>
<%

		}
	}

%>
</tbody>
</table>
</div>
</div>


<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap tooltips -->


<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/js/mdb.min.js"></script>
</body>
</html>