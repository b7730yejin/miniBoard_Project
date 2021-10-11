<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${board.bno}번글 읽기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script>
$(document).ready(function() {
	$("#delete").on("click", function() {
		const $form = $("<form>").attr("action","/miniProject/mini/board/delete").attr("method","post");
		$("<input>").attr("type","hidden").attr("name","bno").val("${board.bno}").appendTo($form);
		$form.appendTo($("body")).submit();
	});
});
</script>
<style type="text/css">
       h1{margin-bottom: 20px;} 
       #delete {border: 0; background-color: #57bfdf; padding: 7px 15px; border-radius: 4px; color: white;}
       textarea{resize: vertical;}
    </style>
</head>
<body>
<div class="container">
${board}
${username}
	<h1>${board.bno}번글</h1>
	<form action="/miniProject/mini/board/write" method="post">
    	<div class="form-group">
       		<input type="text" class="form-control" id="title" name="title" value="${board.title }" disabled="disabled">
    	</div>
    	<div class="form-group">
      		<textarea class="form-control" rows="5" id="comment" disabled="disabled">${board.content }</textarea>
    	</div>
  	</form>
  	<c:if test="${username eq board.writer }">
		<a href="/miniProject/mini/board/update?bno=${board.bno}" class="btn btn-info" role="button" id="updte">글 수정</a>
		<button type="button" id="delete">글 삭제</button>
	</c:if>
  	<a href="/miniProject/mini/board/list" class="btn btn-info" role="button">글목록으로</a>
</div>
</body>
</html>