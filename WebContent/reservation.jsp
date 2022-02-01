<%@page import="car.CarDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="car.CarDAO"%>
<%@page import="user.UserDAO"%>
<%@page import="util.DBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link rel="stylesheet" href="reservation.css" type="text/css">
</head>
<%
DBManager.getConnection();
CarDAO dao = CarDAO.getInstance();
ArrayList<CarDTO> list = dao.getNewCars();
ArrayList<CarDTO> allList = dao.getCars();
%>

<body>
<div class="wrap">
	<!--top-->
	<jsp:include page="top.jsp" />
	<!--top-->
	<main id="reserv">
		<nav id="reservNav">
			<span style="font-weight: bold; font-size: 3em;">New Car</span> <br>
			<br>
		</nav>

		<aside id="reservaside"></aside>
		<div id="reservDiv">
			<table>
				<tr height="200px">
					<%
					for (int i = 0; i < list.size(); i++) {
					%>
					<td align="center" width="333"><a  href="carReserveInfo.jsp?no=<%=list.get(i).getNo()%>">
					 <img src="imgCar/<%=list.get(i).getImg()%>" width="300px"
							height="200px">
					</a>
						<p style="font-weight: bold;">
							<%=list.get(i).getName()%>
						</p></td>
					<%
					}
					%>
				</tr>
			</table>
			<br>
			<hr class="hr1">
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
				for (int i = 0; i < allList.size(); i++) {
				%>
				<tr height="200px">
					<td align="center" width="333"><a href="carReserveInfo.jsp?no=<%=allList.get(i).getNo()%>"> 
					<img src="imgCar/<%=allList.get(i).getImg()%>" width="300px"
							height="200px">
					</a></td>
					<td>차이름:<sapn style="font-weight: bold;"> <%=allList.get(i).getName()%>
						</sapn>
						<p style="font-weight: bold;">
							설명:
							<%=allList.get(i).getInfo()%>
						</p>
					</td>
				</tr>
				<%
				}
				%>

			</table>

		</div>




		<aside id="reservaside2"></aside>
		<nav id=reservNav2></nav>
	</main>
	<!--bottom-->
	<jsp:include page="bottom.jsp" />
	<!--bottom-->
	</div>
</body>
</html>