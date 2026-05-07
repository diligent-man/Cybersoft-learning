<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<script type="text/javascript">
    function validateForm() {
        // let username = document.forms[0]["username"].value;
        // let password = document.forms[0]["password"].value;
        const form = document.querySelector('form');
        const username = form.querySelector('input[name="username"]');
        const password = form.querySelector('input[name="password"]');

        if (!username.value) username.value = "default username"
        if (!password.value) password.value = "default password"

        return true;
    }
</script>
<form action="<c:url value='/day-26/param-passing' />" method="get" onsubmit="return validateForm()">
    <input type="text" name="username" placeholder="username">
    <input type="password" name="password" placeholder="password">
    <button>Submit</button>
</form>
</body>
</html>
