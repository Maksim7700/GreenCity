<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<div class="wrapper">
    <div class="header"></div>
    <div class="content">
    <form:form action="" method="post" modelAttribute="room">
		<p>
			<label for="price">price</label>
			<form:input path="price"/>
		</p>
		<p>
			<label for="type">type</label>
			<form:input  path="type"/>
		</p>
			<input type="submit" value="add"/>
	</form:form>
        <div class="main">
            <div class="table">
                <table style="width:100%; border: 1px solid black;">
                    <tr>
                       
                        <th>ID</th>
                        <th>PRICE</th>
                        <th>TYPE</th>
                    </tr>
                    <c:forEach var = "room" items="${rooms}">
                        <tr>
                            <th>${room.id}</th>
                            <th>${room.price}</th>
                            <th>${room.type}</th>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
    <div class="footer"></div>
</div>
</body>
</html>