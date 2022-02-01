<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String log = (String) session.getAttribute("id");

request.setCharacterEncoding("utf-8");

int no = Integer.parseInt(request.getParameter("code"));

String title=request.getParameter("title");
String content=request.getParameter("content");
String id=log;
String pw=request.getParameter("pw");

BoardDAO dao=BoardDAO.getInstance();
BoardDTO board = dao.getBoard(no);

if(pw.equals(board.getPassword())){
board=new BoardDTO(title,content,id,pw);
dao.update(board,no);

%>
<script type="text/javascript">
			alert("수정이 완료됐습니다.")
		</script>
<%
response.sendRedirect("community.jsp");
}else{%>
	<script type="text/javascript">
			alert("비밀번호가 일치하지 않습니다.")
			history.back()
		</script>

	<%
}
%>

</body>
</html>