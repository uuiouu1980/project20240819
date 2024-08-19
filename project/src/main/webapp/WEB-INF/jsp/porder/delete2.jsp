<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.example.demo.vo.updateporder"
    import="java.util.List"%>
<%

List<updateporder> l = (List<updateporder>) session.getAttribute("L");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>訂購資料查詢</title>
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
<form action="" method="post">
<table align="center">
    <tr>
        <td colspan="2" align="center">刪除的資料</td>
    </tr>
    <tr>
        <td>訂單編號</td>
        <td><input type="text" name="porderNo" size="5"></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
        <input type="submit" value="ok"></td>
    </tr>
</table>
<hr>
<table>
    <tr>
        <th>訂單編號</th>
        <th>產品名稱</th>
        <th>數量</th>
        <th>銷售金額</th>
    </tr>
    <% if (l != null) {
        for (updateporder q : l) { %>
            <tr>
                <td><%= q.getPorderNo() %></td>
                <td><%= q.getProductName() %></td>
                <td><%= q.getAmount() %></td>
                <td><%= q.getSum() %></td>
            </tr>
        <% }
    } else { %>
        <tr>
            <td colspan="5">無訂購資料</td>
        </tr>
    <% } %>   
         
</table>
<div style="text-align: center;">
    <a href="/porder/query">回上一頁</a>
    <a href="/porder/porder">進入購物</a>
    <a href="/member/logout">登出</a>
</div>
</body>
</html>
