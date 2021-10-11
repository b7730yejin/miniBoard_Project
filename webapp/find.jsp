<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기 페이지</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	  $('#ok').on('click', function(){
		  $.ajax({
				url: '/miniProject/mini/user/find',
				data : 'email=' + $('#email').val(),
				method: 'post',
				success : function(username){
					console.log(username);
					$('#result').text(username);
				}
			});	  
	  	});
	  
	})
</script>
</head>
<body>
<div class="container">
	<h1>아이디 찾기</h1>
    	<div class="form-group">
      		<label for="username">이메일:</label>
      		<input type="text" class="form-control" id="email" name="email">
    	</div>
  	<button id="ok">확인</button>
  	<p id="result"></p>
  	<a href="/miniProject/mini/user/login">로그인</a>
</div>
</body>
</html>