<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background: ${result ? 'green' : 'red'}">
<h1 style="text-align: center">
    ${result ? 'Successuly logged in' : "Failed to log in"}
</h1>
</body>
</html>
