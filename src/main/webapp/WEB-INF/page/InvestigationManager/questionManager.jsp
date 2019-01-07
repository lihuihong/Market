<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="description" content="">
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
</head>
<body>
<div>
    <form class="layui-form">
        <div class="layui-form-item layui-elem-quote">
            <label class="layui-form-label">选择框</label>
            <div class="layui-input-block">
                <select name="surveyId" lay-filter="surveyId" id="surveyId">
                    <option value="4">旅行</option>
                </select>
            </div>
            <button type="button" class="layui-btn btnSearch" lay-filter="search" lay-submit>查询</button>
            <button type="button" class="layui-btn layui-btn-normal btnAdd">+ 新增题目</button>
        </div>
    </form>
    <table class="layui-hide" id="tableList" lay-filter="demo"></table>
</div>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/js/my.js" charset="utf-8"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-normal layui-btn-xs" lay-event="ok">通过</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="no">驳回</a>
</script>
<script>
    layui.use('table', function(){
        var table = layui.table;
        var $ = layui.jquery;
        //加载表格
        table.render({
            elem: '#tableList'
            ,url:'/question/list'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'questionContent', title: '问题', align:'center'},
                {field:'questionType',width:'40%', title: '类型', align:'center',style:'max-width: 90%;'},
                //{field:'rName', title: '联系人', align:'center'},
                {field:'surveyTime', title: '提交时间', align:'center',templet:function (row) {
                        return createTime(row.surveyTime);
                    }},
                //{field:'assessment', title: '状态', align:'center'},
                {fixed: 'right', width:260, title: '操作', align:'center', toolbar: '#barDemo'}
            ]],
            page: true
        });
        //重载表格
        $('.btnSearch').on('click',function(){
            table.reload('tableList',{
                page: {
                    curr: 1 //重新从第 1 页开始
                },
                where: {
                    'surveyId': $('#surveyId').val(),
                }
            });
        });

        //监听工具条
        table.on('tool(demo)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                layer.open({
                    title: '查看公司详情',
                    type: 2,
                    shade: false,
                    area: ['1200px', '500px'],
                    maxmin: true,
                    btnAlign: 'c',
                    anim: 0,
                    shade: [0.5, 'rgb(0,0,0)'],
                    content: '/admin/company/qualLook?id='+data.id,
                    zIndex: layer.zIndex, //重点1
                    success: function(layero){
                        //layer.setTop(layero); //顶置窗口
                    },
                    yes: function(index, layero){
                        //确认按钮
                    }
                });
            } else if(obj.event === 'ok'){
                layer.confirm('企业名称：'+data.cName, {icon: 3, title:'是否确定通过?'}, function(index){
                    $.ajax({
                        url:'/admin/company/updateAss',
                        type:'post',
                        data:{'id':data.id,'assessment':'2'},
                        dataType:"json",
                        beforeSend:function(){//console.log(JSON.stringify(data.field));
                        },
                        success:function(data){//do something
                            if(data.code==0){
                                layer.msg('通过成功！',{icon:1});
                            } else {
                                layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                            }
                        },
                        error:function(data){//do something
                            layer.msg('与服务器连接失败',{icon: 2});
                        }
                    });
                    layer.close(index);
                    layui.table.reload('tableList');
                });
            } else if(obj.event === 'no'){
                layer.confirm('企业名称：'+data.cName, {icon: 3, title:'是否确定驳回?'}, function(index){
                    $.ajax({
                        url:'/admin/company/updateAss',
                        type:'post',
                        data:{'id':data.id,'assessment':'0'},
                        dataType:"json",
                        beforeSend:function(){//console.log(JSON.stringify(data.field));
                        },
                        success:function(data){//do something
                            if(data.code==0){
                                layer.msg('驳回成功！',{icon:1});
                            } else {
                                layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                            }
                        },
                        error:function(data){//do something
                            layer.msg('与服务器连接失败',{icon: 2});
                        }
                    });
                    layer.close(index);
                    layui.table.reload('tableList');
                });
            }
        });
    });
</script>
</html>