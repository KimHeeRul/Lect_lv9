<%@page import="car.CarDAO"%>
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
String seq = request.getParameter("seq");

CarDAO.getInstance().removeReserve(seq);
response.sendRedirect("carReserveView.jsp");

%>


</body>
</html>