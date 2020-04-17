<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-pills">
<#--                <li class="active">-->
                <li>
                    <a href="/toIndex">首页</a>
                </li>
                <li>
                    <a href="/user/room/showRoomByCatalog">酒店信息</a>
                </li>
                <li class="dropdown pull-right">
                    <p>
                        <#if user!=null>
                            <a href="/user/toInformation">${user.realName}</a>
                            &nbsp;&nbsp;
                            <a href="/user/reservation/showByUser">订单管理</a>
                            &nbsp;&nbsp;
                            <a href="/user/doLogout">注销</a>
                        <#else>
                            <a href="/user/toLogin">登录</a>
                            &nbsp;&nbsp;
                            <a href="/user/toRegister">注册</a>
                        </#if>

                        &nbsp;&nbsp;<a href="/admin/toLogin">进入后台</a>
                    </p>
                </li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1 class="text-center">
                酒店管理系统
            </h1>
            <br/>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-6 column">
            <img alt="140x140" src="/upload/room/primary/${room0.primaryPhoto}" style="height: 140px"/>
            <#--<a href="/user/room/detailed?roomNum?roomNum=${room0.roomNum}">${room0.roomNum}</a>
            &nbsp;&nbsp;${room0.roomStatus.status}-->
        </div>
        <div class="col-md-6 column">
            <img alt="140x140" src="/upload/room/primary/${room1.primaryPhoto}" style="height: 140px"/>
        </div>
    </div>
    <br/>
    <div class="row clearfix">
        <div class="col-md-6 column">
            <img alt="140x140" src="/upload/room/primary/${room2.primaryPhoto}" style="height: 140px"/>
        </div>
        <div class="col-md-6 column">
            <img alt="140x140" src="/upload/room/primary/${room3.primaryPhoto}" style="height: 140px"/>
        </div>
    </div>
    <br/>
    <div class="row clearfix">
        <div class="col-md-6 column">
            <img alt="140x140" src="/upload/room/primary/${room4.primaryPhoto}" style="height: 140px"/>
        </div>
        <div class="col-md-6 column">
            <img alt="140x140" src="/upload/room/primary/${room5.primaryPhoto}" style="height: 140px"/>
        </div>
    </div>
    <br/>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                最新活动消息
            </h3>
            <br/>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        活动标题
                    </th>
                    <th>
                        活动内容
                    </th>
                    <th>
                        发布时间
                    </th>
                </tr>
                </thead>
                <tbody>
                <#setting date_format="yyyy年MM月dd日">
                <#list promotionList as promotion>
                    <tr id="tr${promotion.id}">
                        <td>
                            ${promotion.title}
                        </td>
                        <td>
                            ${promotion.content}
                        </td>
                        <td>
                            ${promotion.pubDate?date}
                        </td>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>