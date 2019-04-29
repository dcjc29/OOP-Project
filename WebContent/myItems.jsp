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
        <th class="th-sm">Item Id</th>
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
	 <tr>
        <td><%out.println(item.getItemId());%></td>
        <td><%%></td>
        <td><%out.println(item.getItemTitle());%></td>
        <td><%out.println(item.getNoOfItem());%></td>
        <td><%out.println(item.getItemDescription());%></td>
        <td><%out.println(item.getItemCondition());%></td>
        <td><%out.println(item.getCategory());%></td>
        <td><%out.println(item.getItemDelivery());%></td>
        <td><%out.println(item.getMinBid());%></td>
        <td><%out.println(item.getStartDate());%></td>
        <td><%out.println(item.getEndDate());%></td>
        <td>
        <button type="button" class="btn btn-warning" data-toggle="modal" data-target="#modalUpdateItem"><i class="fas fa-pencil-alt"></i></button>
		<button type="button" class="btn btn-danger" data-toggle="modal" data-target="#modalDeleteItem"><i class="fas fa-trash-alt"></i></button>
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
      <form>
      <div class="md-form mb-5">
		<input type="hidden" class="form-control" id="itemId" name="itemId">
        </div>
      <div class="modal-body mx-3">
        <div class="md-form mb-5">
        <label>Item Title</label>
		<input type="text" class="form-control" id="itemTitle" name="itemTitle">
        </div>
        <div class="md-form mb-5">
          <label>No Of Items</label> : &nbsp;<span id="Output"></span>
		<input type="range" min="1"  max="100" value="1" id="noOfItems" name="noOfItems" class="form-control">
        </div>
        <div class="md-form mb-5">
          <label>Item Category</label>
		<select class="form-control" id="itemCategory" name="itemCategory">
			<option>Select Category</option>
			<option value="Automobile">Automobile</option>
			<option value="Arts">Arts</option>
			<option value="Sports">Sports</option>
		</select>
        </div>
        <div class="md-form mb-5">
          <label>Item Condition</label>
		<select class="form-control" id="itemCondition" name="itemCondition">
			<option>Select Condition</option>
			<option value="1">Brand New With Tags</option>
			<option value="2">Brand New Without Tags</option>
			<option value="3">Used</option>
		</select>
        </div>
        <div class="md-form mb-5">
          <label>Item Description</label>
		<textarea class="form-control" id="itemDescription" name="itemDescription"></textarea>
        </div>
        <div class="md-form mb-5">
          <label>Item Image</label>
		<input type="file" class="form-control-file" id="itemImage" name="itemImage">
        </div>
        <div class="md-form mb-5">
          <label>Shiping Method</label>
		<select class="form-control" id="itemDelivery" name="itemDelivery">
			<option>Select Delivery Method</option>
			<option value="Air Mail Only">Air Mail Only</option>
			<option value="Sea Mail Only">Sea Mail</option>
			<option value="DHL">DHL</option>
		</select>
        </div>
        <div class="md-form mb-5">
          <label>Minimum Bid</label>
		<input type="text" class="form-control" id="minimumBid" name="minimumBid">
        </div>
        <div class="md-form mb-5">
        <label>Auction Start Date</label>
		<input type="date" class="form-control" id="startDate" name="startDate">
        </div>
        <div class="md-form mb-5">
        <label>Auction End Date</label>
		<input type="date" class="form-control" id="endDate" name="endDate">
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
  <div class="modal-dialog modal-notify modal-warning" role="document">
    <!--Content-->
    <div class="modal-content">
      <!--Header-->
      <div class="modal-header text-center">
        <h4 class="modal-title white-text w-100 font-weight-bold py-2">Delete Item</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true" class="white-text">&times;</span>
        </button>
      </div>

      <!--Body-->
      <div class="modal-body">
        <div class="md-form mb-5">
          <h3>Do you want to delete selected item?</h3>
        </div>
        <div class="modal-footer d-flex justify-content-center">
        <button class="btn btn-success"type="button">Yes</button>
         <button class="btn btn-danger"  data-dismiss="modal" type="button">No</button>
      </div>
 </div>
 </div>
 </div>
 </div>

<!-- Bootstrap tooltips -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.4/umd/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdbootstrap/4.7.7/js/mdb.min.js"></script>
</body>
</html>