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
		<form action = "user_update" method = "post">
	<span style= "color:red;">${error} </span> 
			<div>
				<label> Id</label>
				<input type = "text" name = "id" readonly= "readonly" value ="${user.id}" />
			</div>
			<div>
				<label> User name</label>
				<input type = "text" name = "username" value ="${user.username}"/>
			</div>
			<div>
				<label> Password</label>
				<input type = "password" name = "password" value ="${user.password}"/>
			</div>
			
			<div>
				<label> Gender</label>
				<input type = "radio" name = "gender " value ="Female"${user.gender=='Female'?'checked':'' } > Female
				<input type = "radio" name = "gender " value ="Male"${user.gender=='Male'?'checked':'' }> Male
			</div>
			<div>
				<label> Email</label>
				<input type = "email" name = "email " value ="${user.email}"/>
			</div>
			
			<div>
				<label> MobileNo</label>
				<input type = "number" name = "mobile" value ="${user.mobile}"/>
			</div>
			
			<div>
				<label> DOB</label>
				<input type = "date" name = "dob" value ="${user.dob}"/>
			</div>
			<div>
				<label> Nationality</label>
				<select name = "nationality" >
				<option value=" Nepalese" ${user.nationality=='Nepalese'?'selected':'' }>Nepalese</option>
				<option value=" Chinese" ${user.nationality=='Chinese'?'selected':'' }>Chinese</option>
				<option value=" Korean" ${user.nationality=='Korean'?'selected':'' }>Korean</option>
				</select>
			</div>
			<div>
				<label> Hobbies</label>
				<input type = "checkbox" name = "hobbies" value=" Swimming"
				<c:if test="${fn:contains(user.hobbies, 'Reading')}">checked</c:if>>Swimming
				<input type = "checkbox" name = "hobbies" value=" Singing"
				<c:if test="${fn:contains(user.hobbies, 'Singing')}">checked</c:if>>Singing
				<input type = "checkbox" name = "hobbies" value="Dancing"
				<c:if test="${fn:contains(user.hobbies, 'Dancing')}">checked</c:if>>Dancing
			</div>
			<div>
				<label> Address</label>
				<div>
					<label> City</label>
					<input type = "text" name = "address.city" value ="${user.address.city}"/>
				</div>
				<div>
					<label> Country</label>
					<input type = "text" name = "address.country" value ="${user.address.country}"/>
				</div>
				
			</div>
			
			<div>
				<label> Submit</label>
				<input type = "submit" name = "Submit"/>
			</div>
		</form>
	</div>
</body>
</html>