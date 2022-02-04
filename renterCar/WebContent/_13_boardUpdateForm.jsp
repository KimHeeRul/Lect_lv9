<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
BoardDAO dao = BoardDAO.getInstance();
int no = Integer.parseInt(request.getParameter("getCode"));
BoardDTO board = dao.getBoard(no);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="validation.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<link rel="stylesheet" href="board.css" type="text/css">
</head>
<body>
	<!--top-->
	<jsp:include page="top.jsp" />
	<!--top-->
	<main id="boardMain">
		<nav id="boardNav"><br></nav>
		<aside id="boardaside"></aside>
		<div id="boardDiv">
			<form action="_14_boardUpdatePro.jsp" method="post" name="board_frm">
				<input name="title" type="text" style="width: 700px"
					placeholder="제목을입력해주세요" value="<%=board.getTitle()%>"><br>
				<br>
				<textarea rows="30" cols="100" name="content"><%=board.getContent()%></textarea>
				<br> <br> <input type="button" value="작성하기"
					onclick="writeCheck(form)"> <input type="text"
					placeholder="비밀번호확인" name="pw"> <input type="hidden"
					name="code" value="<%=board.getCode()%>">
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