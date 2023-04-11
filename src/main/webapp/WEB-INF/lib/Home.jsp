<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  import="java.util.*,beans.*" %>
<%
	List<Task> tasks = (List<Task>) request.getAttribute("tasks");
	ErrorMessage errMsg = (ErrorMessage) request.getAttribute("errorMessage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoListHome</title>
</head>
<body>
<form action="/TodoList/CreateTaskServlet" method="post">
	タスク：<input type="textarea" name="task">
	期　限：<input type="date" name="deadline">
	<input type="submit" value="送信">
</form>
<br><br><br><br><br>
<% if(errMsg.getErrorMessage() != null) {%>
	<td>
		<%=errMsg.getErrorMessage() %>
	</td>
<% } else { %>
タスク一覧
<br><br>
	<% for(Task task : tasks) { %>
<tr>
		<% if(task.getCompleteFlg() != 1) { %>
	<td>
		<%=task.getTask() %>
	</td>
	<td>
		<%=task.getDeadline() %>
	</td>
	<td>
		<form action="/TodoList/CompleteTaskServlet" method="post">
			<input type="hidden" name= "id" value="<%=task.getId() %>">
			<input type="submit" value="完了">
		</form>
	</td>
		<% } %>
	<% } %>
</tr>
<br>
完了済みタスク一覧
<br><br>
	<% for(Task task : tasks) { %>
<tr>
		<% if(task.getCompleteFlg() == 1) { %>
	<td>
		<%=task.getTask() %>
	</td>
	<td>
		<%=task.getDeadline() %>
	</td>
	<td>
		<form action="/TodoList/DeleteTaskServlet" method="post">
			<input type="hidden" name= "id" value="<%=task.getId() %>">
			<input type="submit" value="削除">
		</form>
	</td>
		<% } %>
	<% } %>
<% } %>
</tr>
</body>
</html>