<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="shortcut icon" href="static/images/logo.png" type="image/png" >
<title>${title}</title>
</head>
<body>
<h1>Search students</h1>
<form action="st" method="post">	
	<input type="text" name="name" class="field-divided"/>
	<input type="submit" value="Search"/>
</form>
<table>
	<thead>
		<tr>
			<th>Name</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${students}" var="student">
		<tr>
			<td><c:out value="${student.name}" /></td>
		</tr>
	</c:forEach>
	<c:if test="${empty students }">
		<td colspan="6">Данных нет</td>
	</c:if>

	</tbody>

</table>

</body>
</html>