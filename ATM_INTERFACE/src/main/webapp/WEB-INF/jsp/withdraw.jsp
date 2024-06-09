<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>    
<title>Withdraw</title>
</head>
<body style="background-color: olive;">
<div><nav class="navbar navbar-expand-lg navbar-dark bg-light" style="align-content: center;">
	<h2 >ATM INTERFACE</h2>
</nav></div>

<div class="container text-center" style="margin-top: 100px">
	<h3>WITHDRAW</h3><br>
	<form action="/withdraw" method="post" class="form-group">
		<input class="form-control" type="number" step="0.0001" name="amount" placeholder="Enter Amount" required>		<br>	
	<input class="form-control" type="number" name="accountNumber" placeholder="Enter account Number" required><br>
	<br><button type="submit" class="btn btn-primary" style="width: 300px" >Withdraw</button>
</form>
<br>
<button type="button" class="btn btn-outline-primary" style="width: 300px"><a href="/home" style="text-decoration: none;" > <- Back </a> </button>
</div>
	
	
	
</body>
</html>	
	
