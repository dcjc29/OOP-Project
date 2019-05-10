
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@page import="model.Item"%>
<%@page import = "java.util.Base64" %>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BidWars</title>
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

<section id="searchResults" class="bg-light">
 <div class="container">
 <h2 class="h1-responsive font-weight-bold text-center my-5">Search Results</h2>
 <div class="row">
 
 
 <%
    	ArrayList<Item> list =(ArrayList<Item>) request.getAttribute("items"); 
    	if(list!=null){
    		for(Item item:list){
    %>
    <div class="col-4">
<!-- Card Narrower -->
<div class="card card-cascade narrower">

  <!-- Card image -->
  <div class="view view-cascade overlay">
  <%
  byte[] imgData = item.getItemIn().getBytes(1,(int) item.getItemIn().length());
  String encode = Base64.getEncoder().encodeToString(imgData);
  request.setAttribute("imgBase", encode);
  %>
    <img class = "dec" src="data:image/jpeg;base64,${imgBase}" height="250" width="250">
    <a>
      <div class="mask rgba-white-slight"></div>
    </a>
  </div>

  <!-- Card content -->
  <div class="card-body card-body-cascade">

    <!-- Label -->
    <h5 class="pink-text pb-2 pt-1"><i class="fas fa-utensils"></i><%out.println(item.getCategory());%></h5>
    <!-- Title -->
    <h4 class="font-weight-bold card-title"><%out.println(item.getItemTitle());%></h4>
    <!-- Text -->
    <p class="card-text"><%out.println(item.getItemDescription());%></p>
    <!-- Button -->
  	<%if(request.getSession(false).getAttribute("currentUser")!=null){%>
	 		<a class="btn btn-unique" href="item.jsp?id=<%=item.getItemId()%>">Bid Item</a>
	 	<%}else{%>
	 		<button class="btn btn-unique" disabled>Bid Item</button>
	 	<%} %>
    
    
  </div>

  <!-- Card footer -->
  <div class="card-footer text-muted text-center" >BidWars</div>

</div>
<!-- Card Narrower -->
	</div>
<%

		}
	}

%>
 </div>
 </div>
 </section>

 
 
 
 
 
 


<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>


</body>
</html>