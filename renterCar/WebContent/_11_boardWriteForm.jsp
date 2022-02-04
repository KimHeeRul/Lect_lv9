<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="validation.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="board.css" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>     
	<!--top-->
	<jsp:include page="top.jsp" />
	<!--top-->
	<main id="boardMain">
		<nav id="boardNav"><br></nav>
		<aside id="boardaside"></aside>
		<div id="boardDiv">
			<form action="_12_boardWritePro.jsp" method="post" name="board_frm">
				<input name="title" type="text" style="width: 750px"
					placeholder="제목을입력해주세요"><br> <br>
				<textarea rows="30" cols="100" name="content"></textarea>
				<br> <br> <input type="button" value="작성하기" class="btn btn-primary"
					onclick="writeCheck(form)"> <input type="text"
					placeholder="비밀번호" name="pw">
			</form>
		</div>
		<aside id="boardaside2"></aside>
		<nav id="boardNav2"><br></nav>
	</main>
	<!--bottom-->
	<jsp:include page="bottom.jsp" />
	<!--bottom-->
</body>
</html>