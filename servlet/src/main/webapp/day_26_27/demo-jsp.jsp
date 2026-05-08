<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Demo Java Server Pages</h1>
<%--
JSP symbols:
    a/ <%! %>: declare Java var
    b/ <% %>: process code logic
    c/ <%= >: export var's value to screen
--%>

<%-- var is placed inside class not method --%>
<%!
    String str = "Demo Java Server Pages";
    int strLen = str.length();
    int counter = 0;
%>
<h3>
    String is: <%=str%>
    <br>
    String length is: <%=strLen%>
</h3>


<%-- var is placed inside method in lieu of class --%>
<%
    String str2 = "This is another string to display";
    int strLen2 = str2.length();
    counter++;
%>
<h3>
    String is: <%=str2%>
    <br>
    String length is: <%=strLen2%>
    <br>

                                        <%--  Spaghetti code when mix b/t JSP and Java  --%>
    <%-- counter is always incremented after each reload --%>
    Counter: <%if (counter % 2 == 0) {%>
    <span style="color: red"><%=counter%></span>
    <% } else { %>
    <span style="color: cyan"><%=counter%></span>
    <%}%>
</h3>


</body>
</html>
