<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="/layui/css/layui.css" media="all">
	<style>
	.frameContent {padding:30px 30px 0px 0px}
	.roleList {float:left;margin:5px 0px;width:33%}
	.frameBtn {text-align:center;margin:20px 0px 0px 30px;padding-top:20px;border-top:1px rgb(204,204,204) dashed}
	</style>
</head>
<body>
	<div>
		<form class="layui-form frameContent">
			<div class="layui-form-item">
				<div class="layui-form-label">旧密码</div>
				<div class="layui-input-block">
					<input type="hidden" name="id" />
					<input type="text" name="password1" required lay-verify="pwd" placeholder="请输入旧密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-form-label">新密码</div>
				<div class="layui-input-block">
					<input type="password" name="password2" required lay-verify="pwd" placeholder="请输入新密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-form-label">确认新密码</div>
				<div class="layui-input-block">
					<input type="password" name="password3" required lay-verify="pwd" placeholder="请输入新密码" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="frameBtn">
				<button class="layui-btn" lay-submit lay-filter="submit">修改保存</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</form>
	</div>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script>
layui.use(['form','layer'], function(){
	var form = layui.form;
	var layer = layui.layer;
	var $ = layui.jquery;
	form.verify({
		//我们既支持上述函数式的方式，也支持下述数组的形式
		//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
		pwd: [
			/^[\S]{6,16}$/
			,'密码必须6到16位，且不能出现空格'
		]
	});
	//监听提交
	form.on('submit(submit)',function(data){
		layer.confirm('是否确定修改密码？', {icon: 3, title:'系统信息'}, function(index){
			$.ajax({
				url:'/user/updatePwd',
				type:'post',
				data:data.field,
				dataType:"json",
				beforeSend:function(){
					//console.log(JSON.stringify(data.field));
					if(data.field.password2!=data.field.password3){
						layer.msg('抱歉，两次新密不一致，请重新输一次！',{icon:2});
						$('input[name="password2"]').focus();
						layer.close(index);
						return false;
					}
				},
				success:function(data){
					//do something
					if(data.code==0){
						var index = parent.layer.getFrameIndex(window.name);//获取当前窗口索引
						parent.layer.msg('修改成功', {icon : 1});
						parent.layer.close(index);
					} else {
						layer.alert(data.msg,{icon:2});
					}
				},
				error:function(data){
					//do something
					layer.msg('与服务器连接失败',{icon: 2});
				}
			});
		});
		return false;
	});
});
</script>
</html>