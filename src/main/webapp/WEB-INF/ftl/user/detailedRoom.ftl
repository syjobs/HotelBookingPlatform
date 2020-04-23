<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HNU酒店在线预订平台-酒店|房型列表</title>
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
                房型编号<label style="color: red">${room.roomNum}</label>详情信息
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        房型编号
                    </th>
                    <th>
                        面积
                    </th>
                    <th>
                        价格
                    </th>
                    <th>
                        床型
                    </th>
                    <th>
                        酒店名称
                    </th>
                    <th>
                        房型状态
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr class="success">
                    <td>
                        ${room.roomNum}
                    </td>
                    <td>
                        ${room.area}m²
                    </td>
                    <td>
                        ${room.price}
                    </td>
                    <td>
                        ${room.intro}
                    </td>
                    <td>
                        ${room.roomCatalog.catalog}
                    </td>
                    <td>
                        ${room.roomStatus.status}
                    </td>
                    <td>
                        <#if room.roomStatus.status=="空闲">
<#--                            <button>-->
                                <a href="/user/reservation/order?roomNum=${room.roomNum}">预订</a>
<#--                            </button>-->
                        <#else>
                            <p style="color: #1fa55f;">暂时无法预订</p>
                        </#if>
                    </td>
                </tr>
                </tbody>
            </table>
            <br/>
<#--            <button><a href="/user/comment/showByRoom?roomNum=${room.roomNum}">评论信息</a> </button>-->

            <ul>
<#--                    房型主图-->
                    <div class="col-md-12 column">
                        <img alt="300x300" src="/upload/room/primary/${room.primaryPhoto}" style="height: 300px"/>
                    </div>
<#--                    房型附图-->
                    <br>
                <#list roomPhotoList as roomPhoto>
<#--                    <li id="li${roomPhoto.id}">-->
                        <div class="col-md-12 column">
                            <img alt="300x300" src="/upload/room/subjoin/${roomPhoto.photoPath}" style="height: 300px"/>
                        </div>
<#--                    </li>-->
                    <br/>
                </#list>
            </ul>


        </div>
    </div>
</div>
</body>
</html>