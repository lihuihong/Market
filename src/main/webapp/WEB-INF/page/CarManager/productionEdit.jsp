<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <style>
        .frameContent {padding:30px 30px 0px 0px}
        .roleList {float:left;margin:5px 0px;width:33%}
        .frameBtn {text-align:center;margin:20px 0px 0px 30px;padding-top:20px;border-top:1px rgb(204,204,204) dashed}
    </style>
</head>
<body>
<div>
    <form class="layui-form frameContent" lay-filter="form">
        <div class="layui-form-item">
            <label class="layui-form-label">车名</label>
            <input type="hidden" name="productionId">
            <div class="layui-input-inline">
                <select name="vehicleId" lay-filter="vehicleId" id="vehicleId">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">车辆售价</label>
            <div class="layui-input-inline">
                <input type="text" placeholder="请输入车辆售价" name="productionPrice" id="productionPrice"  lay-verify="required|number" class="layui-input">
            </div>

        </div>
        <div class="layui-form-item">
            <div class="layui-form-label">车辆产销数</div>
            <div class="layui-input-inline">
                <input type="text" placeholder="请输入车辆产销数" name="productionNumber" id="productionNumber" lay-verify="required|number" class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-label">车辆销售额</div>
            <div class="layui-input-inline">
                <input type="text" placeholder="请输入车辆销售额" name="productionVolume" id="productionVolume" lay-verify="required|number" readonly class="layui-input">
            </div>
        </div>
        <div class="frameBtn">
            <button class="layui-btn" lay-submit lay-filter="submit">确认添加</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </form>
</div>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script>

    var data;
    function child(d){
        data = d;
    }

    layui.use(['form'], function(){
        var form = layui.form;
        var $ = layui.jquery;

        form.val('form',{
            'productionId':data.productionId,
            'productionPrice':data.productionPrice,
            'productionNumber':data.productionNumber,
            'productionVolume':data.productionPrice * data.productionNumber,
        });
        form.render();

        $.ajax({
            url:'/vehicle/findAll',
            type:'get',
            dataType:"json",
            success:function(dat){
                //do something
                var html = '';
                if(dat.code==0){
                    $.each(dat.data,function(index,value){
                        if (data.vehicleId === value.vehicleId){
                            html += '<option value="'+value.vehicleId+'" selected>'+value.vehicleName+'</option>';
                        }else {
                            html += '<option value="'+value.vehicleId+'">'+value.vehicleName+'</option>';
                        }
                    });
                    $('#vehicleId').html(html);
                    form.render('select');
                } else {
                    layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                }
            },
        });

        $('#productionPrice').blur(function () {
            if($('#productionNumber').val() != ''){
                $('#productionVolume').val(Number($('#productionPrice').val()) * Number($('#productionNumber').val()));
            }
        });

        $('#productionNumber').blur(function () {
            if($('#productionPrice').val() != ''){
                $('#productionVolume').val(Number($('#productionPrice').val()) * Number($('#productionNumber').val()));
            }
        });

        //监听提交
        form.on('submit(submit)',function(data){

            layer.confirm('是否确定修改？',{icon: 3, title:'系统信息'},function(index){
                $.ajax({
                    url:'/production/save',
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
</html>