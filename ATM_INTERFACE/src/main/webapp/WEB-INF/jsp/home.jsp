<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>    
<title>Home</title>
</head>
<body style="background-color: silver;">
<div><nav class="navbar navbar-expand-lg navbar-dark bg-light" style="align-content: center;">
	<h2 >ATM INTERFACE</h2>
</nav></div>

<div class="container text-center" style="margin-top: 100px">
	<h3>HOME</h3>
	<button type="button"  class="btn btn-outline-primary" style="width: 300px"><a href="/withdraw" style="text-decoration: none;" > Withdrawal ></a> </button> <br><br>
	<button type="button" class="btn btn-outline-primary" style="width: 300px"><a href="/checkbalance" style="text-decoration: none;" > Check Balance ></a> </button><br><br>
	<button type="button" class="btn btn-outline-primary" style="width: 300px"><a href="/deposit" style="text-decoration: none;" > Deposit > </a></button><br><br>
	<button type="button" class="btn btn-outline-primary" style="width: 300px"> Other </button>
	
</div>





</body>
</html>