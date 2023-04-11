<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "beans.ErrorMessage" %>
<%  ErrorMessage errorMessage = (ErrorMessage) request.getAttribute("errorMessage"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Error</title>
</head>
<body>
<%=errorMessage.getErrorMessage()%>
</body>
</html>