<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<a href="insertCustomer.do">등록</a>
	<h2>고객목록</h2>
	<hr>
	<table border="1" width="80%">
		<tr>
			<th>고객번호</th>
			<th>고객이름</th>
			 
		</tr>
		<!-- 상태유지를 한 list를 갖고와서, 반복문을 돌림 -->
		<c:forEach var="c" items="${list }">
			<tr>
				<td>${c.custid }</td>
				<td>
				<a href="detailCustomer.do?custid=${c.custid}">${c.name }</a>		
				<!-- 물음표뒤에 전달하는 것: 쿼리스트링 -->		
				</td>
			 
			</tr>
		</c:forEach>
	</table>
</body>
</html>