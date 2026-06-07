<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="now" class="java.util.Date"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" type="image/png" sizes="16x16" href="plugins/images/favicon.png">
    <title>Pixel Admin</title>
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Menu CSS -->
    <link href="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
    <!-- animation CSS -->
    <link href="css/animate.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link href="css/style.css" rel="stylesheet">
    <!-- color CSS -->
    <link href="css/colors/blue-dark.css" id="theme" rel="stylesheet">
    <link rel="stylesheet" href="./css/custom.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<c:if test="${not empty sessionScope.msg}">
    <script>
        window.addEventListener("load", function () {
            alert("<c:out value='${sessionScope.msg}' />");
        });
    </script>

    <c:remove var="msg" scope="session"/>
</c:if>

<!-- Preloader -->
<div class="preloader">
    <div class="cssload-speeding-wheel"></div>
</div>
<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top m-b-0">
        <div class="navbar-header">
            <a class="navbar-toggle hidden-sm hidden-md hidden-lg " href="javascript:void(0)" data-toggle="collapse"
               data-target=".navbar-collapse">
                <i class="fa fa-bars"></i>
            </a>
            <div class="top-left-part">
                <a class="logo" href="/">
                    <b>
                        <img src="plugins/images/pixeladmin-logo.png" alt="home"/>
                    </b>
                    <span class="hidden-xs">
                                <img src="plugins/images/pixeladmin-text.png" alt="home"/>
                            </span>
                </a>
            </div>
            <ul class="nav navbar-top-links navbar-left m-l-20 hidden-xs">
                <li>
                    <form role="search" class="app-search hidden-xs">
                        <input type="text" placeholder="Search..." class="form-control">
                        <a href="">
                            <i class="fa fa-search"></i>
                        </a>
                    </form>
                </li>
            </ul>
            <ul class="nav navbar-top-links navbar-right pull-right">
                <li>
                    <div class="dropdown">
                        <a class="profile-pic dropdown-toggle" data-toggle="dropdown" href="#">
                            <img src="plugins/images/users/varun.jpg" alt="user-img" width="36" class="img-circle"/>
                            <b class="hidden-xs">Cybersoft</b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="profile.html">Thông tin cá nhân</a></li>
                            <li><a href="#">Thống kê công việc</a></li>
                            <li class="divider"></li>
                            <li><a href="logout">Đăng xuất</a></li>
                        </ul>
                    </div>
                </li>
            </ul>
        </div>
        <!-- /.navbar-header -->
        <!-- /.navbar-top-links -->
        <!-- /.navbar-static-side -->
    </nav>
    <!-- Left navbar-header -->
    <div class="navbar-default sidebar" role="navigation">
        <div class="sidebar-nav navbar-collapse slimscrollsidebar">
            <ul class="nav" id="side-menu">
                <li style="padding: 10px 0 0;">
                    <a href="/" class="waves-effect"><i class="fa fa-clock-o fa-fw"
                                                        aria-hidden="true"></i><span class="hide-menu">Dashboard</span></a>
                </li>
                <li>
                    <a href="user" class="waves-effect"><i class="fa fa-user fa-fw"
                                                           aria-hidden="true"></i><span
                            class="hide-menu">Thành viên</span></a>
                </li>
                <li>
                    <a href="role" class="waves-effect"><i class="fa fa-modx fa-fw"
                                                           aria-hidden="true"></i><span
                            class="hide-menu">Quyền</span></a>
                </li>
                <li>
                    <a href="project" class="waves-effect"><i class="fa fa-table fa-fw"
                                                              aria-hidden="true"></i><span
                            class="hide-menu">Dự án</span></a>
                </li>
                <li>
                    <a href="task" class="waves-effect"><i class="fa fa-table fa-fw"
                                                           aria-hidden="true"></i><span
                            class="hide-menu">Công việc</span></a>
                </li>
                <li>
                    <a href="blank.jsp" class="waves-effect"><i class="fa fa-columns fa-fw"
                                                                aria-hidden="true"></i><span class="hide-menu">Blank Page</span></a>
                </li>
                <li>
                    <a href="404.jsp" class="waves-effect"><i class="fa fa-info-circle fa-fw"
                                                              aria-hidden="true"></i><span
                            class="hide-menu">Error 404</span></a>
                </li>
            </ul>
        </div>
    </div>
    <!-- Left navbar-header end -->

    <!-- Page Content -->
    <div id="page-wrapper">
        <div class="container-fluid">
            <div class="row bg-title">
                <div class="col-lg-3 col-md-4 col-sm-4 col-xs-12">
                    <h4 class="page-title">Danh sách thành viên</h4>
                </div>
                <div class="col-lg-9 col-sm-8 col-md-8 col-xs-12 text-right">
                    <a href="user-add" class="btn btn-sm btn-success">Thêm mới</a>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /row -->
            <div class="row">
                <div class="col-sm-12">
                    <div class="white-box">
                        <div class="table-responsive">
                            <table class="table" id="example">
                                <thead>
                                <tr>
                                    <th>STT</th>
                                    <th>First Name</th>
                                    <th>Last Name</th>
                                    <th>Username</th>
                                    <th>Role</th>
                                    <th>Actions</th>
                                </tr>
                                </thead>

                                <tbody>
                                <%--           Intentionally left blank for using server-side pagination            --%>
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td>${user.id}</td>
                                        <td>${user.firstName}</td>
                                        <td>${user.lastName}</td>
                                        <td>${user.email}</td>
                                        <td>${user.roleName}</td>
                                        <td>
                                            <a href="user-update?userId=${user.id}"
                                               class="btn btn-primary btn-sm">Sửa</a>

                                            <form action="user-delete" method="post" style="display:inline;"
                                                  onsubmit="return confirm('Bạn có chắc muốn xóa user này không?');">
                                                <input type="hidden" name="userId" value="${user.id}"/>
                                                <button type="submit" class="btn btn-sm btn-danger">Xóa</button>
                                            </form>

                                            <a href="user-details?userId=${user.id}" class="btn btn-info btn-sm">Xem</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->

        <footer class="footer text-center">
            <fmt:formatDate value="${now}" pattern="yyyy"/> &copy; myclass.com
        </footer>
    </div>
    <!-- /#page-wrapper -->
</div>
<!-- /#wrapper -->
<!-- jQuery -->
<script src="plugins/bower_components/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="bootstrap/dist/js/bootstrap.min.js"></script>
<!-- Menu Plugin JavaScript -->
<script src="plugins/bower_components/sidebar-nav/dist/sidebar-nav.min.js"></script>
<!--slimscroll JavaScript -->
<script src="js/jquery.slimscroll.js"></script>
<%--<script src="js/jquery.dataTables.js"></script>--%>
<script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<!--Wave Effects -->
<script src="js/waves.js"></script>
<!-- Custom Theme JavaScript -->
<script src="js/custom.min.js"></script>

<script>
    <%--  This is appropriate for small number of users only (client-side handling)  --%>
    $(document).ready(function () {
        $('#example').DataTable({
            pageLength: 10,

            lengthMenu: [10, 25, 50, 100],

            language: {
                lengthMenu: "Hiển thị _MENU_ mục",
                info: "Hiển thị _START_ đến _END_ của _TOTAL_ mục",
                infoEmpty: "Hiển thị 0 đến 0 của 0 mục",
                search: "Search:",
                paginate: {
                    previous: "Previous",
                    next: "Next"
                },
                zeroRecords: "Không tìm thấy kết quả"
            }
        });
    });

    <%--
        This is appropriate for large number of users only (server-side handling).
        However, this require server return JSON instead of JSP page !
        Check it out later
    --%>
    <%--    $(document).ready(function () {--%>
    <%--        $('#example').DataTable({--%>
    <%--            serverSide: true,--%>
    <%--            searching: true,--%>
    <%--            ordering: true,--%>

    <%--            ajax: {--%>
    <%--                url: "user-fetch",--%>
    <%--                type: "GET",--%>
    <%--                data: function (params) {--%>
    <%--                    return {--%>
    <%--                        page: (params.start / params.length) + 1,--%>
    <%--                        pageSize: params.length--%>
    <%--                    };--%>
    <%--                },--%>

    <%--                // remap PageDTO fields to what DataTables expects--%>
    <%--                dataFilter: function (response) {--%>
    <%--                    let json = jQuery.parseJSON(response);--%>
    <%--                    return JSON.stringify(json);--%>
    <%--                }--%>
    <%--            },--%>

    <%--            columns: [--%>
    <%--                {--%>
    <%--                    data: null,--%>
    <%--                    render: function (data, type, row, meta) {--%>
    <%--                        return meta.settings._iDisplayStart + meta.row + 1; // STT--%>
    <%--                    }--%>
    <%--                },--%>
    <%--                {data: "firstName"},--%>
    <%--                {data: "lastName"},--%>
    <%--                {data: "email"},--%>
    <%--                {data: "roleName"},--%>
    <%--                {--%>
    <%--                    data: null,--%>
    <%--                    orderable: false,--%>
    <%--                    render: function (data, type, row) {--%>
    <%--                        return `--%>
    <%--                        <form action="user-update" method="get" style="display:inline;">--%>
    <%--                            <input type="hidden" name="userId" value="${row.id}"/>--%>
    <%--                            <button type="submit" class="btn btn-sm btn-primary">Sửa</button>--%>
    <%--                        </form>--%>

    <%--                        <form action="user-delete" method="post" style="display:inline;"--%>
    <%--                              onsubmit="return confirm('Bạn có chắc muốn xóa?')">--%>
    <%--                            <input type="hidden" name="userId" value="${row.id}"/>--%>
    <%--                            <button type="submit" class="btn btn-sm btn-danger">Xóa</button>--%>
    <%--                        </form>--%>

    <%--                        <form action="user-details" method="post" style="display:inline;">--%>
    <%--                            <input type="hidden" name="userId" value="${row.id}"/>--%>
    <%--                            <button type="submit" class="btn btn-sm btn-info">Xem</button>--%>
    <%--                        </form>--%>
    <%--                    `;--%>
    <%--                    }--%>
    <%--                }--%>
    <%--            ],--%>

    <%--            lengthMenu: [10, 25, 50, 100],--%>
    <%--            pageLength: 10,--%>
    <%--            language: {--%>
    <%--                lengthMenu: "Hiển thị _MENU_ mục",--%>

    <%--                info: "Hiển thị _START_ đến _END_ của _TOTAL_ mục",--%>
    <%--                infoEmpty:  "Hiển thị 0 đến 0 của 0 mục",--%>

    <%--                search: "Search:",--%>

    <%--                paginate: {previous: "Previous", next: "Next"},--%>
    <%--                zeroRecords: "Không tìm thấy kết quả"--%>
    <%--            }--%>
    <%--        });--%>
    <%--    });--%>
</script>
</body>
</html>
