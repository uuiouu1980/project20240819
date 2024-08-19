<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.employee"
    import="java.util.List"%>
<%

List<employee> l = (List<employee>) session.getAttribute("L");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改資料</title>
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
<form action="/employee/employeeUpdate" method="post">
	<table align=center >
		<tr>
			<td colspan=2 align=center>修改資料
		<tr>
			<td>id編號<br>
			<td><input type="text" name="id" size=5>
		<tr>
			<td>姓名
			<td><input type="text" name="name" size=5>
		<tr>
			<td>密碼
			<td><input type="text" name="password" size=5>
		<tr>
			<td colspan=2 align=center>
			<input type="submit" value="ok">
			
	</table>
</form>
<hr>
<table>
    <tr>
        <th>id編號</th>
        <th>員工編號</th>
        <th>姓名</th>
        <th>帳號</th>
        <th>密碼</th>
        <th>職等</th>
    </tr>
    <% if (l != null) {
        for (employee q : l) { %>
            <tr>
                <td><%= q.getId() %></td>
                <td><%= q.getEmployeeNo() %></td>
                <td><%= q.getName() %></td>
                <td><%= q.getUsername() %></td>
                <td><%= q.getPassword() %></td>
                <td><%= q.getType() %></td>
            </tr>
        <% }
    } else { %>
        <tr>
            <td colspan="6">無訂購資料</td>
        </tr>
    <% } %>   
         
</table>
<div style="text-align: center;">
    <a href="/employee/employee">回上一頁</a>
    <a href="/employee/logout">登出</a>
</div>
</body>
</html>
