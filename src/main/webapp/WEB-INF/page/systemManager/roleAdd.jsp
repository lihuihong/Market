<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>用户管理</title>
	<meta name="description" content="">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="/resource/layui/css/layui.css" media="all">
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
				<div class="layui-form-label">角色名</div>
				<div class="layui-input-inline">
					<input type="hidden" id="id" name="id">
					<input type="text" name="name" id="name" required  placeholder="请输入角色名" autocomplete="off" class="layui-input" >
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-form-item">
					<label class="layui-form-label">功能模块</label>
					<div class="layui-input-block funn">
						<span class="funList">
							<input type="checkbox" name="funs" checked title="账号管理" />
						</span>
					</div>
				</div>
			</div>
			<div class="frameBtn">
				<button class="layui-btn" lay-submit lay-filter="submit">修改保存</button>
			</div>
		</form>
	</div>
</body>
<script src="/resource/layui/layui.js" charset="utf-8"></script>
<script>

layui.use(['form'], function(){
	var form = layui.form;
	var $ = layui.jquery;

	var funcids='';

    form.render();

    //获取功能列表
    $.ajax({
        url:'/role/allFun',
        type:'get',
        dataType:"json",
		async:false,
        beforeSend:function(){
            //console.log(JSON.stringify(data.field));
        },
        success:function(data){
            var funarr = funcids.split(',');
            //do something
            if(data.code==0){
                var str = '';
                for(i = 0;i<data.data.length;i++){
					var d = data.data[i].id;
					d = String(d);
					str += '<span class="funList"><input type="checkbox" name="funs" value="'+data.data[i].id+'" title="'+data.data[i].name+'" /></span>';
                }
                $('.funn').html(str);
                form.render('checkbox');
            } else {
                layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
            }
        },
        error:function(data){
            //do something
            layer.msg('与服务器连接失败',{icon: 2});
        }
    });


    //监听提交
    form.on('submit(submit)',function(data){
        var arr = new Array();
        $.each($('input:checkbox:checked'), function() {
            arr.push($(this).val());
        });
        if(arr.length == 0){
            layer.msg('请选择至少一个功能');
            return false;
        }
        var funIds = arr.join(',');
        data.field.funs=funIds;
        layer.confirm('是否确定修改？',{icon: 3, title:'系统信息'},function(index){
            $.ajax({
                url:'/role/save',
                type:'post',
                data:data.field,
                dataType:"json",
                beforeSend:function(){
                    console.log(JSON.stringify(data.field));
                },
                success:function(data){
                    //do something
                    if(data.code==0){
                        var index = parent.layer.getFrameIndex(window.name);//获取当前窗口索引
                        parent.layer.msg('修改成功', {icon : 1});
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
</html>