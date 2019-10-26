<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${param.msg}</h1>
	<form method="post">
		<p>
		<input type="text" name="mem_id" placeholder="UID">
		</p>
		<p>
		<input type="text" name="mem_pw" placeholder="UPW">
		</p>
		<p>
			<button>Login</button>
		</p>
	</form>
	<a href="join">join</a>
</body>
</html>