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
<link rel="stylesheet" href="../css/style.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
 <h2 class="alert alert-info">${title }</h2>
 <img alt="" src="${myimg1 }">
 
 <hr>
 <h2 class="alert alert-info">css적용확인</h2>
 <table style="width:200px;">
 	<tr>
 		<th>이름</th>
 		<th>휴대폰</th>
 	</tr>
 	
 	<tr>
 		<td>갑바지</td>
 		<td>010-123-4221</td>
 	</tr>
 </table>
 
</body>
</html>