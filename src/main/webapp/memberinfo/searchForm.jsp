<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원검색창</title>
</head>
<body>
	<h2>회원검색</h2>
	<form action="${contextPath}/member4.do">
		<input type="hidden" name="action" value="searchMember">
		이름 : <input type="text" name="name">
		이메일 : <input type="text" name="email">
		<input type="submit" value="검색">
	</form>
</body>
</html>