<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        select:invalid {
            color: gray;
        }

        option {
            color: black;
        }
    </style>
</head>

<body>
<script type="text/javascript">
    function validateForm() {
        const form = document.querySelector('form');
        const color = form.querySelector('input[name="color"]');

        console.log(color.value);

        return true;
    }

    function changeBackground(color) {
        if (color) {
            document.body.style.backgroundColor = color;
        } else {
            document.body.style.backgroundColor = '';
        }
    }
</script>

<form action="<c:url value='/assignment/day-27/q4' />" method="get" onsubmit="return validateForm()">
    <select name="color" id="colorSelector" required="required" onchange="changeBackground(this.value)">
        <option value="">Choose color</option>
        <option value="red">Đỏ</option>
        <option value="blue">Xanh</option>
        <option value="green">Lá</option>
    </select>
    <button>Đổi màu</button>
</form>
</body>
</html>
