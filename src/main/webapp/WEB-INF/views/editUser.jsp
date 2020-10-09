<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Edit Form</title>
<%@ include file="header.jsp" %>
</head>
<body>
	<div>
		<form action = "user_update" method = "post"  enctype="multipart/form-data">
	<span style= "color:red;">${error} </span> 
			<div>
				<label> Id</label>
				<input type = "text" name = "id" readonly= "readonly" value ="${u.id}" />
			</div>
			<div>
				<label> User name</label>
				<input type = "text" name = "username" value ="${u.username}"/>
			</div>
			<div>
				<label> Password</label>
				<input type = "password" name = "password" value ="${u.password}"/>
			</div>
			
			<div>
				<label> Gender</label>
				<input type = "radio" name = "gender " value ="Female"${u.gender=='Female'?'checked':'' } > Female
				<input type = "radio" name = "gender " value ="Male"${u.gender=='Male'?'checked':'' }> Male
			</div>
			<div>
				<label> Email</label>
				<input type = "email" name = "email " value ="${u.email}"/>
			</div>
			
			<div>
				<label> MobileNo</label>
				<input type = "number" name = "mobile" value ="${u.mobile}"/>
			</div>
			
			<div>
				<label> DOB</label>
				<input type = "date" name = "dob" value ="${u.dob}"/>
			</div>
			<div>
				<label> Nationality</label>
				<select name = "nationality" >
				<option value=" Nepalese" ${u.nationality=='Nepalese'?'selected':'' }>Nepalese</option>
				<option value=" Chinese" ${u.nationality=='Chinese'?'selected':'' }>Chinese</option>
				<option value=" Korean" ${u.nationality=='Korean'?'selected':'' }>Korean</option>
				</select>
			</div>
			<div>
				<label> Hobbies</label>
				<input type = "checkbox" name = "hobbies" value=" Swimming"
				<c:if test="${fn:contains(u.hobbies, 'Reading')}">checked</c:if>>Swimming
				<input type = "checkbox" name = "hobbies" value=" Singing"
				<c:if test="${fn:contains(u.hobbies, 'Singing')}">checked</c:if>>Singing
				<input type = "checkbox" name = "hobbies" value="Dancing"
				<c:if test="${fn:contains(u.hobbies, 'Dancing')}">checked</c:if>>Dancing
			</div>
			<div>
				<label> Address</label>
				<div>
					<label> City</label>
					<input type = "text" name = "address.city" value ="${u.address.city}"/>
				</div>
				<div>
					<label> Country</label>
					<input type = "text" name = "address.country" value ="${u.address.country}"/>
				</div>
				
			</div>
			
			<div class="form-group">
					<label> Upload Photo</label>
					<input type = "file" name = "file" class= "form-control"/>
				</div>
			
			
			<div>
				<label> Submit</label>
				<input type = "submit" name = "Submit"/>
			</div>
		</form>
	</div>
</body>
</html>