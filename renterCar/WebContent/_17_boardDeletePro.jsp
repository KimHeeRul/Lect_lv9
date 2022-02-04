<%@page import="board.BoardDTO"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
int no = Integer.parseInt(request.getParameter("getCode"));

BoardDAO dao = BoardDAO.getInstance();
BoardDTO board = dao.getBoard(no);
dao.delete(no);
%>
<script type="text/javascript">
	alert("삭제가 완료됐습니다.") 
</script>

<%
response.sendRedirect("community.jsp");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>