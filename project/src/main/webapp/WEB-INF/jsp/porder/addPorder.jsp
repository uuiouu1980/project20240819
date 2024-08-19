<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.member"%>
<%
 
 member m=(member)session.getAttribute("M");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><%=m.getName() %>歡迎,請輸入訂購資料</h3>
<form action="/porder/confirm" method="post">
	訂單編號:<input type="text" name="porderNo"><br>
	產品編號:<input type="text" name="productNo"><br>
	數量:<input type="text" name="amount"><br>
	<input type="submit" value="ok">
</form>
</body>
</html>