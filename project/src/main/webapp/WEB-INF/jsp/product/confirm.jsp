<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.employee"
    import="com.example.demo.vo.product"%>
 <%
 
 employee e=(employee) session.getAttribute("E");
 product p=(product)session.getAttribute("PR");

 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width=400 align=center border=1>
		<tr>
			<td colspan=2 align=center>
			<%=e.getName() %> 這是你的產品資料
		<tr>
			<td width=100>產品編號
			<td><%=p.getProductNo() %>
		<tr>
			<td>產品名稱
			<td><%=p.getProductName() %>
		<tr>
			<td>價格
			<td><%=p.getPrice() %>
		<tr>
			<td colspan=2 align=center>
			<a href="/product/addProduct">回上一頁</a>
			<a href="/product/finish">確定</a>
	</table>

</body>
</html>