<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body style="padding-top: 75px;">

  <header class="bg-primary text-white" style="height: 250px; ">
    <div class="container text-center" style="padding-bottom: 50px; padding-top: 20px;">
      <h1>Welcome to BidWars</h1>
    </div>
    <div class="row justify-content-center">
   		<form action="SearchServlet" style="width:40%;">
   		 <div class="form-row">
   		    <div class="col-3">
      		<select id="inputCategory" name="inputCategory" class="form-control">
        	<option value="">Category</option>
        	<option value="Automobile">Automobile</option>
			<option value="Arts">Arts</option>
			<option value="Sports">Sports</option>
			<option value="Gardeneing">Gardening</option>
			<option value="Electronics">Electronics</option>
			<option value="Bags">Bags</option>
			<option value="Toys">Toys</option>
     		</select>
   		 </div>
    <div class="col-7">
    		<input class="form-control mr-sm-2" type="text" id="inputKeyword" name="inputKeyword" placeholder="Enter Keywords" aria-label="Search">
      			</div>
      			<div class="col-2">
      			 <button class="btn btn-rounded btn-warning" type="submit"><i class="fa fa-search fa-1x"></i></button>
   			</div>
    		
      			  
         
        
  		</div>
      	</form>
      	</div>
  </header>
</body>
</html>