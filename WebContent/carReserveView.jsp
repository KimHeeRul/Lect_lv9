<%@page import="car.CarReserve"%>
<%@page import="car.CarDAO"%>
<%@page import="car.CarDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String id = (String) session.getAttribute("id");
if (id == null) {
%>
<script>
	alert("로그인을 먼저 해주세요");
	location.href = 'login.jsp';
</script>
<%
} else {

ArrayList<CarReserve> list = CarDAO.getInstance().getReservelist(id);
%>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="carReserveView.css" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<div class="wrap">
		<!--top-->
		<jsp:include page="top.jsp" />
		<!--top-->
		<main id="viewmain">

			<nav id="viewNav" style="margin: auto">
				<span style="font-weight: bold; font-size: 2em;">예약리스트</span> <br>
			</nav>
			<aside id="viewaside"></aside>
			<div id="viewDiv">
				<table border="1" class="table table-striped table-hover"
					style="vertical-align: middle;">
					<tr height="40">
						<td width="150" align="center">이미지</td>
						<td width="150" align="center">이름</td>
						<td width="150" align="center">대여일</td>
						<td width="60" align="center">대여기간</td>
						<td width="100" align="center">금액</td>
						<td width="60" align="center">수량</td>
						<td width="60" align="center">보험</td>
						<td width="60" align="center">wifi</td>
						<td width="150" align="center">네비게이션</td>
						<td width="90" align="center">삭제</td>
					</tr>
					<%
					for (CarReserve bean : list) {
						String Usein = "";
						if (bean.getUsein() == 1) {
							Usein = "적용";
						} else {
							Usein = "비적용";
						}
						String wifi = "";
						if (bean.getUsewifi() == 1) {
							wifi = "적용";
						} else {
							wifi = "비적용";
						}
						String usenavi = "";
						if (bean.getUsenavi() == 1) {
							usenavi = "적용";
						} else {
							usenavi = "비적용";
						}
						
					%>
					<tr height="70">
						<td height="70" align="center"><img
							src="imgCar/<%=bean.getImg()%>" width="120" height="70"></td>
						<td width="150" align="center"><%=bean.getName()%></td>
						<td width="150" align="center"><%=bean.getRday()%></td>
						<td width="150" align="center"><%=bean.getDday()%></td>
						<td width="100" align="center"><%=bean.getPrice()%> 원</td>
						<td width="60" align="center"><%=bean.getQty()%></td>

						<td width="100" align="center"><%=Usein%></td>
						<td width="70" align="center"><%=wifi%></td>
						<td width="60" align="center"><%=usenavi%></td>
						<td width="90" align="center">
							<button class="btn btn-primary" id="Delbutton"
								onclick="location.href='carReserveDel.jsp?seq=<%=bean.getReserve_seq()%>'">삭제</button>
						</td>

					</tr>

					<%
					}
					%>


				</table>
				<script>
					$("#Delbutton").click(function() {
						if (confirm("정말 삭제하시겠습니까 ?") == true) {
							alert("삭제되었습니다");
						} else {
							return;
						}
					});
				</script>
			</div>
			<aside id="viewaside2"></aside>
			<nav id="viewNav2"></nav>
		</main>
		<!--bottom-->
		<jsp:include page="bottom.jsp" />
		<!--bottom-->

	</div>
</body>
</html>


<%
}
%>