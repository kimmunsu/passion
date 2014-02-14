<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<body>
	<h1>${message}</h1>
	<br/>
	<input type="button" onclick="location.href='/user/join';" value="회원가입" />
	<br/>
	<form action="/user/login_action">
		<input type="text" name="id">
		<input type="password" name="password">
		<input type="submit" value="로그인" />
	</form>
	<br/>
	<input type="button" onclick="location.href='/guestbook/list';" value="방명록가기" />
</body>
</html>