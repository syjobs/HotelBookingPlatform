<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>酒店管理系统-信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column" style="margin-top: 15px;">
            <ul class="nav nav-pills">
                <li class="dropdown pull-left">
                    <p>
                        <a href="/toIndex">首页</a>&nbsp;

                        <a href="/user/room/showRoomByCatalog">酒店信息</a>
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
            <ul class="breadcrumb">
                    <#if catalog!=null>
                        <li>
                            <a href="/user/room/showRoomByCatalog">全部</a>
                        </li>
                    <#else>
                        <li>
                            <a href="/user/room/showRoomByCatalog" style="color: red">全部</a>
                        </li>
                    </#if>
                <#list catalogList as t>
                    <#if t.catalog==catalog.catalog>
                        <li>
                            <a href="/user/room/showRoomByCatalog?catalogId=${t.id}" style="color: red;">${t.catalog}</a>
                        </li>
                    <#else>
                        <li>
                            <a href="/user/room/showRoomByCatalog?catalogId=${t.id}">${t.catalog}</a>
                        </li>
                    </#if>
                </#list>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        房型编码
                    </th>
                    <th>
                        房型图片
                    </th>
                    <th>
                        价格
                    </th>
                    <th>
                        简介
                    </th>
                    <th>
                        状态
                    </th>
                    <th>
                        操作
                    </th>
                </tr>
                </thead>
                <tbody>
                <#list roomPage.queryResultList as room>
                    <tr>
                        <th>
                            ${room.roomNum}
                        </th>
                        <th>
                            <div class="col-md-12 column">
                                <a href="/user/room/detailed?roomNum=${room.roomNum}"><img alt="140x140" src="/upload/room/primary/${room.primaryPhoto}" style="height: 140px"/></a>
                            </div>
                        </th>
                        <th>
                            ${room.price}
                        </th>
                        <th>
                            ${room.intro}
                        </th>
                        <th>
                             ${room.roomStatus.status}
                        </th>
                        <th>
                            <a href="/user/room/detailed?roomNum=${room.roomNum}">详情</a>
                        </th>
                    </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <#if catalog==null>
                <#if roomPage.currentPage gt 1>
                    <a href='/super/room/doShowRoomByCatalog?currentPage=1'>首页</a>
                <#else>
                    <span>首页</span>
                </#if>
                <#if roomPage.currentPage gt 1>
                    <a href='/user/room/showRoomByCatalog?currentPage=${roomPage.currentPage-1}'>上一页</a>
                <#else>
                    <span>上一页</span>
                </#if>
                <#if roomPage.currentPage lt roomPage.totalPages>
                    <a href='/user/room/showRoomByCatalog?currentPage=${roomPage.currentPage+1}'>下一页</a>
                <#else>
                    <span>下一页</span>
                </#if>
                <#if roomPage.currentPage lt roomPage.totalPages>
                    <a href='/user/room/showRoomByCatalog?currentPage=${roomPage.totalPages}'>末页</a>
                <#else>
                    <span>末页</span>
                </#if>
            <#else>
                <#if roomPage.currentPage gt 1>
                    <a href='/super/room/doShowRoomByCatalog?currentPage=1&catalogId=${catalog.id}'>首页</a>
                <#else>
                    <span>首页</span>
                </#if>
                <#if roomPage.currentPage gt 1>
                    <a href='/user/room/showRoomByCatalog?catalogId=${catalog.id}&currentPage=${roomPage.currentPage-1}'>上一页</a>
                <#else>
                    <span>上一页</span>
                </#if>
                <#if roomPage.currentPage lt roomPage.totalPages>
                    <a href='/user/room/showRoomByCatalog?catalogId=${catalog.id}&currentPage=${roomPage.currentPage+1}'>下一页</a>
                <#else>
                    <span>下一页</span>
                </#if>
                <#if roomPage.currentPage lt roomPage.totalPages>
                    <a href='/user/room/showRoomByCatalog?catalogId=${catalog.id}&currentPage=${roomPage.totalPages}'>末页</a>
                <#else>
                    <span>末页</span>
                </#if>
            </#if>
            <span>${roomPage.currentPage}/${roomPage.totalPages}页</span>
        </div>
    </div>
</div>
</body>
</html>