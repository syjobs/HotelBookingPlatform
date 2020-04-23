<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HNU酒店在线预订平台-房型类别</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="font-family: 微软雅黑;">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                用户信息
            </h3>
            <form class="form-horizontal" role="form" action="/super/user/byUsername" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">根据用户名查询</label>
                    <div class="col-sm-10">
                        <input required type="text" class="form-control" name="username"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input required type="submit" value="查询" class="btn btn-default"/>
                    </div>
                </div>
            </form>
            <br/>
            <form class="form-horizontal" role="form" action="/super/user/byPhone" method="post">
                <div class="form-group">
                    <label class="col-sm-2 control-label">根据电话号码查询</label>
                    <div class="col-sm-10">
                        <input required type="text" class="form-control" name="phone"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input required type="submit" value="查询" class="btn btn-default"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <table class="table">
                <thead>
                <tr>
                    <th>
                        用户名
                    </th>
                    <th>
                        真实姓名
                    </th>
                    <th>
                        性别
                    </th>
                    <th>
                        邮箱
                    </th>
                    <th>
                        电话号码
                    </th>
                    <th>
                        状态
                    </th>
                </tr>
                </thead>
                <tbody>
                <#list pageUser.queryResultList as user>
                <tr>
                    <td>
                        ${user.username}
                    </td>
                    <td>
                        ${user.realName}
                    </td>
                    <td>
                        ${user.gender}
                    </td>
                    <td>
                        ${user.email}
                    </td>
                    <td>
                        ${user.phone}
                    </td>
                    <#assign status="${user.status}"/>
                    <#if status=="1">
                        <td id='td${user.id}'>
                            正常&nbsp;<a href="javascript:block(${user.id})">加黑名单</a>
                        </td>
                    <#else>
                        <td id='td${user.id}'>
                            已加黑名单&nbsp;<a href="javascript:deblock(${user.id})">解除黑名单</a>
                        </td>
                    </#if>
                </tr>
                </#list>
                </tbody>
            </table>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <#if pageUser.currentPage gt 1>
                <a href='/super/user/pageUser?currentPage=1'>首页</a>
            <#else>
                <span>首页</span>
            </#if>
            <#if pageUser.currentPage gt 1>
                <a href='/super/user/pageUser?currentPage=${pageUser.currentPage-1}'>上一页</a>
            <#else>
                <span>上一页</span>
            </#if>
            <#if pageUser.currentPage lt pageUser.totalPages>
                <a href='/super/user/pageUser?currentPage=${pageUser.currentPage+1}'>下一页</a>
            <#else>
                <span>下一页</span>
            </#if>
            <#if pageUser.currentPage lt pageUser.totalPages>
                <a href='/super/user/pageUser?currentPage=${pageUser.totalPages}'>末页</a>
            <#else>
                <span>末页</span>
            </#if>
                <span>${pageUser.currentPage}/${pageUser.totalPages}页</span>
                <br/>
                <a href="/super/toSuper">返回上一页</a>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    function block(userId) {
        if (confirm("确定对该用户加黑名单？")){
            $.getJSON('modifyStatus?userId='+userId+'&status=0',function (json) {
                if(json){
                    $('#td'+userId).html('加黑名单&nbsp;<a href="javascript:block('+userId+')">解除黑名单</a>');
                    alert('加黑名单成功');
                }else{
                    alert('加黑名单失败');
                }
            })
        }
    }
    function deblock(userId) {
        if (confirm("确定对该用户解除黑名单？")){
            $.getJSON('modifyStatus?userId='+userId+'&status=1',function (json) {
                if(json){
                    $('#td'+userId).html('正常&nbsp;<a href="javascript:block('+userId+')">加黑名单</a>');
                    alert('解除黑名单成功');
                }else{
                    alert('解除黑名单失败');
                }
            })
        }
    }
</script>
</body>
</html>