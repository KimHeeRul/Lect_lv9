<%@page import="car.CarDAO"%>
<%@page import="car.CarDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
int no = Integer.parseInt(request.getParameter("no"));
CarDTO car = CarDAO.getInstance().getCarInfo(no);

String id = (String) session.getAttribute("id");
if (id == null) {
%>
<script type="text/javascript">
	alert("로그인 이후 이용가능합니다.")
	location.href = "login.jsp";
</script>
<%
}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="carReserveInfo.css" type="text/css">
</head>
<body>
	<!--top-->
	<jsp:include page="top.jsp" />
	<!--top-->
	<main id="info">
		<nav id="infoNav">
			<span style="font-weight: bold; font-size: 3em; margin: auto">
				옵션 선택</span>
		</nav>
		<aside id="aside"></aside>
		<div id="infoDiv">
			<form method="post" action="carReserveResult.jsp">
				<table
					style="background-color: #f8f9fa; border-collapse: separate; border-spacing: 20px 20px">
					<tr>
						<td align="center" colspan="2"><img width="700px"
							src="imgCar/<%=car.getImg()%>"></td>
					</tr>
					<tr>
						<td style="width: 120px">대여기간</td>
						<td><select name="dday">
								<option value="1">1일</option>
								<option value="2">2일</option>
								<option value="3">3일</option>
								<option value="4">4일</option>
								<option value="5">5일</option>
								<option value="6">6일</option>
								<option value="7">7일</option>
						</select></td>
					</tr>
					<tr>
						<td>대여일</td>
						<td><input type="date" name="rday" id="today" size="15">
						</td>
					</tr>
					<tr>
						<td>보험적용</td>
						<td><select name="usein">
								<option value="1">적용(1일 1만원)</option>
								<option value="2">비적용</option>
						</select></td>
					</tr>
					<tr>
						<td>Wifi 적용</td>
						<td><select name="usewifi">
								<option value="1">적용(1일 1만원)</option>
								<option value="2">비적용</option>
						</select></td>
					</tr>
					<tr>
						<td>네비게이션 적용</td>
						<td><select name="usenavi">
								<option value="1">적용(무료)</option>
								<option value="2">비적용</option>
						</select></td>
					</tr>
					<tr>
						<td>렌탈 수량</td>
						<td><select name="qty">
								<option value="1">1</option>
								<option value="2">2</option>
								<option value="3">3</option>
						</select></td>
					</tr>
				</table>
				<div align="center">
					<input type="hidden" name="no" value="<%=no%>"> <br> <input
						type="submit" id=button
						style="background-color: #c70000; width: 310px; height: 50px; margin: auto"
						value="예약하기">
				</div>
			</form>

		</div>
		<aside id="aside2"></aside>
		<nav id="infoNav2"></nav>
	</main>
	<!--bottom-->
	<jsp:include page="bottom.jsp" />
	<!--bottom-->
</body>
</html>