<%@page import="service.ItemServiceImpl"%>
<%@page import="service.ItemService"%>
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

var editor = new $.fn.dataTable.Editor( {
	table: '#dtBasicExample',
    
} );


</script>
  
<title>BidWars-My Bids</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<jsp:include page="header.jsp"></jsp:include>
 <h2 class="h1-responsive font-weight-bold text-center my-5">My Items</h2>

<div class="wrapper-editor">

  <div class="block my-4">
    
<table id="dtBasicExample" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
      <tr>
       	<th class="th-sm">Item Title</th>
        <th class="th-sm">Item Image</th>
        <th class="th-sm">Start date</th>
        <th class="th-sm">End Date</th>
        <th class="th-sm">Your Bid</th>
        <th class="th-sm">Your Message</th>
        <th class="th-sm">Options</th>
      </tr>
    </thead>
    <tbody>
<%
	ArrayList<Bid> list =(ArrayList<Bid>) request.getAttribute("bids"); 
	if(list!=null){
		for(Bid bid: list){
			Item item = new Item();
			ItemService itemService = new ItemServiceImpl();
			item = itemService.getItemByID(bid.getItemID());
			
	 		byte[] imgData = item.getItemIn().getBytes(1,(int) item.getItemIn().length());
		    String encode = Base64.getEncoder().encodeToString(imgData);
		    request.setAttribute("imgBase", encode);
%>
	 <tr id="<%=item.getItemId()%>">
      	<td data-target="itemTitle"><%out.println(item.getItemTitle());%></td>
        <td data-targer="itemImage"> <img src="data:image/jpeg;base64,${imgBase}" height="120" width="120"></td>
        <td data-target="startDate"><%out.println(item.getStartDate());%></td>
        <td data-target="endDate"><%out.println(item.getEndDate());%></td>
        <td data-target="bidAmount"><%out.println(bid.getBidAmount());%></td>
        <td data-target="message"><%out.println(bid.getMessage());%></td>
        
        
        <td>
        <button type="button" data-id="<%=item.getItemId()%>" data-role="update" class="btn btn-warning updateBtn" ><i class="fas fa-pencil-alt"></i></button>
		<button type="button" data-id="<%=item.getItemId()%>" class="btn btn-danger deleteBtn"><i class="fas fa-trash-alt"></i></button>
		
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


<div class="modal fade" id="modalUpdateBid" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Update Bid</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UpdateBidServlet" method="post">
     
      <div class="modal-body mx-3">
       <div class="md-form mb-5">
		<input type="hidden" class="form-control" id="itemId" name="itemId">
        </div>
         <div class="md-form mb-5">
         <label>Message</label><br><br>
		<textarea class="form-control" id="msg" name="msg" required></textarea>
        </div>
        <div class="md-form mb-5">
        <label>Bid Amount</label><br>
		<input type="text" class="form-control" id="bidAmount" name="bidAmount" required>
        </div>
      </div>
      <div class="modal-footer d-flex justify-content-center">
        <button class="btn btn-success"type="submit">Update</button>
         <button class="btn btn-danger" type="reset">Clear</button>
      </div>
      </form>
    </div>
  </div>
</div>

<div class="modal fade" id="modalDeleteBid" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Delete Bid</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="DeleteBidServlet" method="post">
     
      <div class="modal-body mx-3">
       <div class="md-form mb-5">
		<input type="hidden" class="form-control" id="iId" name="iId">
		<h3>Do You Want To Delete This Bid From Records?</h3>
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


<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/js/mdb.min.js"></script>
  
  <script type="text/javascript">
	$(document).ready(function(){
		$('.updateBtn').on('click',function(){
			var itemId=$(this).data('id');
			var msg=$('#'+itemId).children('td[data-target=message]').text();
			var bidAmount=$('#'+itemId).children('td[data-target=bidAmount]').text();
			
			
			$('#itemId').val(itemId);
			$('#message').val(msg);
			$('#bidAmount').val(bidAmount);
			$('#modalUpdateBid').modal('toggle');
			
		});
		
		$('.deleteBtn').on('click',function(){
			var id=$(this).data('id');
			
			
			$('#iId').val(id);
			console.log($('#iId').val());
			$('#modalDeleteBid').modal('toggle');
			
		});
	});

</script>
</body>
</html>