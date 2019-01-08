<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/resource/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/resource/css/login.css" media="all">
    <title>服装销售管理</title>
	<script type="text/javascript">

	</script>
</head>

<body>
<form class="layui-form" lay-filter="form" style="padding: 20px 50px 20px 20px">
    <div class="layui-form-item">
        <label class="layui-form-label">用户名</label>
        <div class="layui-input-inline">
            <input type="hidden" name="id">
            <input type="text" name="userName" required lay-verify="required" placeholder="请输入用户名" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="text" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">真实姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="trueName" required lay-verify="required" placeholder="请输入真实姓名" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="email"  placeholder="请输入邮箱" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">电话</label>
        <div class="layui-input-inline">
            <input type="text" name="phone"  placeholder="请输入电话" autocomplete="off" class="layui-input">
        </div>
        <label class="layui-form-label">角色</label>
        <div class="layui-input-inline">
            <select name="roleId" id="role" lay-verify="required">
            </select>
        </div>
    </div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
</body>
<script src="/resource/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','laydate'], function() {
        var form = layui.form;
        var $ = layui.jquery;
        var laydate = layui.laydate;

        $.ajax({
            url:'/role/findAll',
            type:'get',
            dataType:"json",
            success:function(data){

                var html = '';
                if(data.code==0){
                    $.each(data.data,function(index,value){
                        html += '<option value="'+value.id+'">'+value.name+'</option>';
                        //alert(html);
                    });
                    //alert(html);
                    $('#role').html(html);
                    form.render('select');
                } else {
                    layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                }
            },
        });

        //监听提交
        form.on('submit(formDemo)', function(data){
            layer.confirm('是否确定新增？',{icon: 3, title:'系统信息'},function(index){
                $.ajax({
                    url:'/user/save',
                    type:'post',
                    data:data.field,
                    dataType:"json",
                    beforeSend:function(){
                        //console.log(JSON.stringify(data.field));
                    },
                    success:function(data){
                        //do something
                        if(data.code==0){
                            var index = parent.layer.getFrameIndex(window.name);//获取当前窗口索引
                            parent.layer.msg('添加成功', {icon : 1});
                            parent.layer.close(index);
                            parent.layui.table.reload('tableList');//重新加载父级tabel数据
                        } else {
                            layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                        }
                    },
                    error:function(data){
                        //do something
                        layer.msg('与服务器连接失败',{icon: 2});
                    }
                });
                layer.close(index);
            });
            return false;
        });

    });

</script>
	
</body>
</html>