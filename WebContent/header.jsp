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
   		<form action="SearchServlet">
   		 <div class="form-row">
   		     <div class="form-group">
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
    		<div class="form-group">
      			<input type="text" class="form-control" id="inputKeyword" name="inputKeyword" placeholder="Enter Keywords?">
   			 </div>
    		<div class="form-group">
      			<button type="submit" class="btn btn-warning">
      				<i class="fa fa-search"></i>
    			</button>
    		</div>
  		</div>
      	</form>
      	</div>
  </header>
</body>
</html>