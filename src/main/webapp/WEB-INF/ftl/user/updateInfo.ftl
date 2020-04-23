<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HNU酒店在线预订平台-修改个人信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="font-family: 微软雅黑;">
    <div class="row clearfix">
        <div class="col-md-12 column" style="margin-top: 15px;">
            <ul class="nav nav-pills">
                <li class="dropdown pull-left">
                    <p>
                        <a href="/toIndex">首页</a>&nbsp;

                        &nbsp;&nbsp;<a href="/user/room/showRoomByCatalog">预订房间</a>
                    </p>
                </li>
                <li class="dropdown pull-right">
                    <p>
                    <#if user!=null>
                        欢迎${user.realName}&nbsp;&nbsp;<a href="/user/toInformation">用户中心</a>
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
                修改个人信息
            </h3>
            <br/>
            <label style="color: red">${hint}</label>
            <br/>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form class="form-horizontal" role="form" action="/user/updateInfo" method="post" id="registerForm" enctype="multipart/form-data" accept-charset="UTF-8" style="margin-left: 310px;">
                <div class="form-group">
                    <label class="col-sm-2 control-label">真实姓名</label>
                    <div class="col-sm-10">
                        <input required value="${user.realName}" type="text" class="form-control" name="realName" id="realName" style="width: 390px"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别</label>
                    &nbsp;&nbsp;<input type="radio" name="gender" id="gender" value="男" checked/>男&nbsp;&nbsp;&nbsp;&nbsp;
                    <input type="radio" name="gender" value="女">女
                </div>
                <div class="form-group">
                    <label  class="col-sm-2 control-label">邮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;箱</label>
                    <label id="isEmailValid"></label>
                    <div class="col-sm-10">
                        <input required value="${user.email}" type="email" class="form-control" name="email" id="email" style="width: 390px"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">上传头像</label>
                    <input type="file" name="photo" id="photo" />
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input type="submit" class="btn btn-default" value="修改"/>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="/user/toInformation">返回个人主页</a>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>
</body>
</html>
