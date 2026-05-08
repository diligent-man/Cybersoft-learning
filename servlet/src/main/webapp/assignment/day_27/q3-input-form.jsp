<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script type="text/javascript">
    function validateForm() {
        const form = document.querySelector('form');
        const username = form.querySelector('input[name="username"]');
        const password = form.querySelector('input[name="password"]');

        if (!(username.value.trim()) || !(password.value.trim())) {
            alert("Both username and password must be filled");
            return false;
        }

        return true;
    }
</script>
<form action="<c:url value='/assignment/day-27/q3' />" method="post" onsubmit="return validateForm()">
    username: <input type="text" name="username" placeholder="username">
    <br>
    password: <input type="password" name="password" placeholder="password">
    <br>
    <button type="submit">Log in</button>
</form>
</body>
</html>
