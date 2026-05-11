<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String str2 = "This is another string to display";
    int strLen2 = str2.length();
    String counterColor = (String) request.getAttribute("counterColor");
%>
<h3>
    String is: <%=str2%>
    <br>
    String length is: <%=strLen2%>
    <br>

    <%--  Spaghetti code when mix b/t JSP and Java  --%>
    <%-- counter is always incremented after each reload --%>
    Counter: <%=counterColor%>
</h3>
</body>
</html>
