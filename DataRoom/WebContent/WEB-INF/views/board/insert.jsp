<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.forms{
        margin-right:1200px;
	}
	html{
		margin:0px;
	}
	div>h1{
		margin-left:50px;
	}
	
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
</head>
<body>
<div class="page-header">
  <h1>글쓰기</h1>
</div>
<div class="forms">
<form class="form-horizontal" method="post" action="/board/create">
  <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">title</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="mem_title" placeholder="title">
    </div>
  </div>
  <div class="form-group">
    <label for="contents" class="col-sm-2 control-label">content</label>
    <div class="col-sm-10">
    <textarea rows="30" cols="150" class="form-control" name="mem_content" ></textarea>
    </div>
  </div>
    <div class="form-group">
    <label for="inputEmail3" class="col-sm-2 control-label">title</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" name="mem_wrtier" placeholder="wirter">
    </div>
  </div>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-default">register</button>
    </div>
  </div>
</form>
</div>
</body>
</html>