<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		int p = Integer.parseInt(request.getParameter("page").toString());
	
		if(Integer.parseInt(request.getParameter("move")) == 2){
			session.setAttribute("page", p+1);
		} else{
			session.setAttribute("page", p-1);
		}
		request.getRequestDispatcher("community.jsp").forward(request, response);
	%>
</body>
</html>