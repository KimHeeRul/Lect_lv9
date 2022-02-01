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

UserDAO dao = UserDAO.getInstance();
ArrayList<UserDTO> datas = dao.getUsers();

int cnt = 0;
for (UserDTO user : datas) {
	if (id.equals(user.getId())&&pw.equals(user.getPw())) {
		cnt++;
		session.setAttribute("id", id);
	} 
}
if(cnt!=0){
	response.sendRedirect("main.jsp");
}else{
	%>
	<script type="text/javascript">
	alert("계정 정보가 일치하지않습니다.")
		history.back();
	</script>
	
	<%
}


%>