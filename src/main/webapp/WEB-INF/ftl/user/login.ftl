<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>HNU酒店在线预订平台-登录</title>
    <link href="https://cdn.bootcss.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="font-family: 微软雅黑;">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <br/>
            <h3 class="text-center" style="font-size: 26px;font-family: 微软雅黑;font-weight: bold;">
                欢迎登录HNU酒店在线预订平台
            </h3>
            <br/>
            <label style="color: red">${hint}</label>
            <br/>
            <form class="form-horizontal" role="form" action="/user/doLogin" method="post" id="loginForm" style="margin-left: 339px;font-family: 微软雅黑;">
                <div class="form-group">
                    <label class="col-sm-2 control-label">用户名</label>
                    <div class="col-sm-10">
                        <input required type="text" class="form-control" name="username" id="username" style="width: 399px;"/>
                    </div>
                </div>
                <div class="form-group">
                    <img class="col-sm-2 control-label" id="imageCode" src="../getImageCode" width="80" height="30"/>
                    <label id="idImageCodevalid"></label>
                    <div class="col-sm-10">
                        <input required type="text" class="form-control" name="code" id="imageCodeIn" style="width: 399px;"/>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">密码</label>
                    <div class="col-sm-10">
                        <input type="password" class="form-control" name="password" id="password" style="width: 399px;"/>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <input required type="submit" value="登录" class="btn btn-success"/>
                        &nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp; <a href="/toIndex">浏览首页</a>
                    </div>
                    <div class="col-sm-offset-2 col-sm-10">
                        提示账号/密码：Sy5_aaa / Sy123456
                    </div>
                </div>

            </form>

        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
    var isValid=false;
    $('#loginForm').on('submit',function(evt){
        evt.preventDefault();
        if(isValid){
            this.submit();
        }
    });

    $('#imageCodeIn').on('blur',function () {
        $.getJSON('doCheckCode?code='+$('#imageCodeIn').val(),function (json) {
            isValid=json.success;
            if (isValid){
                $('#idImageCodevalid').text('验证码正确').css('color', 'green');
            }else {
                $('#idImageCodevalid').text('验证码错误').css('color', 'red');
            }
        })
    });

    $('#imageCode').on('click',function () {
        $('#imageCode').attr('src','../getImageCode?'+new Date())
    })
</script>
</body>
</html>