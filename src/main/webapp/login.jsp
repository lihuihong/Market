<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>汽车市场调研系统</title>
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="./layui/css/layui.css" media="all">
    <link rel="stylesheet" href="css/login.css" media="all">
</head>
<body>
<div class="layui-container">
    <div class="layui-row">
        <div class="layui-col-lg12 p1">
            <span><b>汽车市场调研系统</b><cite></cite></span><i>网站管理系统</i>
        </div>
    </div>
    <div class="layui-row">
        <div class="layui-col-lg12 p2">
            <div class="layui-col-lg6">&nbsp;</div>
            <div class="layui-col-lg6">
                <form class="layui-form">
                    <div class="box">
                        <div class="title"><span>用户登录</span><i>User login</i></div>
                        <div class="content">
                            <div class="layui-form-item t">
                                <div class="layui-form-label"><i class="layui-icon layui-icon-username"></i>账&nbsp;&nbsp;&nbsp;&nbsp;号：</div>
                                <div class="layui-input-block">
                                    <input type="text" name="userName" required lay-verify="required|user" placeholder="请输入账号" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item t">
                                <div class="layui-form-label"><i class="layui-icon layui-icon-password"></i>密&nbsp;&nbsp;&nbsp;&nbsp;码：</div>
                                <div class="layui-input-block">
                                    <input type="password" name="password" required lay-verify="required|pwd" placeholder="请输入密码" autocomplete="off" class="layui-input">
                                </div>
                            </div>
                            <div class="layui-form-item  t">
                                <div class="layui-form-label"><i class="layui-icon layui-icon-vercode"></i>验证码：</div>
                                <div class="layui-input-inline code">
                                    <input type="text" name="code" required lay-verify="required" placeholder="请输入验证码" autocomplete="off" class="layui-input">
                                </div>
                                <div class="layui-form-mid"><img src="/check" id="iCodeImage" alt="验证码" title="点击更换" /></div>
                            </div>
                            <div class="tips"></div>
                        </div>
                        <div class="btn">
                            <button class="layui-btn" lay-submit lay-filter="submit">立即登录</button>
                            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="p3">Copyright 2019 汽车市场调研系统 by 张粟</div>
</div>
</body>
<script src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use('form', function(){
        var form = layui.form;
        var $ = layui.jquery;

        form.verify({
            user: function(value, item){ //value：表单的值、item：表单的DOM对象
                if (/[\u4E00-\u9FA5]/g.test(value)) {
                    return '账号不能是汉字';
                }
                if (!(/^[\S]{5,16}$/).test(value)) {
                    return '账号必须5到16位，且不能出现空格'
        		}
                if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
                    return '用户名不能有特殊字符';
                }
                if(/(^\_)|(\__)|(\_+$)/.test(value)){
                    return '用户名首尾不能出现下划线\'_\'';
                }
                if(/^\d+\d+\d$/.test(value)){
                    return '用户名不能全为数字';
                }
            }

            //我们既支持上述函数式的方式，也支持下述数组的形式
            //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
            ,pwd: [
                /^[\S]{6,16}$/
                ,'密码必须6到16位，且不能出现空格'
            ]
        });

        //监听提交
        form.on('submit(submit)',function(data){
            $.ajax({
                url:'/user/login',
                type:'post',
                data:data.field,
                dataType:"json",
                beforeSend:function(){
                    //do something
                },
                success:function(data){
                    //do something
                    if(data.code==0){
                        location.href="/main";
                    } else {
                        $('.tips').text(data.msg);
                    }
                },
                error:function(data){
                    //do something
                    layer.msg('与服务器连接失败',{icon: 2});
                }
            });
            return false;
        });
        $('#iCodeImage').on('click',function(){
            $(this).attr('src','/check?' + Math.random());
        });
    });
</script>
</html>