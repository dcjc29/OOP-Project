<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Item</title>

  <!-- Bootstrap core CSS -->
  <link href="CSS/bootstrap.min.css" rel="stylesheet">
  <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  <!-- Custom styles for this template -->
  <link href="CSS/main.css" rel="stylesheet">
  
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
  <%if(request.getSession(false).getAttribute("currentUser")!=null){%>
    <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Post An Item</h5>
            <form class="form-addItem" method="post" action="AddItemServlet" enctype="multipart/form-data">
	<div class="form-group">
		<label>Item Title</label>
		<input type="text" class="form-control" id="itemTitle" name="itemTitle">
	</div>
	<div class="form-group">
		<label>No Of Items</label> : &nbsp;<span id="Output"></span>
		<input type="range" min="1"  max="100" value="1" id="noOfItems" name="noOfItems" class="form-control">
		
	</div>
	<div class="form-group">
		<label>Item Category</label>
		<select class="form-control" id="itemCategory" name="itemCategory">
			<option>Select Category</option>
			<option value="Automobile">Automobile</option>
			<option value="Arts">Arts</option>
			<option value="Sports">Sports</option>
		</select>
	</div>
	<div class="form-group">
		<label>Item Condition</label>
		<select class="form-control" id="itemCondition" name="itemCondition">
			<option>Select Condition</option>
			<option value="1">Brand New With Tags</option>
			<option value="2">Brand New Without Tags</option>
			<option value="3">Used</option>
		</select>
	</div>
	<div class="form-group">
		<label>Item Description</label>
		<textarea class="form-control" id="itemDescription" name="itemDescription"></textarea>
	</div>
	<div class="form-group">
		<label>Item Image</label>
		<input type="file" class="form-control-file" id="itemImage" name="itemImage">
	</div>
	<div class="form-group">
		<label>Shiping Method</label>
		<select class="form-control" id="itemDelivery" name="itemDelivery">
			<option>Select Delivery Method</option>
			<option value="Air Mail Only">Air Mail Only</option>
			<option value="Sea Mail Only">Sea Mail</option>
			<option value="DHL">DHL</option>
		</select>
	</div>
	<div class="form-group">
		<label>Minimum Bid</label>
		<input type="text" class="form-control" id="minimumBid" name="minimumBid">
	</div>
	<div class="form-group">
		<label>Auction Start Date</label>
		<input type="date" class="form-control" id="startDate" name="startDate">
	</div>
	<div class="form-group">
		<label>Bid End Date</label>
		<input type="date" class="form-control" id="endDate" name="endDate">
	</div>
	<button type="submit" class="btn btn-primary">Post Item</button>
	<button type="Reset" class="btn btn-warning">Clear</button>
	<a href="home.jsp"><button type="button" class="btn btn-danger">Cancel</button></a>
            </form>
          </div>
        </div>
      </div>
<%}else{response.sendRedirect("login.jsp");} %>
<!-- Bootstrap core JavaScript -->
  <script src="jquery/jquery.min.js"></script>
  <script src="js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="jquery/jquery.easing.min.js"></script>

  <!-- Custom JavaScript for this theme -->
  <script src="JS/main.js"></script>
  
  <script type="text/javascript">
  		var slider = document.getElementById("noOfItems");
  		var output = document.getElementById("Output");
  		output.innerHTML=slider.value;
  		
  		slider.oninput = function(){
  			output.innerHTML=slider.value;
  		}
  </script>
</body>
</html>