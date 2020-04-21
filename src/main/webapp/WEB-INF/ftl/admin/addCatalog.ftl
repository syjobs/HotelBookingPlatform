<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HU酒店在线预订平台-添加房型类别</title>
    <link href="https://cdn.bootcss.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="font-family: 微软雅黑;">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <h3 class="text-center">
                添加房型类别
            </h3>
            <br/>
            <label style="color: red">${hint}</label>
            <br/>
        </div>
    </div>
    <div class="row clearfix">
        <div class="col-md-12 column">
            <form role="form" action="/super/room/doAddCatalog" method="post">
                <div class="form-group">
                    <label>房型类别</label>
                    <input type="text" class="form-control" name="catalog" required/>
                </div>
                <button type="submit" class="btn btn-default">添加</button>
            </form>
            <a href="/super/toSuper">返回上一页</a>
        </div>
    </div>
</div>
</body>
</html>