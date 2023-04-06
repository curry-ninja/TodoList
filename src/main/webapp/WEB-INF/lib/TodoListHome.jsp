<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoListHome</title>
</head>
<body>
<form action="/TodoList/HomeServlet" method="post">
タスク：<input type="text" name="task">
期　限：<input type="date" name="deadline">
<input type="submit" value="送信">
</form>
</body>
</html>