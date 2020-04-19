<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HU酒店在线预定平台-${userRealName}个人信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" style="margin-top: 15px;">
            <ul class="nav nav-pills">
                <li class="dropdown pull-left">
                    <p>
                        <a href="/toIndex">首页</a>&nbsp;

                        <a href="/user/room/showRoomByCatalog">预订客房</a>
                    </p>
                </li>
                <li class="dropdown pull-right">
                    <p>
                    <#if user!=null>
                        欢迎${user.realName}&nbsp;&nbsp;<a href="/user/toInformation">个人中心</a>
                        &nbsp;&nbsp;
                        <a href="/user/reservation/showByUser">我的订单</a>
                        &nbsp;&nbsp;
                        <a href="/user/doLogout">退出</a>
                    <#else>
                        <a href="/user/toLogin">登录</a>
                        &nbsp;&nbsp;
                        <a href="/user/toRegister">注册</a>
                    </#if>
                    </p>
                </li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                <label style="color: red">${user.realName}</label>，以下是您的详细个人信息
            </h3>
        </div>
    </div>
    <br/><br/>
    <div class="row clearfix">
        <div class="col-md-6 column">
            <img alt="140x140" src="/upload/user/${user.photoPath}" class="img-circle" style="height: 140px"/>
        </div>
        <div class="col-md-6 column">
            <a href="/user/toUpdateInfo">修改个人信息</a>
            &nbsp;&nbsp;
            <a href="/user/toUpdatePassWord">修改密码</a>
        </div>
    </div>
    <br/>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <td>
                        用户名：
                    </td>
                    <td>
                        ${user.username}
                    </td>
                </tr>
                <tr class="success">
                    <td>
                        邮箱：
                    </td>
                    <td>
                        ${user.email}
                    </td>
                </tr>
                <tr class="error">
                    <td>
                        电话号码：
                    </td>
                    <td>
                         ${user.phone}
                    </td>
                </tr>
                <tr class="warning">
                    <td>
                        真实姓名：
                    </td>
                    <td>
                        ${user.realName}
                    </td>
                </tr>
                <tr class="info">
                    <td>
                       性别：
                    </td>
                    <td>
                        ${user.gender}
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
    <a href="/toIndex">返回首页</a>
</div>
</body>
</html>