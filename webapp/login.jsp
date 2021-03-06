<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>로그인 페이지</title>
<style type="text/css">
    h1{margin-bottom: 20px;} 
    button {border: 0; background-color: #57bfdf; padding: 7px 15px; border-radius: 4px; color: white; margin-bottom: 10px;}
    a{margin-left: 10px; text-decoration: underline; font-size: 15px;}
    p{display: inline;}
</style>
</head>
<body>
<div class="container">
	<h1>로그인</h1>
	<form action="/miniProject/mini/user/login" method="post">
    	<div class="form-group">
      		<label for="username">아이디:</label>
      		<input type="text" class="form-control" id="username" name="username">
    	</div>
    	<div class="form-group">
      		<label for="pwd">비밀번호:</label>
      		<input type="password" class="form-control" id="pwd" name="password">
    	</div>
    	<button>로그인</button>
  	</form>
  	<hr>
  	<p>아직 회원이 아니신가요?<br>지금 가입하고 글을 작성해 보세요.</p>
  	<a href="/miniProject/mini/user/join">회원가입</a>
  	<a href="/miniProject/mini/user/find">아이디 찾기</a>
</div>
</body>
</html>