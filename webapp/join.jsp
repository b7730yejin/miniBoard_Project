<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>회원가입 페이지</title>
<style type="text/css">
       h1{margin-bottom: 20px;} 
       button {border: 0; background-color: #57bfdf; padding: 7px 15px; border-radius: 4px; color: white;}
</style>
</head>
<body>
<div class="container">
	<h1>회원 가입</h1>
	<form action="/miniProject/mini/user/join" method="post">
    	<div class="form-group">
      		<label for="username">아이디:</label>
      		<input type="text" class="form-control" id="username" name="username" autofocus  placeholder="영문숫자 혼합 쵀대 8자">
    	</div>
    	<div class="form-group">
      		<label for="pwd">비밀번호:</label>
      		<input type="password" class="form-control" id="pwd" name="password"  placeholder="영문숫자 혼합 쵀대 6자">
    	</div>
    	<div class="form-group">
      		<label for="username">이메일:</label>
      		<input type="text" class="form-control" id="username" name="email">
    	</div>
    	<button>회원가입</button>
  	</form>
</div>
</body>
</html>