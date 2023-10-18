<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
div{
position: absolute;
top: 150px;
}
img{
width: 150px;
}
</style>
</head>
<body>
	<img alt="" src="../res/cos1.png" align="left" >
	
	<div class="alert alert-info">
	로그인한 아이디: ${id }<br>
	비밀번호 : ${pass }<br>
	<b>${msg }</b>
	</div>
</body>
</html>