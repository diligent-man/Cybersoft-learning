<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>

<jsp:useBean id="now" class="java.util.Date"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
<c:if test="${not empty cookie.loginMsg.value}">
    <script>
        window.addEventListener("load", function () {
            alert("<c:out value='${URLDecoder.decode(cookie.loginMsg.value, StandardCharsets.UTF_8)}' />");
        });
    </script>
</c:if>

<div class="container">
    <div class="row mt-5">
        <div class="col-md-5 m-auto mt-5">
            <h3 class="text-center">ĐĂNG NHẬP HỆ THỐNG</h3>
            <div class="p-4 border mt-4">
                <form action="login" method="post">
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" class="form-control" name="email" value="${email}">
                    </div>
                    <div class="form-group">
                        <label>Mật khẩu</label>
                        <input type="password" class="form-control" name="password" value="${password}">
                    </div>
                    <div class="form-group">
                        <input type="checkbox" name="remember"
                               class="btn btn-primary" ${cookie.remember.value == 'on' ? 'checked' : ''}> Ghi nhớ
                    </div>
                    <button type="submit" class="btn btn-primary">Đăng nhập</button>
                </form>
            </div>
        </div>
    </div>

    <footer class="footer text-center">
        <fmt:formatDate value="${now}" pattern="yyyy"/> &copy; myclass.com
    </footer>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
