<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>    
<title>balance</title>
</head>
<body>
<div><nav class="navbar navbar-expand-lg navbar-dark bg-light" style="align-content: center;">
	<h2 >ATM INTERFACE</h2>
</nav></div>
<h3>Balance inquiry</h3><br>
<div class="container text-center" style="margin-top: 100px">
	
	<form action="/showbalance" method="get" class="form-group">	
	<input class="form-control" type="number" name="acoountNumber" placeholder="Enter Acoount Number" required><br>
	<br><button type="submit" class="btn btn-primary" style="width: 300px" >Submit</button>
</form>
<br>
<button type="button" class="btn btn-outline-primary" style="width: 300px"><a href="/home" style="text-decoration: none;" > <- Back </a> </button>
</div>
	
	
	
</body>
</html>	
	
