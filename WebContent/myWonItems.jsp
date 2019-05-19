
<%@page import="service.ItemServiceImpl"%>
<%@page import="service.ItemService"%>
<%@page import="model.User"%>
<%@page import="service.UserServiceImpl"%>
<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*"%>
<%@page import="model.Item"%>   
<%@page import="model.Bid"%>  
<%@page import = "java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Font Awesome -->
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
<title>BidWars-My Winnings</title>
</head>
<body>


<jsp:include page="navbar.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
 <h2 class="h1-responsive font-weight-bold text-center my-5">My Winnings</h2>

<div class="wrapper-editor">

  <div class="block my-4">
    
<table id="dtBasicExample" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
      <tr>
       	<th class="th-sm">Item Title</th>
        <th class="th-sm">Item Image</th>
        <th class="th-sm">Amonut</th>
        <th class="th-sm">Seller</th>
        <th class="th-sm">Options</th>
      </tr>
    </thead>
    <tbody>
<%
	ArrayList<Bid> list =(ArrayList<Bid>) request.getAttribute("wonbids"); 
	if(list!=null){
		for(Bid bid: list){
			Item item = new Item();
			User user = new User();
			ItemService itemService = new ItemServiceImpl();
			item = itemService.getItemByID(bid.getItemID());
			UserService userService = new UserServiceImpl();
			user = userService.getUserById(item.getSeller());
			
	 		byte[] imgData = item.getItemIn().getBytes(1,(int) item.getItemIn().length());
		    String encode = Base64.getEncoder().encodeToString(imgData);
		    request.setAttribute("imgBase", encode);
%>
	 <tr id="<%=item.getItemId()%>">
      	<td data-target="itemTitle"><%out.println(item.getItemTitle());%></td>
        <td data-targer="itemImage"> <img src="data:image/jpeg;base64,${imgBase}" height="120" width="120"></td>
        <td data-target="bidAmount"><%out.println(bid.getBidAmount());%></td>
        <td data-target="seller"><%out.println(user.getName());%></td>
        
        
        <td>
        <button type="button" data-id="<%=item.getItemId()%>"  class="btn btn-warning paymentBtn" ><i class="fas fa-cash-alt"></i>Pay Now</button>
		
        </td>
      </tr>
<%

		}
	}

%>
</tbody>
</table>
</div>
</div>

<div class="modal fade" id="modalPayment" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Make A Payment</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="AddPaymentServlet" method="post">
     
      <div class="modal-body mx-3">
       <div class="md-form mb-5">
		<input type="hidden" class="form-control" id="itemId" name="itemId">
        </div>
         <div class="md-form mb-5">
          <label>Name</label><br>
		<input type="text" class="form-control" id="name" name="name" required>
        </div>
         <div class="md-form mb-5">
          <label>Address</label><br>
		<input type="text" class="form-control" id="address" name="address" required>
        </div>
        <div class="md-form mb-5">
          <label>Card No</label><br>
		<input type="text" class="form-control" id="card" name="card" required>
        </div>
        <div class="md-form mb-5">
          <label>Amount</label><br>
		<input type="text" class="form-control" id="amount" name="amount" required>
        </div>

      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button class="btn btn-success"type="submit">Pay Now</button>
      </div>
      </form>
    </div>
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

<script type="text/javascript">
	$(document).ready(function(){
		$('.paymentBtn').on('click',function(){
			var id=$(this).data('id');
			var amount=$('#'+id).children('td[data-target=bidAmount]').text();
			
			$('#itemId').val(id);
			$('#amount').val(amount);
			$('#modalPayment').modal('toggle');
			
		});
	});
	
	
		
</script>

</body>
</html>