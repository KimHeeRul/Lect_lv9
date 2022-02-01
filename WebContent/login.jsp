<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String log = (String) session.getAttribute("id");
if (log != null)
	response.sendRedirect("main.jsp");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script type="text/javascript" src="validation.js"></script>
<link rel="stylesheet" href="login.css" type="text/css">
</head>
<body>
	<!--top-->
	<jsp:include page="top.jsp" />
	<!--top-->
	<main id="logMain">
		<nav id="loginNav">
			<h1>로그인</h1>
			<br>
			<h3>
				레드캡투어에 오신것을 환영합니다. <Br> 본 사이트의 정보를 이용하시려면 먼저 로그인을 해주세요.
			</h3>
			<br>
			<hr class="hr1">
			<br>
		</nav>

		<aside id="aside"></aside>
		<form method="post" action="loginPro.jsp" id="loginfrm">
			<input type="text" id="id" name="id"
				style="width: 300px; height: 50px;" placeholder="아이디"> <br>
			 <span style="color: red; display: none" id="error_1">아이디를입력해주세요</span>
			<br> <input type="text" id="pw" name="pw"
				style="width: 300px; height: 50px;" placeholder="비밀번호"> <br>
			<br>
			  <span style="color: red; display: none" id="error_2">비밀번호를 입력해주세요</span> 
			  
			  <br> <br> <input type="button" id=button style="width: 310px; height: 50px;" value="로그인"
				onclick="loginCheck(form)"><br>
				 <input type="button" id=button style="width: 310px; height: 50px;" value="회원가입"
				onclick="location.href='join.jsp'">

		</form>
		<aside id="aside2"></aside>
		<nav id="loginNav2"></nav>
	</main>

	<!--bottom-->
	<jsp:include page="bottom.jsp" />
	<!--bottom-->
</body>
</html>