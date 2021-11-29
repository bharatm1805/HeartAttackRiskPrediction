<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Hello, world!</title>
  </head>
  <body>
    <h1>Heart Attack Risk Prediction.</h1>
    <h3>Enter the details</h3>
    
    <!-- {"age","sex","cp","trtbps","chol","fbs","restecg","thalachh","exng","oldpeak","slp","caa","thall"}) -->
    
    
    <div class="container">
		<form action="getDetails">

			<!-- Age -->
			<div class="form-group">
				<label for="formGroupExampleInput">Age</label> <input
					type="text" class="form-control" id="formGroupExampleInput"
					name="age" placeholder="Enter your age" required="required">
			</div>
			
			<!-- Sex -->
			<div class="form-group">
				<label for="exampleFormControlSelect1">Sex</label> <select
					class="form-control" id="exampleFormControlSelect1" name="sex" required="required">
					<option value="1" label="Men" />
					<option value="0" label="Women" />
				</select>
			</div>
			
			<!-- Chest Pain Type -->
			<div class="form-group">
				<label for="exampleFormControlSelect1">Chest Pain Type</label> <select
					class="form-control" id="exampleFormControlSelect1" name="cp" required="required">
					<option value="0" label="Type 0" />
					<option value="1" label="Type 1" />
					<option value="2" label="Type 2" />
					<option value="3" label="Type 3" />
				</select>
			</div>
			
			<!-- Blood Pressure -->
			<div class="form-group">
				<label for="formGroupExampleInput">Blood Preasure(in mm)</label> <input
					type="text" class="form-control" id="formGroupExampleInput"
					name="trtbps" placeholder="Enter Blood Preasure(in mm)" required="required">
			</div>
			
			<!-- chol -->
			<div class="form-group">
				<label for="formGroupExampleInput">Cholestoral in mg/dl</label> <input
					type="text" class="form-control" id="formGroupExampleInput"
					name="chol" placeholder="Cholestoral in mg/dl" required="required">
			</div>
			
			
			<!-- Fast Blood Sugar -->
			<div class="form-group">
				<label for="exampleFormControlSelect1">Fast Blood Sugar</label> <select
					class="form-control" id="exampleFormControlSelect1" name="fbs" required="required">
					<option value="1" label="greater than 120" />
					<option value="0" label="lesser than 120" />
				</select>
			</div>
			
			<!-- resting electrocardiographic -->
			<div class="form-group">
				<label for="exampleFormControlSelect1">resting electrocardiographic</label> <select
					class="form-control" id="exampleFormControlSelect1" name="restecg" required="required">
					<option value="0" label="0" />
					<option value="1" label="1" />
					<option value="2" label="2" />
				</select>
			</div>
			
			<!-- maximum heart rate -->
			<div class="form-group">
				<label for="formGroupExampleInput">Maximum heart rate</label> <input
					type="text" class="form-control" id="formGroupExampleInput"
					name="thalachh" placeholder="Maximum heart rate" required="required">
			</div>
			
			<!-- exng -->
			<div class="form-group">
				<label for="exampleFormControlSelect1">Exercise induced angina</label> <select
					class="form-control" id="exampleFormControlSelect1" name="exng" required="required">
					<option value="1" label="1" />
					<option value="0" label="0" />
				</select>
			</div>
			
			
			<!-- Previous peak -->
			<div class="form-group">
				<label for="formGroupExampleInput">Previous peak</label> <input
					type="text" class="form-control" id="formGroupExampleInput"
					name="oldpeak" placeholder="Previous peak" required="required">
			</div>
			
			<!-- resting electrocardiographic -->
			<div class="form-group">
				<label for="exampleFormControlSelect1">Slope</label> <select
					class="form-control" id="exampleFormControlSelect1" name="slp" required="required">
					<option value="0" label="0" />
					<option value="1" label="1" />
					<option value="2" label="2" />
				</select>
			</div>
			
			
			<!-- caa -->
			<div class="form-group">
				<label for="exampleFormControlSelect1">Number of major vessels</label> <select
					class="form-control" id="exampleFormControlSelect1" name="caa" required="required">
					<option value="0" label="0" />
					<option value="1" label="1" />
					<option value="2" label="2" />
					<option value="3" label="3" />
					<option value="4" label="4" />
				</select>
			</div>
			
			<!-- thall -->
			<div class="form-group">
				<label for="exampleFormControlSelect1">Thal rate</label> <select
					class="form-control" id="exampleFormControlSelect1" name="thall" required="required">
					<option value="0" label="0" />
					<option value="1" label="1" />
					<option value="2" label="2" />
					<option value="3" label="3" />
					<option value="4" label="4" />
				</select>
			</div>
			

			
			<button type="submit" class="btn btn-primary mb-2">Submit Details</button>
				
		</form>
	</div>
    
    
  </body>
</html>