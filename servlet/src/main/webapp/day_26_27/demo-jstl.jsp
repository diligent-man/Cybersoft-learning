<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ol class="items">
    <c:forEach items="${strArr}" var="item">
        <li>String Name: ${item}
    </c:forEach>
</ol>
</body>
</html>
