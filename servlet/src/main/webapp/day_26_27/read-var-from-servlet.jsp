<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String str2 = "This is another string to display";
    int strLen2 = str2.length();

    Integer counter = (Integer) request.getAttribute("counter");
    String counterColor = (String) request.getAttribute("counterColor");
%>
<h3>
    String is: <%=str2%>
    <br>
    String length is: <%=strLen2%>
    <br>

    <%--  Spaghetti code when mix b/t JSP and Java  --%>
    <%-- counter is always incremented after each reload --%>
    Counter: <span style="color: <%= counterColor %>"><%=counter%></span>
    <br>
    <%-- can be substituted by ExpressionLanguage --%>
    Counter: <span style="color: ${counterColor}">${counter}</span> (using Expresion Language)
</h3>
</body>
</html>
