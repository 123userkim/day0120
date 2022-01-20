<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>부서수정</h2>
	<hr>
	<form action="updateDept.do" method="post">
		부서번호 		${d.dno}<br>
		<!-- 지워버리면 안되는 이유 :  수정할 때 부서번호가 필요함 -->
		<input type="hidden" name="dno" value="${d.dno }">  
		부서이름 :		<input type="text" name="dname" value=${d.dname }><br>
		부서위치 :		<input type="text" name="dloc" value=${d.dloc }><br>
	<hr>
	<input type="submit" value="확인">
	</form>
</body>
</html>