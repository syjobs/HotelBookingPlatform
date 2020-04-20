<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HU酒店在线预订平台-历史订单</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
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
                欢迎<label style="color: red">${user.realName}</label>，以下是您的历史订单
            </h3>
            <br/>
            <#if reservationList?size==0>
                <p style="color: red">您暂时没有订单信息</p>
            </#if>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        入住人
                    </th>
                    <th>
                        下单时间
                    </th>
                    <th>
                        入住时间
                    </th>
                    <th>
                        预订天数
                    </th>
                    <th>
                        入住的房型名称
                    </th>
                    <th>
                        订单状态
                    </th>
                </tr>
                </thead>
                <tbody>
                <#setting date_format="yyyy-MM-dd HH:mm">
                <#list reservationList as reservation>
                    <tr>
                        <td>
                            ${reservation.checkInName}
                        </td>
                        <td>
                            ${reservation.orderTime?date}
                        </td>
                        <td>
                            ${reservation.checkInTime?date}
                        </td>
                        <td>
                            ${reservation.days}
                        </td>
                        <td>
                            <a href="/user/room/detailed?roomNum=${reservation.roomInfo.roomNum}">${reservation.roomInfo.roomNum}</a>
                        </td>
                        <td>
                            <#assign status="${reservation.reservationStatus.status}">
                            <#if status=="预订成功">
                                ${status}&nbsp;&nbsp;<a href="/user/reservation/cancel?reservationId=${reservation.id}">取消订单</a>
                            <#elseif status=="已退房">
                                ${status}&nbsp;&nbsp;<a href="/user/comment/toPublish?roomNum=${reservation.roomInfo.roomNum}">评论</a>
                            <#else>
                                ${status}
                            </#if>
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
            <a href="/toIndex">返回首页</a>
        </div>
    </div>
</div>
</body>
</html>