<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>新增員工資料表</h3>
<form action="/employee/addEmployee" method="post">
	員工編號:<input type="text" name="employeeNo"><br>
	姓名:<input type="text" name="name"><br>
	帳號:<input type="text" name="username"><br>
	密碼:<input type="password" name="password"><br>
	職等:<input type="text" name="type"><br>
	<input type="submit" value="ok">
</form>
<br>
<a href="/employee/managerStaff">回上一頁</a>
</body>
</html>