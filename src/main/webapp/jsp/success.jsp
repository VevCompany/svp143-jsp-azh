<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    

<h1>Search students</h1>
<form action="st" method="post">	
	<input type="text" name="name" class="field-divided"/>
	<input type="text" name="group" class="field-divided"/>
	<input type="submit" value="Search"/>
</form>
<table>
	<thead>
		<tr>
			<th>Name</th>
			<th>Group</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${students}" var="student">
		<tr>
			<td><c:out value="${student.name}" /></td>
			<td><c:out value="${student.group}" /></td>
		</tr>
	</c:forEach>
	<c:if test="${empty students }">
		<td colspan="6">Данных нет</td>
	</c:if>

	</tbody>

</table>