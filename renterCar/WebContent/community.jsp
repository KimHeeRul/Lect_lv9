<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="board.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
	function press(order) {
		console.log(order);
		if(order=="next"){
			document.getElementById("dir").value = 2;	
		}
		else if(order=="before"){
			document.getElementById("dir").value = 1;				
		}
	}
</script>
<%
BoardDAO dao = BoardDAO.getInstance(); 
ArrayList<BoardDTO> datas = dao.getBoard();

int pagelimit = 10;
int boardlimit = 10;
String id = (String) session.getAttribute("id");
if (id == null) {
%>
<script>
	alert("로그인을 먼저 해주세요");
	location.href = 'login.jsp';
</script>
<%
} else {
int size = 5;

int contentSize = datas.size();
int max = contentSize % size == 0 ? contentSize / size : contentSize / size + 1;

int getPage = Integer.parseInt(session.getAttribute("page").toString());
int p = session.getAttribute("page") == null || Integer.parseInt(session.getAttribute("page").toString()) <= 0 ? 1
		: (getPage > max ? max : getPage);

int start = (p - 1) * size;
int end = start + size > contentSize ? contentSize : start + size;

System.out.println("page " + p);
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="community.css" type="text/css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
</head>
<body>
	<div class="wrap">
		<!--top-->
		<jsp:include page="top.jsp" />
		<!--top-->
		<main id="community">
			<nav id="coNav" style="margin: auto">
				<span style="font-weight: bold; font-size: 2em">커뮤니티</span> <br>
			</nav>

			<aside id="coaside"></aside>

			<div id="coDiv">
			
				<table border="1" class="table" id="table" style="width: 1200px">
					<tr style="height: 30px">
						<td>no</td>
						<td>title</td>
						<td>id</td>
						<td>view</td>
						<td>like</td>
						<td>date</td>
					</tr>
					<%
					for (int i = start; i < end; i++) {
						
					%>
					<tr style="height: 30px">
						<td><%=datas.get(i).getCode()%></td>
						<td><a style="text-decoration: none; color: #000000;"
							href="_18_boardView.jsp?getCode=<%=datas.get(i).getCode()%>">
								<%=datas.get(i).getTitle()%></a></td>
						<td><%=datas.get(i).getId()%></td>
						<td><%=datas.get(i).getView()%></td>
						<td><%=datas.get(i).getLike()%></td>
						<td><%=datas.get(i).getDate()%></td>
					</tr>

					<%
					}
					%>
				</table>
				<br>
				<form action="page.jsp">
					<input type="hidden" name="page" value="<%=p%>"> <input
						id="dir" type="hidden" name="move" value="empty"> <input
						type="button" value="before" class="btn btn-primary"
						onclick="press(this.value); submit();"> <input
						type="button" value="next" class="btn btn-primary" onclick="press(this.value); submit();">
				</form>
				<br>
				<input type="button" value="글 작성" class="btn btn-primary"
					onclick="location.href ='_11_boardWriteForm.jsp'"> <input
					type="button" class="btn btn-primary" value="메인으로"
					onclick="location.href ='main.jsp'">


			</div>
			<aside id="coaside2"></aside>
			<nav id="coNav2"></nav>

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