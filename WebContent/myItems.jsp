<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.item"%>    

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
  crossorigin="anonymous"></script>

 
<script type="text/javascript" src="js/addons/datatables.min.js"></script>
<script type="text/javascript" src="js/addons/dataTables.editor.js"></script>


<script>
$(document).ready( function () {
    $('#dtBasicExample').DataTable(
    );
} );

var editor = new $.fn.dataTable.Editor( {
	table: '#dtBasicExample',
    
} );


</script>
  
  <title>BidWars-My Items</title>
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
        <th class="th-sm">Item Image</th>
        <th class="th-sm">Item Title</th>
        <th class="th-sm">No Of Items</th>
        <th class="th-sm">Description</th>
        <th class="th-sm">Condition</th>
        <th class="th-sm">Category</th>
        <th class="th-sm">Delivery Method</th>
        <th class="th-sm">Minimum Bid</th>
        <th class="th-sm">Start date</th>
        <th class="th-sm">End Date</th>
        <th class="th-sm">Options</th>
      </tr>
    </thead>
    <tbody>
<%
	
	ArrayList<item> list =(ArrayList<item>) request.getAttribute("items"); 
	if(list!=null){
		for(item item:list){
%>
	 <tr id="<%=item.getItemId()%>">
        <td><%%></td>
        <td data-target="itemTitle"><%out.println(item.getItemTitle());%></td>
        <td data-target="noOfItems"><%out.println(item.getNoOfItem());%></td>
        <td data-target="itemDescription"><%out.println(item.getItemDescription());%></td>
        <td data-target="itemCondition"><%out.println(item.getItemCondition());%></td>
        <td data-target="category"><%out.println(item.getCategory());%></td>
        <td data-target="itemDelivery"><%out.println(item.getItemDelivery());%></td>
        <td data-target="minBid"><%out.println(item.getMinBid());%></td>
        <td data-target="startDate"><%out.println(item.getStartDate());%></td>
        <td data-target="endDate"><%out.println(item.getEndDate());%></td>
        
        
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


<div class="modal fade" id="modalUpdateItem" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Update Item</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="UpdateItemServlet" method="post">
     
      <div class="modal-body mx-3">
       <div class="md-form mb-5">
		<input type="hidden" class="form-control" id="itemId" name="itemId">
        </div>
        <div class="md-form mb-5">
        <label>Item Title</label><br>
		<input type="text" class="form-control" id="itemTitle" name="itemTitle" required>
        </div>
        <div class="md-form mb-5">
          <label>No Of Items</label>
		<input type="text" min="1"  max="100" value="1" id="noOfItems" name="noOfItems" class="form-control" required>
        </div>
        <div class="md-form mb-5">
          <label>Item Category</label><br><br>
		<select class="form-control" id="itemCategory" name="itemCategory" required>
			<option>Select Category</option>
			<option value="Automobile">Automobile</option>
			<option value="Arts">Arts</option>
			<option value="Sports">Sports</option>
		</select>
        </div>
        <div class="md-form mb-5">
          <label>Item Condition</label><br><br>
		<select class="form-control" id="itemCondition" name="itemCondition" required>
			<option selected>Select Condition</option>
			<option value="1">Brand New With Tags</option>
			<option value="2">Brand New Without Tags</option>
			<option value="3">Used</option>
		</select>
        </div>
        <div class="md-form mb-5">
          <label>Item Description</label><br><br>
		<textarea class="form-control" id="itemDescription" name="itemDescription" required></textarea>
        </div>
        <div class="md-form mb-5">
          <label>Shiping Method</label><br><br>
		<select class="form-control" id="itemDelivery" name="itemDelivery" required>
			<option>Select Delivery Method</option>
			<option value="Air">Air Mail Only</option>
			<option value="Sea">Sea Mail</option>
			<option value="DHL">DHL</option>
		</select>
        </div>
        <div class="md-form mb-5">
          <label>Minimum Bid</label><br>
		<input type="text" class="form-control" id="minimumBid" name="minimumBid" required>
        </div>
        <div class="md-form mb-5">
        <label>Auction Start Date</label><br>
		<input type="date" class="form-control" id="startDate" name="startDate" required>
        </div>
        <div class="md-form mb-5">
        <label>Auction End Date</label><br>
		<input type="date" class="form-control" id="endDate" name="endDate" required>
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


<div class="modal fade" id="modalDeleteItem" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header text-center">
        <h4 class="modal-title w-100 font-weight-bold">Delete Item</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <form action="DeleteItemServlet" method="post">
     
      <div class="modal-body mx-3">
       <div class="md-form mb-5">
		<input type="hidden" class="form-control" id="iId" name="iId">
		<h3>Do You Want To Delete This Item From Records?</h3>
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
 

<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/js/mdb.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$('.updateBtn').on('click',function(){
			var id=$(this).data('id');
			var itemTitle=$('#'+id).children('td[data-target=itemTitle]').text();
			var noOfItems=$('#'+id).children('td[data-target=noOfItems]').text();
			var itemDescription=$('#'+id).children('td[data-target=itemDescription]').text();
			var itemCondition=$('#'+id).children('td[data-target=itemCondition]').text();
			var category=$('#'+id).children('td[data-target=category]').text();
			var itemDelivery=$('#'+id).children('td[data-target=itemDelivery]').text();
			var minBid=$('#'+id).children('td[data-target=minBid]').text();
			
			$('#itemId').val(id);
			$('#itemTitle').val(itemTitle);
			$('#noOfItems').val(noOfItems);
			$('#minimumBid').val(minBid);
			$('#itemDelivery').val(itemDelivery);
			$('#itemDescription').val(itemDescription);
           	$("#itemCategory option[value="+category+"]").attr('selected','selected');
           	$("#itemDelivery option[value="+itemDelivery+"]").attr('selected','selected');
            $("#itemCondition option[value="+itemCondition+"]").attr('selected','selected');
			$('#modalUpdateItem').modal('toggle');
			
		});
		
		$('.deleteBtn').on('click',function(){
			var id=$(this).data('id');
			
			
			$('#iId').val(id);
			console.log($('#iId').val());
			$('#modalDeleteItem').modal('toggle');
			
		});
	});

</script>
</body>
</html>