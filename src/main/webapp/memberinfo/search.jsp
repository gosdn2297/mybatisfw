<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>회원검색창</title>
</head>
<body>
	<form action="${contextPath}/member3.do">
		조회 : <input type="search" name="value">
		<select name="action">
			<option value="ListMembers">전체</option>
			<option value="selectMemberById">아이디</option>
			<option value="selectMemberByName">이름</option>
		</select>
		<input type="submit" value="검색">
	</form>
</body>
</html>