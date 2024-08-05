<%@ page language="java" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<h1 style="color:black;text-align:center">CRUD(CREATE,READ,UPDATE,DELETE) Without Refresh/Reload</h1>
<p style="color:black ;text-align:center"> <a href="addUser">Add User</a></p>
<c:choose>
	<c:when test="${!empty userObj}">
	
	<h1 style="color:red;text-align:center">Person List</h1>
	
	<table border="2" align="center" bgcolor:"cyan">
	<tr style="color:red;padding:15px" > 
	<th> Number</th><th> Name</th><th> Address</th><th> Email</th><th> Contact</th><th> Actions</th>
	</tr>
	<c:forEach var="user" items="${userObj}">
	<tr style="color:blue">
	<td>${user.id}</td>
	<td>${user.name}</td>
	<td>${user.addrs}</td>
	<td>${user.email}</td>
	<td>${user.contact}</td>
	<td><a href="delete?id=${user.id}" onclick="return confirm('Do You Want to delete User Permentatly')">Delete</a> &nbsp || &nbsp <a href="update?id=${user.id}">Update</a></td>
	</tr>
	
	</c:forEach>
	
	
	</table>
	
	</c:when>
</c:choose>

<center>
<h2 style="color:green;text-align:center">${SucMsg} </h2>
<a href="./">Home</a>
</center>

