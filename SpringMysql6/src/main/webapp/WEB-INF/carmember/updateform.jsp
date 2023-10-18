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
<body>
 <form action="update" method="post">
 <input type="hidden" name="num" value="${cardto.num }">
 	<table class="table table bordered" style="width:500px;">
 		<tr>
 			<th>이름</th>
 			<td>
 			<input type="text" name="name" class="form-control" style="width:120px;" value="${cardto.name }" required="required">
 			</td>
 		</tr>
 		
 		<tr>
 			<th>번호</th>
 			<td>
 			<input type="text" name="hp" class="form-control" style="width:120px;" value="${cardto.hp }" required="required">
 			</td>
 		</tr>
 		
 		<tr>
 			<th>주소</th>
 			<td>
 			<input type="text" name="addr" class="form-control" style="width:120px;" value="${cardto.addr }" required="required">
 			</td>
 		</tr>
 	
 		<tr>
 			<td colspan="2" align="center">
 			<button type="submit" class="btn btn-outline-primary">정보수정</button>
 			<button type="button" class="btn btn-outline-warning" onclick="location.href='list'">목록으로 돌아가기</button>
 			</td>
 		</tr>
 	</table>
 </form> 
</body>
</html>