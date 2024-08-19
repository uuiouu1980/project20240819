<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>新增產品</h3>
<form action="/product/confirm" method="post">
	產品編號:<input type="text" name="productNo"><br>
	產品名稱:<input type="text" name="productName"><br>
	價格:<input type="text" name="price"><br>
	<input type="submit" value="ok">
</form>
<br>
	<a href="/employee/manager">員工管理系統</a><br>
    <a href="/product/product">回上一頁</a><br>
	<a href="/employee/logout">登出</a><br>

</body>
</html>