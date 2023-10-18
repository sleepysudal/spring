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
<h2>상품정보 출력_map</h2>
학생명:${name }<br>
자바점수:${java}점<br>
스프링점수:${spring}점<br>
제이커리점수:${jquery}점<br>

<c:set var="tot" value="${java+spring+jquery }"/>
   <c:set var="avg" value="${tot/3 }"/>
   총합계: ${tot }점 <br>
   평균: ${avg}점


</body>
</html>