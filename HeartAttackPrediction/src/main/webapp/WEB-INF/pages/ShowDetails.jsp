<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Results Page</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>


	<div class="container">

		<h1>Logistic Regression</h1>
		<div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
			<div class="card-header">Logistic Regression</div>
			<div class="card-body">
				<h5 class="card-title">Results</h5>
				<p class="card-text">Prediction : ${ans1}</p>
				<p class="card-text">Accuracy : ${acc1}</p>
			</div>
		</div>
		
		
		<h1>Decision Tree</h1>
		<div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
			<div class="card-header">Decision Tree</div>
			<div class="card-body">
				<h5 class="card-title">Results</h5>
				<p class="card-text">Prediction : ${ans2}</p>
				<p class="card-text">Accuracy : ${acc2}</p>
			</div>
		</div>
		
		<h1>Gradient Boost</h1>
		<div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
			<div class="card-header">Gradient Boost</div>
			<div class="card-body">
				<h5 class="card-title">Results</h5>
				<p class="card-text">Prediction : ${ans3}</p>
				<p class="card-text">Accuracy : ${acc3}</p>
			</div>
		</div>
		
		<h1>Random Forest</h1>
		<div class="card text-white bg-primary mb-3" style="max-width: 18rem;">
			<div class="card-header">Random Forest</div>
			<div class="card-body">
				<h5 class="card-title">Results</h5>
				<p class="card-text">Prediction : ${ans4}</p>
				<p class="card-text">Accuracy : ${acc4}</p>
			</div>
		</div>
		
		

	</div>



</body>
</html>