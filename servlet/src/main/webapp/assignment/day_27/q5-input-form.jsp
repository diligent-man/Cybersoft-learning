<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Q5 input form</title>
</head>

<body>
<%
    String[] hobbies = new String[]{
            "game", "reading", "music", "travelling"
    };
    request.setAttribute("hobbies", hobbies);
%>

<form action="<c:url value='/assignment/day-27/q5'/>" method="get">
    Name: <input name="name" type="text" placeholder="your name"><br>
    Hobbies: <c:forEach items="${hobbies}" var="hobby">
    ${hobby} <input type="checkbox" name="hobbies" value=${hobby}>
</c:forEach>
    <br>
    <button>Submit</button>
</form>
</body>
</html>
