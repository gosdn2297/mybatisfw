<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>

</head>
<body>
	<h2>회원 정보</h2>
	<table align="center" border="1" width="700">
		<tr align="center" bgcolor="cyan">
			<th>아이디</th><th>비밀번호</th><th>이름</th><th>이메일</th><th>가입일</th><th>수정</th><th>삭제</th>
		</tr>
				<tr align="center">
					<td>${mem.id}</td>
					<td>${mem.pwd}</td>
					<td>${mem.name}</td>
					<td>${mem.email}</td>
					<td>${mem.joinDate}</td>
				</tr>	
	</table>
</body>
</html>