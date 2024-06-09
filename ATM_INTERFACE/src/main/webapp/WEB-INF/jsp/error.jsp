<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="../css/bootstrap.min.css">         
<script src="../js/bootstrap.min.js"></script>    
<title>Error</title>
</head>
<body>
<div><nav class="navbar navbar-expand-lg navbar-dark bg-light" style="align-content: center;">
	<h2 >ATM INTERFACE</h2>
</nav></div>

<div class="container text-center" style="margin-top: 100px">
<div class="alert alert-danger" role="alert">
 <h4>
 Something wrong happened
 <strong>${erroracc}</strong>	
 </h4>
</div>
<button type="button" class="btn btn-outline-primary" style="width: 300px"><a href="/home" style="text-decoration: none;" > <- Back </a> </button>
</div>
	
	
	
</body>
</html>	
	
