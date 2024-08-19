<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.product"
    import="java.util.List"%>
<%

List<product> l = (List<product>) session.getAttribute("L");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>產品查詢</title>
<style>
    table {
        width: 80%;
        margin: 20px auto;
        border-collapse: collapse;
    }
    th, td {
        border: 1px solid #000;
        padding: 10px;
        text-align: center;
    }
    th {
        background-color: #f2f2f2;
    }
    a {
        margin: 10px;
        display: inline-block;
        text-decoration: none;
        color: #000;
        background-color: #f2f2f2;
        padding: 5px 10px;
        border-radius: 5px;
    }
    a:hover {
        background-color: #ddd;
    }
</style>
</head>
<body>
<form action="/product/update" method="post">
	<table align=center >
		<tr>
			<td colspan=2 align=center>輸入產品修改資料
		<tr>
			<td>id編號<br>
			<td><input type="text" name="id" size=5>
		<tr>
			<td>產品編號<br>
			<td><input type="text" name="productNo" size=5>
		<tr>
			<td>產品名稱
			<td><input type="text" name="productName" size=5>
		<tr>
			<td>價格
			<td><input type="text" name="price" size=5>
		<tr>
			<td colspan=2 align=center>
			<input type="submit" value="ok">
			
	</table>
</form>
<hr>
<table>
    <tr>
        <th>id編號</th>
        <th>產品編號</th>
        <th>產品名稱</th>
        <th>價格</th>
    </tr>
    <% if (l != null) {
        for (product q : l) { %>
            <tr>
                <td><%= q.getId() %></td>
                <td><%= q.getProductNo() %></td>
                <td><%= q.getProductName() %></td>
                <td><%= q.getPrice() %></td>
            </tr>
        <% }
    } else { %>
        <tr>
            <td colspan="4">無訂購資料</td>
        </tr>
    <% } %>   
         
</table>
<div style="text-align: center;">
    <a href="/employee/manager">員工管理系統</a>
    <a href="/product/product">回上一頁</a>
	<a href="/employee/logout">登出</a>
</div>
</body>
</html>
