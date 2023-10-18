<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<style>
table{
position: absolute;
top:300px;
left:300px;

}
</style>
<body>
 
 <table class="table table-dark" style="width:500px;">
 	<tr>
 		<th>이름</th>
 		<td>${dto.name }</td>		
 	</tr>
 	
 	<tr>
 		<th>좋아하는색</th>
 		<td><b style="color:${dto.color }">색</b></td>
 	</tr>
 	
 	<tr>
 		<th>취미</th>
 		<td>
 		<c:if test="${empty dto.hobby }">취미없음</c:if>
 		
 		<c:if test="${!empty dto.hobby }">
 		<c:forEach var = "hobby" items="${dto.hobby }">
 		[${hobby}]
 		</c:forEach>
 		</c:if>
 		</td>
 	</tr>
 	
 	<tr>
 		<th>좋아하는언어</th>
 		<td>${dto.language }</td>
 	</tr>
 </table>
</body>
</html>