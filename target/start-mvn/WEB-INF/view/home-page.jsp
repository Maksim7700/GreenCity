<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>	
		<base href="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Protected page</title>
	</head>
<body>

<c:if test="${pageContext.request.userPrincipal.name != null}">
			<h2>Welcome : ${pageContext.request.userPrincipal.name}
				<c:url var="logoutUrl" value="/logout" />
			     <form action="${logoutUrl}" id="logout" method="post">
			      <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />
			      <input type="submit" name="submit" value="Log Out">
			     </form>
			</c:if>

<form:form action="" method="post" modelAttribute="country">
		<p>
			<label for="country">Country</label>
			<form:input  path="country"/>
		</p>
			<input type="submit" value="add"/>
	</form:form>
<table style="width:100%; border: 1px solid black;">
                    <tr>
                        <th>ID</th>
                        <th>Country</th>
                    </tr>
                    <c:forEach var = "country" items="${countries}">
                    <tr>
                        <th>${country.id}</th>
                        <th><a href="/start-mvn/country/${country.id}">${country.country}</a></th>
                    </tr>
                    </c:forEach>


	
</body>
</html>