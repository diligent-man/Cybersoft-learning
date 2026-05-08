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
        const a = form.querySelector('input[name="a"]');
        const b = form.querySelector('input[name="b"]');
        const op = form.querySelector('input[name="op"]');

        if (!a.value) a.value = 1
        if (!b.value) b.value = 1
        if (!op.value) op.value = "+"

        return true;
    }
</script>
<form action="<c:url value='/assignment/day-27/q1' />" method="post" onsubmit="return validateForm()">
    <input type="number" name="a" placeholder="1">
    <input type="number" name="b" placeholder="1">
    <select name="op">
        <option value="+">+</option>
        <option value="-">-</option>
    </select>
    <button type="submit">Tính</button>
</form>
</body>
</html>
