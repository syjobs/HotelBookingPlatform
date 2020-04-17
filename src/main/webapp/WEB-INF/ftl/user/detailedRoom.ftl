<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>酒店|房型列表</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-pills">
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
                    </p>
                </li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                房型编号<label style="color: red">${room.roomNum}</label>的详细信息
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
                </tr>
                </thead>
                <tbody>
                <tr class="success">
                    <td>
                        ${room.roomNum}
                    </td>
                    <td>
                        ${room.area}
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
                </tr>
                </tbody>
            </table>
            <br/>
<#--            <button><a href="/user/comment/showByRoom?roomNum=${room.roomNum}">评论信息</a> </button>-->
            <#if room.roomStatus.status=="空闲">
                <button><a href="/user/reservation/order?roomNum=${room.roomNum}">预订</a> </button>
            <#else>
                <p style="color: red;">暂时无法预订</p>
            </#if>
            <ul>
                <li>
                    房型主图
                </li>
                <li>
                    <div class="col-md-12 column">
                        <img alt="140x140" src="/upload/room/primary/${room.primaryPhoto}" style="height: 140px"/>
                    </div>
                </li>
                <li>
                    房型附图
                </li>
                <#list roomPhotoList as roomPhoto>
                    <li id="li${roomPhoto.id}">
                        <div class="col-md-12 column">
                            <img alt="140x140" src="/upload/room/subjoin/${roomPhoto.photoPath}" style="height: 140px"/>
                        </div>
                    </li>
                    <br/>
                </#list>
            </ul>
        </div>
    </div>
</div>
</body>
</html>