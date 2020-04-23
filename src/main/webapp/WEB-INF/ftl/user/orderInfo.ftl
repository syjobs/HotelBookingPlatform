<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HNU酒店在线预订平台-填写订单信息</title>
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
            <h3 class="text-center" style="font-family: 微软雅黑;">
                填写您的预订信息
            </h3>
            <br/>
            <p style="color: red">${hint}</p>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/user/reservation/addByUser" method="post" style="margin-left: 359px;">
                <div class="form-group">
                    <input type="hidden" name="roomNum" value="${roomNum}"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputEmail1">预订天数</label>
                    <input type="number" class="form-control" name="days" required style="width: 410px;"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">入住时间</label>
                    <input type="datetime-local" class="form-control" name="checkInTime" style="width: 410px;" required />
                </div>
                <div class="form-group">
                    <label for="exampleInputFile">入住人姓名</label>
                    <input type="text" class="form-control" required name="checkInName" style="width: 410px;"/>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword1">联系电话</label>
                    <input type="number" class="form-control" name="checkInPhone" style="width: 410px;" required />
                </div>
                <button type="submit" class="btn btn-default">预订</button>
                &nbsp;&nbsp;
                <a href="/user/room/detailed?roomNum=${roomNum}">返回上一页</a>
            </form>
        </div>
    </div>
</div>
</body>
</html>