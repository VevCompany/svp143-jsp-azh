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
						<label>ID <span class="required">*</span></label>
						<input type="text" name="id" class="field-divided"/>
					</li>
					<li>
						<label>Имя <span class="required">*</span></label>
						<input type="text" name="name" class="field-divided"/>
					</li>
					<li>
						<label>Возраст <span class="required">*</span></label>
						<input type="text" name="age" class="field-divided"/>
					</li>
	    			<li>
						<input type="submit" value="Add"/>
					</li>
				</ul>
			</form>
		</th>
	</tr>
</table>

<%@include file="../jsp/footer.jsp" %>