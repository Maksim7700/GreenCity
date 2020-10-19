<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <form:form action="" method="post" modelAttribute="hotel">
		<p>
			<label for="name">name</label>
			<form:input path="name"/>
		</p>
		<p>
			<label for="stars">stars</label>
			<form:input  path="stars"/>
		</p>
			<input type="submit" value="add"/>
	</form:form>
        <div class="main">
            <div class="table">
                <table style="width:100%; border: 1px solid black;">
                    <tr>
                        <th>ID</th>
                        <th>name</th>
                        <th>Stars</th>
                        <th>View</th>
                    </tr>
                    <c:forEach var = "hotel" items="${hotels}">
                        <tr>
                            <th>${hotel.id}</th>
                            <th>${hotel.name}</th>
                            <th>${hotel.stars}</th>
                            <th><a href="/start-mvn/country/hotel/rooms/${hotel.id}">View</a></th>
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