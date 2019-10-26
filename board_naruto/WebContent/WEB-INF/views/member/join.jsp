<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post">
		<p>
			<input type="text" name="mem_id" placeholder="mem_id">
		</p>
		<p>
			<input type="text" name="mem_pw" placeholder="mem_pw">
		</p>
		<p>
			<input type="text" name="mem_name" placeholder="mem_name">
		</p>
		<p>
			<input type="date" name="mem_birth" placeholder="mem_birth">
		</p>
		<p>
			 <input type="radio" name="mem_sex" value="1" > 남
		     <input type="radio" name="mem_sex" value="2" > 여 
		</p>
		<p>
			<input type="text" name="mem_email" placeholder="mem_email">
		</p>
		<p>
			<input type="text" name="mem_pn" placeholder="mem_pn">
		</p>
		<p>
			<button>join</button>
		</p>
	</form>
</body>
</html>