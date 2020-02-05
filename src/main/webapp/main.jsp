<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.*"%>
<%@ page import="kr.or.connect.dto.TodoDto"%>
<%
	List todolist = (List)request.getAttribute("todolist");
	Iterator it  = todolist.iterator();

	while(it.hasNext()){
		TodoDto todo = (TodoDto)it.next();
		out.print(todo);
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>TODO LIST</title>
</head>
<body>

 내 할일 !		
</body>
</html>