<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.porder"
    import="com.example.demo.vo.member"%>
 <%
 
 porder p=(porder)session.getAttribute("P");
 member m=(member)session.getAttribute("M");
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
			<%=m.getName() %> 這是你的訂購資料
		<tr>
			<td width=100>訂單編號
			<td><%=p.getPorderNo() %>
		<tr>
			<td>產品編號
			<td><%=p.getProductNo() %>
		<tr>
			<td>數量
			<td><%=p.getAmount() %>
		<tr>
			<td colspan=2 align=center>
			<a href="/porder/addPorder">回上一頁</a>
			<a href="/porder/finish">確定</a>
	</table>

</body>
</html>