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

<button type="button" class="btn btn-outline-danger" onclick="location.href='addform'">고객정보입력</button>


 <c:if test="${count==0 }">
 	<h2 class="alert alert-info">등록된 고객정보가 없습니다</h2>
 	</c:if>
 
 <c:if test="${count>0 }">
 <h2 class="alert alert-info">총 ${count  }명의 고객이 있습니다</h2>
 </c:if>
 
 <hr>
 <table class="table table-bordered" style="width:700px;">
 <tr>
 	<th width="50">번호</th>
 	<th width="70">이름</th>
 	<th width="130">핸드폰번호</th>
 	<th width="100">주소</th>
 	<th width="100">가입일</th>
 	<th width="130">수정-삭제</th>
 </tr>
 
 <c:forEach var="cardto" items="${list }" varStatus="i">
 <tr>
 	<td>${i.count }</td>
 	<td>${cardto.name }</td>
 	<td>${cardto.hp }</td>
 	<td>${cardto.addr }</td>
 	<td>${cardto.gaipday }</td>
 	<td>
 		<button type="button" class="btn btn-outline-success" onclick="location.href='updateform?num=${cardto.num}'">수정</button>
 		<button type="button" class="btn btn-outline-danger" onclick="location.href='delete?num=${cardto.num}'">삭제</button>
 	</td>
 </tr>
 </c:forEach>
 </table>
 <img src="../res/image/1012ho.jpeg" style="width:300px; height:300px;">
 <img src="../res/image/1012ho2.jpeg" style="width:300px; height:300px;">
 <img src="../res/image/1012ho3.jpeg" style="width:300px; height:300px;">
 <img src="../res/image/1012ho4.jpeg" style="width:300px; height:300px;">
</body>
</html>