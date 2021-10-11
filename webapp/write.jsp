<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기 페이지</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
     h1{margin-bottom: 20px;} 
     button{border: 0; background-color: #57bfdf; padding: 7px 15px; border-radius: 4px; color: white;}
     textarea{resize: vertical;}
</style>
</head>
<body>
<div class="container">
	<h1>글쓰기</h1>
	<form action="/miniProject/mini/board/write" method="post">
    	<div class="form-group">
      		<label for="title">제목 :</label>
      		<input type="text" class="form-control" id="title" name="title" autofocus  placeholder="제목을 입력하세요">
    	</div>
    	<div class="form-group">
      		<textarea class="form-control" rows="5" id="content" name="content"></textarea>
    	</div>
    	<button>글쓰기</button>
  	</form>
</div>
</body>
</html>
