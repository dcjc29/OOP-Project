<%@page import="java.io.OutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="model.item"%>
  
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

 <h2 class="h1-responsive font-weight-bold text-center my-5">Search Results</h2>
 
 
 
 <%
	
	ArrayList<item> list =(ArrayList<item>) request.getAttribute("items"); 
	if(list!=null){
		for(item item:list){
%>
 
<!-- Card Narrower -->
<div class="card card-cascade narrower">

  <!-- Card image -->
  <div class="view view-cascade overlay">
    <div>
    	<%
    	/*byte byteArray[]=item.getItemIn().getBytes(1,(int) item.getItemIn().length());
    	OutputStream os = response.getOutputStream();
    	os.write(byteArray);
    	os.flush();
    	os.close();*/
    	%>
    </div>
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
    <a class="btn btn-unique">Bid Item</a>
     <a class="btn btn-unique">View Item</a>

  </div>

  <!-- Card footer -->
  <div class="card-footer text-muted text-center">BidWars</div>

</div>
<!-- Card Narrower -->
	
<%

		}
	}

%>
 
 
 
 
 
 
 
 


<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
  <!-- Bootstrap tooltips -->
  <script type="text/javascript" src="js/popper.min.js"></script>
  <!-- Bootstrap core JavaScript -->
  <script type="text/javascript" src="js/bootstrap.min.js"></script>
  <!-- MDB core JavaScript -->
  <script type="text/javascript" src="js/mdb.min.js"></script>

</body>
</html>