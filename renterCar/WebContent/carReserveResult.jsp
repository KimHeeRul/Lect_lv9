<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="car.CarDAO"%>
<%@page import="car.CarDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("UTF-8"); // 한글 처리
String id = (String) session.getAttribute("id");
int no = Integer.parseInt(request.getParameter("no"));
int dday = Integer.parseInt(request.getParameter("dday"));


int qty = Integer.parseInt(request.getParameter("qty"));

CarDTO car = CarDAO.getInstance().getCarInfo(no);
if (id == null) {
%>
<script type="text/javascript">
	alert("로그인 이후 이용가능합니다.")
	location.href = "login.jsp";
</script> 
<%
}
%>
<jsp:useBean id="rbean" class="car.CarReserve">
	<jsp:setProperty name="rbean" property="*" />
</jsp:useBean>
<%
Date d1 = new Date();
Date d2 = new Date();

// 
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
d1 = sdf.parse(rbean.getRday());
d2 = sdf.parse(sdf.format(d2));
int compare = d1.compareTo(d2);
if (compare < 0) {
%>
<script type="text/javascript">
	alert("현재 시스템 날짜보다 이전 날짜는 선택할 수 없음");
	history.back();;
</script>
<%
}
rbean.setId(id);
CarDAO.getInstance().setReserveCar(rbean);
int usein = 0;
// 선택 시(1), 10,000원 추가
if(rbean.getUsein() == 1){ usein = 10000; }
int usewifi = 0;
if(rbean.getUsewifi() == 1){ usewifi = 10000; }

int totalOption = (rbean.getQty() * rbean.getDday() * (usein + usewifi));

int rantalfee=(rbean.getDday()* car.getRentalfee()*rbean.getQty());//기간 렌트비


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
				차량 렌탈이 완료되었습니다.</span>
		</nav>
		<aside id="aside"></aside>
		<div id="infoDiv">
			<form method="post" action="">
				<table
					style="background-color: #f8f9fa; border-collapse: separate; border-spacing: 20px 20px">
					<tr>
						<td align="center" colspan="2"><img width="700px"
							src="imgCar/<%=car.getImg()%>"></td>
					</tr>
					<tr>
						<td style="width: 120px">대여기간</td>
						<td><%=rbean.getDday()%>일</td>
					</tr>
					<tr>
						<td>대여일</td>
						<td>
						<%=rbean.getRday() %>
						</td>
					</tr>
					<tr>
						<td>차량 렌탈금액</td>
						<td><%=rantalfee %>원</td>
					</tr>
					<tr>
						<td>옵션 추가 금액</td>
						<td><%=totalOption %>원</td>
					</tr>
				</table>
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