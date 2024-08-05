


<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="frm" %>

<h1 style="color:blue;text-align:center"> Student Registration Form</h1>


<frm:form action="reg" method="POST"  modelAttribute="model">
<table border="1" bgcolor="cyan" align="center">

<tr>
	<td>User Name::</td>
	<td><frm:input path="name" />
</tr>

<tr>
	<td>contact::</td>
	<td><frm:input path="contact" />
</tr>

<tr>
	<td>email::</td>
	<td><frm:input path="email" />
</tr>
<tr>
	<td>address::</td>
	<td><frm:input path="addrs" />
</tr>

<tr>
	<td><input type="submit" value ="Register"></td>
	<td><input type="reset" value ="Cancel"></td>
	
</tr>
</table>



</frm:form>



