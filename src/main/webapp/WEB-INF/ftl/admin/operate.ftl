<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HU酒店在线预定平台-后台管理系统</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                员工编号：${admin.empNum}
            </h3>
            <br/>
            <label style="color: red">${hint}</label>
            <br/>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ol>
                <li>
                    <a href="/admin/reservation/toShowUserReservation">订单操作</a>
                </li>
                <li>
                    <a href="/super/toSuper">超级管理员操作</a>
                </li>
                <li>
                    <a href="/admin/toUpdatePassword">修改密码</a>
                </li>
                <li>
                    <a href="/admin/doLogout">退出后台</a>
                </li>
            </ol>
        </div>
    </div>
</div>
</body>
</html>