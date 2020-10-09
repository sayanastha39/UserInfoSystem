 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    	<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<%@ include file="header.jsp" %>
</head>
<body>
<security:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
	<div>
	<a href = "user_form">Add user</a>
	</div>
	</security:authorize>
	<c:if test="${!empty users}">
	<div>
		<table>
			<thead>
				<tr>
					<th>Id</th>
					<th>User Name</th>
					<th>Password</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Mobile No </th>
					<th>DOB</th>
					<th>Nationality </th>
					<th>Address </th>
					<th>Role </th>
					<th>Hobbies </th>
					<th>Actions </th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach items="${users}" var="user">
			 <tr>
					<td>${user.id}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
					<td>${user.gender}</td>
					<td>${user.mobile} </td>
					<td>${user.dob} </td>
					<td>${user.nationality}</td>
					<td>${user.address.city} , ${user.address.country} </td>
					<td> ${user.role.roleName} </td>
					<td>${user.hobbies} </td>
					<security:authorize access="hasRole('ROLE_ADMIN') and isAuthenticated()">
					<td>
					<a href = "user_edit?id=${user.id}" class= "btn btn-primary">Edit</a> 
					<a href = "user_delete?id=${user.id}" class= "btn btn-danger">Delete</a>
				   </td>
				   </security:authorize>
				</tr> 
				</c:forEach>
			</tbody>
		</table>
	</div> 
	</c:if>
</body>
</html>