<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정창</title>
</head>
<body>
	<form action="${contextPath}/member4.do?action=updateMember" method="post">
		<h2 align="center">회원 정보 수정창</h2>
		<table align="center">
			<tr>
				<td width="200"><p align="right">아이디</p></td>
				<td width="400"><input type="text" name="id" value="${memberVO.id}" disabled></td>
				<input type="hidden" name="id" value="${memberVO.id}">
			</tr>
			<tr>
				<td width="200"><p align="right">비밀번호</p></td>
				<td width="400"><input type="password" name="pwd" value="${memberVO.pwd}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이름</p></td>
				<td width="400"><input type="text" name="name" value="${memberVO.name}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">이메일</p></td>
				<td width="400"><input type="text" name="email" value="${memberVO.email}"></td>
			</tr>
			<tr>
				<td width="200"><p align="right">가입일</p></td>
				<td width="400"><input type="text" name="joinDate" value="${memberVO.joinDate}" disabled></td>
			</tr>
			<tr>
				<td width="200">&nbsp;</td>
				<td width="400">
				<input type="submit" value="수정하기">
				<input type="submit" value="다시입력">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>