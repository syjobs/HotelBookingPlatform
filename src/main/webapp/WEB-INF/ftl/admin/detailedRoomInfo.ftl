<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HU酒店在线预订平台-房型详细信息</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
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
                </tr>
                </tbody>
            </table>
            <br/>
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
            <br/>
            <a href="doShowRoomByCatalog">返回上一页</a>
            &nbsp;&nbsp;
            <a href="/super/room/toAddPhoto?roomNum=${room.roomNum}">添加附图</a>
            &nbsp;&nbsp;
<#--            <a href="/super/room/comment/doShowCommentByRoom?roomNum=${room.roomNum}">查看该房型的评论</a>-->
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    function deleteOnePhoto(photoId) {
        if (confirm("确定删除该附图？")){
            $.getJSON('deleteOne?photoId='+photoId,function (data) {
                if(data){
                    $('#li'+photoId).remove();
                    alert('成功删除');
                }else{
                    alert('删除失败');
                }
            })
        }
    }
</script>
</body>
</html>