<%@page import="board.BoardDAO"%>
<%@page import="user.UserDTO"%>
<%@page import="board.BoardDTO"%>
<%@page import="util.DBManager"%>
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
BoardDAO dao=BoardDAO.getInstance();


String title=request.getParameter("title");
String content=request.getParameter("content");
String id=log;
String pw=request.getParameter("pw");


BoardDTO board=new BoardDTO(title,content,id,pw);

dao.write(board);

response.sendRedirect("community.jsp");

%>



</body>
</html>