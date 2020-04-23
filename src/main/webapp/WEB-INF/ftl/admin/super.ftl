<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HNU酒店在线预订平台-超级管理员</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="font-family: 微软雅黑;">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                超级管理员界面！当前admin：<label style="color: red">${admin.empNum}</label>
            </h3>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul>
                <li>
                    <h4><a href="/super/doShowAllAdmin">普通管理员管理</a></h4>
                </li>
                <li>
                    <h4><a href="/super/user/all">前台用户管理</a></h4>
                </li>
                <li>
                    <h4>房型类别管理</h4>
                    <a href="/super/room/toAddCatalog">添加房型类别</a>
                    <ul>
                        <#list catalogList as catalog>
                            <li id="li${catalog.id}">
                                <a href="/super/room/doShowRoomByCatalog?catalogId=${catalog.id}">${catalog.catalog}</a>
                                &nbsp; &nbsp;<a href="javascript:deleteCatalog(${catalog.id})">删除</a>
                            </li>
                        </#list>
                    </ul>
                </li>
                <li>
                    <a href="/super/promotion/doShowPromotion">促销信息管理</a>
                </li>
            </ul>
        </div>
        <a href="/admin/toOperate">返回首页</a>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
     function deleteCatalog(id) {
         if (confirm("确定删除该类型的房型吗？")){
             $.getJSON('/super/room/doDeleteCatalog?catalogId='+id,function (json) {
                 if(json.flag){
                     $('#li'+id).remove();
                     alert(json.message);
                 }else{
                     alert(json.message);
                 }
             })
         }
     }
</script>
</body>
</html>