<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
        h1{text-align : center; margin-bottom: 20px;}
        main{width:80%; margin:0 auto;}
        table{text-align: center; border:1px solid rgb(212, 211, 211);}
        th{text-align: center; background-color: #57bfdf; color: white;}
</style>
</head>
<body>
	<h1>자유게시판</h1>
	<main>
		<table class="table table-hover">
			<tr><th>번호</th><th>제목</th><th>글쓴이</th><th>조회수</th><th>작성일</th></tr>
			<c:forEach items="${list}" var="board">
				<tr>
					<td>${board.bno}</td>
					<td><a href="/miniProject/mini/board/read?bno=${board.bno}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.readcnt}</td>
					<td>${board.writeDate}</td>
				</tr>
			</c:forEach>
		</table>
		<a href="/miniProject/mini/board/write" class="btn btn-info" role="button">글쓰기</a>
		<c:if test="${username ne null }">
			<a href="/miniProject/mini/user/logout" class="btn btn-info" role="button">로그아웃</a>
		</c:if>
	</main>
	
</body>
</html>