<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>ȸ���˻�â</title>
</head>
<body>
	<form action="${contextPath}/member3.do">
		��ȸ : <input type="search" name="value">
		<select name="action">
			<option value="ListMembers">��ü</option>
			<option value="selectMemberById">���̵�</option>
			<option value="selectMemberByName">�̸�</option>
		</select>
		<input type="submit" value="�˻�">
	</form>
</body>
</html>