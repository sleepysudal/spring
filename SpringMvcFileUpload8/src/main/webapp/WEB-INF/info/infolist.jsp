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

<div class="alert alert-danger">

<c:if test="${totalCount==0 }">
      <h3>저장된 정보가 없습니다</h3>
   </c:if>
   <c:if test="${totalCount>0 }">
      <h3 class="alert alert-info">${totalCount }개의 데이터가 있습니다</h3>
   </c:if>
</div>
<button type="button" class="btn btn-info btn-sm" onclick="location.href='addform'">글쓰기</button>

<hr>
<table class="table table-bordered" style="width:900px;">
<tr>
	<th width="60">번호</th>
	<th width="90">이름</th>
	<th width="100">사진</th>
	<th width="100">운전면허</th>
	<th width="150">주소</th>
	<th width="150">작성일</th>
	<th width="150">편집</th>
</tr>
<c:forEach var = "dto" items="${list }" varStatus="i">
<tr>
	<td align="center">${i.count }</td>
	<td>${dto.name }</td>
	<td>
	<c:if test="${dto.photo!='no' }">
	<img alt="" src="../photo/${dto.photo }" width="100" height="100" class="img-circle">
	</c:if>
	
	<c:if test="${dto.photo='no' }">
	<img alt="" src="../photo/go1.jpeg" width="100" height="100" class="img-circle">
	</c:if>
	</td>
	<td>${dto.driver }</td>
	<td>${dto.addr }</td>
	<td>
	<fmt:formatDate value="${dto.gaipday }" pattern="yyyy-MM-dd HH:mm"/>
	</td>
	<td>
	<button type="submit" class="btn btn-outline-success" onclick="location.href='uform?num=${dto.num}'">수정</button>
	<button type="button" class="btn btn-outline-success" onclick="location.href='delete?num=${dto.num}'">삭제</button>
	</td>
</tr>

</c:forEach>

</table>
<div style="width:900px; text-align:center;">
	<form action="list" class="d-inline-flex"> <!-- 셀렉창 옆에 인풋창 바로 붙게해주는 부트스트랩 클래스 -->
	<select name="title"  style="width:120px;" class="form-control"> 
		<option value="name" ${title=='name'?"selected":"" }>이름</option>
		<option value="addr" ${title=='addr'?"selected":"" }>주소</option>
		<option value="driver" ${title=='driver'?"selected":"" }>운전면허</option>
	</select>
	<input type="text" name="search" class="form-control" placeholder="검색단어" style="width:150px;" value="${search }">
	<button type="submit" class="btn btn-success">검색</button>
	</form>
</div>
</body>
</html>