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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<!--top-->
	<jsp:include page="top.jsp" />
	<!--top-->
	<main id="logMain">
		<nav id="loginNav">
			<h1>회원가입</h1>
			<br>
			<h3>
				레드캡투어 통합회원이 되시면 해외패키지, 레드캡렌터카의<Br> 상시할인 및 이벤트 응모가 가능합니다.
			</h3>
			<br>
			<hr class="hr1">
			<br>
		</nav>
		<aside id="aside"></aside>
		<form method="post" action="joinPro.jsp" id="loginfrm">
			 <h3>아이디</h3>
			<input type="text" id="id" name="id" style="width: 300px; height: 50px;">
			<br> 
			<span style="color: red;display: none" id="error_1">필수 정보입니다.</span> 
			 <span style="color: red;display: none" id="error1">중복된 아이디 입니다.</span>
			<br>
		<%if(session.getAttribute("error3")!=null){
       %>
       <script>document.getElementById("error1").style.display = "block";
       </script>
       <% }
        session.removeAttribute("error3");
        %>
         <h3>비밀번호</h3>
        <input type="password" name="pw"  style="width: 400px;height: 50px;">
        <span style="color: red;display: none" id="error_2">필수 정보입니다.</span>
        <span style="color: red;display: none" id="error2">8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.</span>
        <br>
        <h3>비밀번호 재확인</h3>
        <input type="password" name="pwcheck" style="width: 400px;height: 50px;">
        <span style="color: red;display: none" id="error_3">비밀번호가 일치하지 않습니다.</span>
        <br>
        <h3>이름</h3>
        <input type="text"  name="name"  style="width: 400px;height: 50px;">
        <span style="color: red;display: none" id="error_4">필수 정보입니다.</span>
        <br>
		 <input type="button" id=button style="width: 310px; height: 50px;" value="회원가입" onclick="checkJoinVal(form)">

		</form>
		<aside id="aside2"></aside>
		<nav id="loginNav2"></nav>
	</main>

	<!--bottom-->
	<jsp:include page="bottom.jsp" />
	<!--bottom-->
</body>
</html>