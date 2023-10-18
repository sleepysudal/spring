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
 <form action="process" method="post">
 <table class="table table-dark" style="width:500px;">
 <tr>
 	<th>이름</th>
 	<td>
 	<input type="text" name="name"  class="form-control" style="width:100px;">
 	</td>
 </tr>
  <tr>
 	<th>좋아하는 색</th>
 	<td>
 	<input type="color" name="color" class="form-control" style="width:100px;">
 	</td>
 </tr>
  <tr>
 	<th>취미</th>
 	<td>
 	<label><checked><input type="checkbox" name="hobby" value="와" >와</label>
 	<label><input type="checkbox" name="hobby" value="우" >우</label>
 	<label><input type="checkbox" name="hobby" value="아" >아</label>
 	<label><input type="checkbox" name="hobby" value="하" >하</label>
 	<label><input type="checkbox" name="hobby" value="잠" >잠</label>
 	</td>
 </tr>
  <tr>
 	<th>가장 좋아하는 언어</th>
 	<td>
 	<select name="language">
 	<!--  java,html,oracle,jsp,spring 중 택일-->
 		<option value="java">java</option>
		<option value="html">html</option>
		<option value="oracle">oracle</option>
		<option value="jsp">jsp</option>
		<option value="spring">spring</option>
 	</select>
 	</td>
 </tr>
 <tr>
 	<td colspan="2" align="center">
 	<input type="submit" value="보소" class="btn btn-primary">
 	</td>
 </tr>
 </table>
 </form>
</body>
</html>