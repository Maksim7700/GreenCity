
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.errors {
	color:red;
	position: fixed;
	text-align: left;
	magin-left: 10px;
}
</style>
</head>
<body>

	<form:form action="new-user" method="get" modelAttribute="userRegistration">
	<p>
		<label>Name : </label>
		<form:input path="name"/>
		<form:errors path="name" cssClass="errors" />
	</p>
	<p>
		<label>User name : </label>
		<form:input path="userName"/>
		<form:errors path="userName" cssClass="errors" />
	</p>
	<p>
		<label>Password : </label>
		<form:password path="password"/>
		
	</p>
	<p>
		<label>Country : </label>
		<form:select path="countryName">
			<form:option value="Ukraine"></form:option>
			<form:option value="Poland"></form:option>
			<form:option value="France"></form:option>
			<form:option value="Germany"></form:option>
			<form:option value="Spain"></form:option>
		</form:select>
	</p>
	<p>
		<label>Gender : </label>
		Male<form:radiobutton path="gender" value="male"/>
		Female<form:radiobutton path="gender" value="female"/>
	</p>
	<p>
		<input type="submit" value="Registration">
	</p>
	</form:form>

</body>
</html>