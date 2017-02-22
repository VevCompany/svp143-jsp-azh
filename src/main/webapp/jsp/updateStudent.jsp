<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../jsp/head.jsp" %>

<c:url var="mainUrl" value="/st?crud=save" />


<table align="center" style="border: none;">
	<tr>
		<th style="width: 40%; border: none;">
			<form action="${mainUrl}" method="post">				
			
				<ul class="form-style-1">
					<li>
						<label>ID <span class="required">*</span></label>
						<c:out value="${student.id}"/>
						<input type="text" name="id" class="field-divided" value="${student.id}"/>
					</li>
					<li>
						<label>Имя <span class="required">*</span></label>
						<input type="text" name="name" class="field-divided" value="${student.name}"/>
					</li>
					<li>
						<label>Возраст <span class="required">*</span></label>
						<input type="text" name="age" class="field-divided" value="${student.age}"/>
					</li>
	    			<li>
						<input type="submit" value="Save"/>
					</li>
				</ul>
			</form>
		</th>
	</tr>
</table>

<%@include file="../jsp/footer.jsp" %>