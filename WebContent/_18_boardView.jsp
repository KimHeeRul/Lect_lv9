<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = null;
String log = (String) session.getAttribute("id");
if (log != null) {//게시글 주인 체크
	id = log;
}
int no = 0;
BoardDAO dao = BoardDAO.getInstance();
no = Integer.parseInt(request.getParameter("getCode"));
if (no == 0) {
%>
<script>
	alert("잘못된 경로입니다.");
	history.back();
</script>
<%
} else {
BoardDTO board = dao.getBoard(no);
String contents = board.getContent().replace("\r\n", "<br>"); //개행문자 치환
int cnt = board.getView();
dao.viewupdate(cnt, no);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="board.css" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>

<body>
<div class="wrap">
	<!--top-->
	<jsp:include page="top.jsp" />
	<!--top-->
	<main id="boardMain">
		<nav id="boardNav"><br></nav>
		<aside id="boardaside"></aside>
		<div id="boardDiv">
			<div>
				<table border="1px solid" class="table" style="width: 1200px">
					<tr>
						<td style="width: 100px">제목</td>
						<td colspan="2"><%=board.getTitle()%></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td colspan="2"><%=board.getId()%></td>
					</tr>
					<tr>
						<td>작성일자</td>
						<td colspan="2"><%=board.getDate()%></td>
					</tr>
					<tr>
						<td>내용</td>

						<td colspan="2"
							style="word-break: break-all; height: 200px; text-align: left;"><%=contents%></td>
					</tr>


				</table>
			</div>

			<%
			if (board.getId() != null && id.equals(board.getId())) {
			%>
			<input type="button" value="수정" class="btn btn-primary"
				onclick="location.href ='_13_boardUpdateForm.jsp?getCode=<%=board.getCode()%>'">
			<input type="button" value="삭제" class="btn btn-primary"
				onclick="location.href ='_17_boardDeletePro.jsp?getCode=<%=board.getCode()%>'">

			<%
			} else {
			%>
			<input type="button" value="추천" class="btn btn-primary"
				onclick="location.href ='_19_boardlikes.jsp?getCode=<%=board.getCode()%>'">
			<%
			}

			}
			%>
		</div>
		<aside id="boardaside2"></aside>
		<nav id="boardNav2"><br></nav>
	</main>
	<!--bottom-->
	<jsp:include page="bottom.jsp" />
	<!--bottom-->
	</div>
</body>
</html>