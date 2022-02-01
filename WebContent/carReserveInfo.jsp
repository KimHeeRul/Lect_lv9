<%@page import="car.CarDAO"%>
<%@page import="car.CarDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
int no = Integer.parseInt(request.getParameter("no"));
System.out.println(no);
CarDTO car = CarDAO.getInstance().getCarInfo(no);//차 정보 겟

int category = car.getCategory();
String temp = "";
if (category == 1) {
	temp = "소형";
} else if (category == 2) {
	temp = "중형";
} else if (category == 3) {
	temp = "대형";
}
System.out.print(car.getImg());
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
				<%=car.getName()%></span>
		</nav>
		<aside id="aside"></aside>
		<div id="infoDiv">
			<form method="post" action="">
				<table style="background-color:#f8f9fa;
				border-collapse: separate; border-spacing: 20px 20px" >
					<tr>
						<td colspan="2" align="center"><img width="700px"
							src="imgCar/<%=car.getImg()%>"></td>
					</tr>
					<tr>
						<td style="width: 120px">차량가</td>
						<td><%=car.getPrice()%></td>
					</tr>
					<tr>
						<td>분류</td>
						<td><%=temp%></td>
					</tr>
					<tr>
						<td>일 렌트료</td>
						<td><%=car.getRentalfee() %></td>
					</tr>
					<tr>
						<td>연료</td>
						<td><%=car.getFuel() %></td>
					</tr>
					<tr>
						<td>제조사</td>
						<td><%=car.getCompany()%></td>
					</tr>
				</table>
			</form>
			<br>
				 <input type="button" id=button style="background-color:#c70000; width: 310px;
				  height: 50px; margin: auto" value="렌탈 신청" onclick="location.href='carOptionSelect.jsp?no=<%=car.getNo()%>'">
		</div>	
		<aside id="aside2"></aside>
		<nav id="infoNav2"></nav>
	</main>
	<!--bottom-->
	<jsp:include page="bottom.jsp" />
	<!--bottom-->
</body>
</html>