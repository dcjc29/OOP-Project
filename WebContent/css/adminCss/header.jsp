<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

  <header class="bg-primary text-white">
    <div class="container text-center">
      <h1>Welcome to BidWars</h1>
    </div>
    <div class="row justify-content-center">
   		<form>
   		 <div class="form-row">
   		     <div class="form-group">
      		<select id="inputCategory" class="form-control">
        		<option selected>Category</option>
        		<option>Automobile</option>
        		<option>Arts & Crafts</option>
        		<option>Clothing</option>
        		<option>Books</option>
     		</select>
   		 	</div>
    		<div class="form-group">
      			<input type="text" class="form-control" id="inputKeyword" placeholder="Enter Keywords?">
   			 </div>
    		<div class="form-group">
      			<button type="button" class="btn btn-warning">
      				<i class="fa fa-search"></i>
    			</button>
    		</div>
  		</div>
      	</form>
      	</div>
  </header>
</body>
</html>