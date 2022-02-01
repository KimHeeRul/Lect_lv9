<%@page import="user.UserDAO"%>
<%@page import="user.UserDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
String id = request.getParameter("id");
String pw = request.getParameter("pw");
String name = request.getParameter("name");

DBManager.getConnection();
UserDAO dao = UserDAO.getInstance();
ArrayList<UserDTO> datas = dao.getUsers();

int cnt = 0;
for (UserDTO user : datas) {
	if (id.equals(user.getId())) {
		session.setAttribute("error3", 1);
%>
		<script>
			alert("중복된 아이디가 존재합니다.");
			history.back();
		</script>
<%
		break;
	} else {
		cnt++;
	}
}

if (cnt == datas.size()) {
	UserDTO user=new UserDTO(id,pw,name);
	
	dao.addUser(user);
	
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="login.css" type="text/css">
</head>
<body>
	<!--top-->
	<jsp:include page="top.jsp" />
	<!--top-->
	<aside id="aside"></aside>
	<nav id="loginNav">
		<br> <br> <br> <br>
		<h1>회원가입 성공</h1>
		<br>
		<h3>레드캡투어에 오신것을 환영합니다.</h3>
		<br>
		<hr class="hr1">
		<br> <input type="button" id=button
			style="width: 310px; height: 50px; background-color: #f93240;"
			value="메인으로" onclick="location.href='main.jsp'">
	</nav>
	<aside id="aside2"></aside>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<!--bottom-->
	<jsp:include page="bottom.jsp" />
	<!--bottom-->
</body>
</html>


<%
}
%>