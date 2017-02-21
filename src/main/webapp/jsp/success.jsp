<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../jsp/head.jsp" %>

<c:url var="mainUrl" value="/st" />

<table align="center" style="border: none;">
	<tr>
		<th style="width: 40%; border: none;">
			<form action="${mainUrl}" method="post">	
				<ul class="form-style-1">
					<li>
						<label>Имя <span class="required">*</span></label>
						<input type="text" name="name" class="field-divided"/>
					</li>
					<%--<li>
						<label>Возраст <span class="required">*</span></label>
						<input type="text" name="age" class="field-divided"/>
					</li>--%>
	    			<li>
						<input type="submit" value="Search"/>
					</li>
				</ul>
			</form>
			<div style="position: relative;">
					<c:url var="addUrl" value="/st?new=1" />
				<a href="${addUrl}"  class="button button1" >Добавить</a>
			</div>
		</th>
	</tr>
</table>
<table  align="center" >
	<thead>
		<tr>
			<th>Name</th>
			<th>Age</th>
			<th>Action</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${students}" var="student">
		<tr>
			<td><c:out value="${student.name}" /></td>
			<td><c:out value="${student.age}" /></td>
			<td><c:out value="delete" /></td>
		</tr>
	</c:forEach>
	<c:if test="${empty students }">
		<td colspan="6">Данных нет</td>
	</c:if>

	</tbody>

</table>

<%@include file="../jsp/footer.jsp" %>
