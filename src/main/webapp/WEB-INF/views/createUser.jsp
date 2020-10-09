<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Registration Form</title> 
<%@ include file="header.jsp" %>
</head>
<body>
	<div class="container">
	<div class="panel">
	<div class="panel-default">
	<div class="row">
	<div class="col-md-2"> </div>
	<div class="col-md-8 jumbotron">
		<form action="user_save" method = "post" class= "form-horizontal" enctype="multipart/form-data">
		<span> 
			<form:errors path="user.*" cssStyle="error"/>
		</span>
		<fieldset> 
		<label> User Registration Form </label>
		<%-- <span style= "color:red;">${error} </span> --%>
			<div class="form-group">
				<label> User name</label>
				<input type = "text" name = "username" class= "form-control"/>
			</div>
			<div class="form-group">
				<label> Password</label>
				<input type = "password" name = "password"/>
			</div>
			
			<div class="form-group">
				<label> Gender</label>
				<input type = "radio" name = "gender" value ="Female"  /> Female
				<input type = "radio" name = "gender" value ="Male" /> Male
			</div>
			<div class="form-group">
				<label> Email</label>
				<input type = "email" name = "email" class= "form-control"/>
			</div>
			
			<div class="form-group">
				<label> Mobile No</label>
				<input type = "number" name = "mobile" class= "form-control"/>
			</div>
			
			<div class="form-group">
				<label> DOB</label>
				<input type = "date" name = "dob" class= "form-control"/>
			</div>
			<div class="form-group">
				<label> Nationality</label>
				<select name = "nationality" class= "form-control">
				<option value= "Nepalese">Nepalese</option>
				<option value="Chinese">Chinese</option>
				<option value="Korean">Korean</option>
				</select>
			</div>
			<div class="form-group">
				<label> Hobbies</label>
				<input type = "checkbox" name = "hobbies" value="Swimming" class= "form-check">Swimming
				<input type = "checkbox" name = "hobbies" value="Singing" class= "form-check">Singing
				<input type = "checkbox" name = "hobbies" value="Dancing" class= "form-check">Dancing
			</div>
			<div class="form-group">
				<label> Address</label>
					<div class="form-group">
						<label> City</label>
						<input type = "text" name = "address.city" class= "form-control"/>
					</div>
					<div class="form-group">
						<label> Country</label>
						<input type = "text" name = "address.country" class= "form-control"/>
					</div>
			</div>
			<div class="form-group">
					<label> Upload Photo</label>
					<input type = "file" name = "file" class= "form-control"/>
				</div>
			
			<div class="form-group">
				<label> Submit</label>
				<input type = "submit" name = "Submit" class= "btn btn-success"/>
			</div>
			</fieldset>
		</form>
		</div>
		<div class = "col-md-2"> </div>
	</div>
	</div>
	</div>
	
	</div>
</body>
</html>