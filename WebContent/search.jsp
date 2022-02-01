<%@page import="car.CarDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="car.CarDAO"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
request.setCharacterEncoding("utf-8");
String key = request.getParameter("input");

DBManager.getConnection();
CarDAO dao = CarDAO.getInstance();
ArrayList<CarDTO> SearchList = dao.getSearch(key);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="reservation.css" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
</head>
<body>
	<!--top-->
	<jsp:include page="top.jsp" />
	<!--top-->
	<main id="search">
		<nav id="reservNav">
			<br> <br>
		</nav>
		<aside id="reservaside"></aside>
		<%
		if (SearchList.size() == 0) {
		%>
		<div id="reservDiv">
			<span style="font-weight: bold; font-size: 3em;">검색 결과가 없습니다.</span>
		<form action="search.jsp">
			<div class="input-group mb-3" co>
				<input type="text" class="form-control" name="input"
					placeholder="검색">
				<button class="btn btn-outline-secondary"
					style="background-color: #19ce60; color: white;" type="submit"
					id="button-addon2">검색</button>
			</div>
		</form>
		</div>
		<%
		} else {
		%>
		<div id="reservDiv" style="width: 1000px">
		<span style="font-weight: bold;  font-size: 2.5em;">검색 결과</span>
		<form action="search.jsp">
			<div class="input-group mb-3" co>
				<input type="text" class="form-control" name="input"
					placeholder="검색">
				<button class="btn btn-outline-secondary"
					style="background-color: #19ce60; color: white;" type="submit"
					id="button-addon2">검색</button>
			</div>
		</form>
		<table style="border-collapse: separate; border-spacing: 0 20px">
			<%
			for (int i = 0; i < SearchList.size(); i++) {
			%>
			<tr height="200px">
				<td align="center" width="333"><a href="#"> <img
						src="imgCar/<%=SearchList.get(i).getImg()%>" width="300px"
						height="200px">
				</a></td>
				<td>차이름:<sapn style="font-weight: bold;"> <%=SearchList.get(i).getName()%>
					</sapn>
					<p style="font-weight: bold;">
						설명:
						<%=SearchList.get(i).getInfo()%>
					</p>
				</td>
			</tr>
			<%
			}
			%>
		</table>
		</div>
		<%
		}
		%>
		<aside id="reservaside2"></aside>
		<nav id=reservNav2>
			<br> <br>
		</nav>

	</main>

	<!--bottom-->
	<jsp:include page="bottom.jsp" />
	<!--bottom-->
</body>
</html>