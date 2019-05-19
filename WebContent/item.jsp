
<%@page import="service.ItemServiceImpl"%>
<%@page import="service.ItemService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="model.Item"%>   
<%@page import = "java.util.Base64" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BidWars-Bid Now</title>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css">
  <!-- Bootstrap core CSS -->
  <link href="css/bootstrap.min.css" rel="stylesheet">
  <!-- Material Design Bootstrap -->
  <link href="css/mdb.min.css" rel="stylesheet">
  <!-- Your custom styles (optional) -->
  <link href="css/style.css" rel="stylesheet">
</head>
<body>

<jsp:include page="navbar.jsp"/>
<jsp:include page="header.jsp"/>

 <h2 class="h1-responsive font-weight-bold text-center my-5">Place A Bid</h2>
<%
	Item item=new Item();
	int id=(Integer.parseInt(request.getParameter("id")));
	ItemService itemService = new ItemServiceImpl();
	item = itemService.getItemByID(id);

	 byte[] imgData = item.getItemIn().getBytes(1,(int) item.getItemIn().length());
	  
     
     

       String encode = Base64.getEncoder().encodeToString(imgData);
       request.setAttribute("imgBase", encode);
%>



<div class="container">
<div class="row">
<div class="col-6">

<!-- Card Regular -->
<div class="card card-cascade">
<center>
  <!-- Card image -->
  <div class="view view-cascade overlay">
    <img class="card-img-top" src="data:image/jpeg;base64,${imgBase}" alt="Card image cap">
    <a>
      <div class="mask rgba-white-slight"></div>
    </a>
  </div>

  <!-- Card content -->
  <div class="card-body card-body-cascade text-center">

    <!-- Title -->
    <h4 class="card-title"><strong>Item Details</strong></h4>
    <!-- Subtitle -->
    <h6 class="font-weight-bold indigo-text py-2"><%out.println(item.getItemTitle());%></h6>
    <!-- Text -->
    <p class="card-text"><%out.println(item.getItemDescription());%></p>
    <p class="card-text"><%out.println(item.getCategory());%></p>
	<p class="card-text"><%out.println(item.getItemCondition());%></p>
	<p class="card-text"><%out.println(item.getItemDelivery());%></p>
	<p class="card-text"><%out.println(item.getMinBid());%></p>
	<p class="card-text"><%out.println(item.getStartDate());%></p>
	<p class="card-text"><%out.println(item.getEndDate());%></p>
	<p class="card-text" hidden><%out.println(item.getItemId());%></p>

    <!-- Facebook -->
    <a type="button" class="btn-floating btn-small btn-fb"><i class="fab fa-facebook-f"></i></a>
    <!-- Twitter -->
    <a type="button" class="btn-floating btn-small btn-tw"><i class="fab fa-twitter"></i></a>
    <!-- Google + -->
    <a type="button" class="btn-floating btn-small btn-instagram"><i class="fab fa-instagram"></i></a>

  </div>

  <!-- Card footer -->
  <div class="card-footer text-muted text-center">
    BidWars
  </div>
</centre>
</div>
</div>
<div class="col-6">
<div class="card">

    <h5 class="card-header info-color white-text text-center py-4">
        <strong>Place A Bid Now</strong>
    </h5>

    <!--Card content-->
    <div class="card-body px-lg-5">

        <!-- Form -->
        <form class="md-form" style="color: #757575;" action="PlaceABidServlet" method="post">

            <div class="text-center">
                <p></p>
            </div>
             <input type="hidden" id="itemId" name="itemId" class="form-control" value="<%=item.getItemId()%>">
            <div >
			<textarea type=""  id="userMsg" name="userMsg" class="form-control" placeholder="Input Message If You Want To Customize Your Bid"></textarea>
			</div>
			<div >
       
            <input type="number" id="amount" name="amount" class="form-control" placeholder="Amount Of Bid">
			</div>

            <button class="btn btn-outline-info btn-rounded btn-block z-depth-0 my-4 waves-effect" type="submit">Bid Now</button>

        </form>

    </div>

</div>

</div>
</div>
</div>
<!-- Card Regular -->
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>
  
</body>
</html>