<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.member"%>
<%
 /*
 1.擷取 session-->p
 2.確認-->訂單
 */


 member m=(member)session.getAttribute("M");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%=m.getName() %> 歡迎你</h3>
<a href="/porder/porder">進入購物</a><br>
</body>
</html>