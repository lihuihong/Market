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
            <label class="layui-form-label">问卷名</label>
            <div class="layui-input-inline">
                <select name="surveyId" lay-filter="surveyId" id="surveyId">
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
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    layui.use(['table','form',], function(){
        var table = layui.table;
        var $ = layui.jquery;
        var form = layui.form;

        function merge(res) {

            var data = res.data;
            var columsName = ['questionA','questionB','questionC','questionD'];//需要合并的列名称

            var trArr = $(".layui-table-body>.layui-table").find("tr");//所有行
            for (var i = 1; i < res.data.length; i++) { //这里循环表格当前的数据
                var mark = 1; //这里涉及到简单的运算，mark是计算每次需要合并的格子数
                var tdCurArr = trArr.eq(i).find("td").eq(columsIndex[0]);//获取当前行的当前列
                for (var k = 1; k < columsName.length; k++) { //这里循环所有要合并的列
                    if (data[i][columsName[k]] === "") { //后一行的值与前一行的值做比较，相同就需要合并
                        mark += 1;
                        tdCurArr.each(function () {//当前行隐藏
                            $(this).css("colspan", mark);
                        });
                        var tdPreArr = trArr.eq(i).find("td").eq(columsIndex[k]);//获取当前行的当前列
                        tdPreArr.each(function () {//相同列的第一列增加rowspan属性
                            $(this).attr("display", "none");
                        });
                    }else {
                        mergeIndex = i;
                        mark = 1;//一旦前后两行的值不一样了，那么需要合并的格子数mark就需要重新计算
                    }
                }
            }
        }
        //加载表格
        table.render({
            elem: '#tableList'
            ,url:'/question/list'
            ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
            ,cols: [[
                {field:'questionContent', width:'30%',title: '问题', align:'center',style:'max-width:90%;'},
                {field:'questionType', title: '类型', align:'center',style:'max-width: 90%;',templet:function (d) {
                        switch (d.questionType) {
                            case 'A':
                                return '单选';
                            case 'B':
                                return '多选';
                            case 'C':
                                return '填空';
                        }
                    }},
                {field:'questionA', title: '选项A', align:'center',style:'max-width: 90%;'},
                {field:'questionB', title: '选项B', align:'center',style:'max-width: 90%;'},
                {field:'questionC', title: '选项C', align:'center',style:'max-width: 90%;'},
                {field:'questionD', title: '选项D', align:'center',style:'max-width: 90%;'},
                //{field:'rName', title: '联系人', align:'center'},
                {field:'questionTime', title: '提交时间', align:'center',templet:function (row) {
                        return createTime(row.questionTime);
                    }},
                //{field:'assessment', title: '状态', align:'center'},
                {fixed: 'right', width:260, title: '操作', align:'center', toolbar: '#barDemo'}
            ]],
            page: true,
            done:function (data) {
                //merge(data);
            }
        });

        $.ajax({
            url:'/survey/findAll',
            type:'get',
            dataType:"json",
            success:function(data){
                //do something
                var html = '';
                if(data.code==0){
                    $.each(data.data,function(index,value){
                        html += '<option value="'+value.surveyId+'">'+value.surveyName+'</option>';
                        //alert(html);
                    });
                    //alert(html);
                    $('#surveyId').html(html);
                    form.render('select');
                } else {
                    layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                }
            },
        });

        table.reload('tableList',{
            page: {
                curr: 1 //重新从第 1 页开始
            },
            where: {
                'surveyId': $('#surveyId').val(),
            }
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
        table.on('tool(demo)', function(obj) {
            var data = obj.data;
            if (obj.event == 'edit') {
                layer.open({
                    title: '编辑问题',
                    type: 2,
                    shade: false,
                    area: ['700px', '450px'],
                    maxmin: true,
                    btnAlign: 'c',
                    anim: 0,
                    shade: [0.5, 'rgb(0,0,0)'],
                    content: '/page/InvestigationManager/questionEdit',
                    zIndex: layer.zIndex, //重点1
                    success: function (layero,index) {
                        // 获取子页面的iframe
                        var iframe = window['layui-layer-iframe' + index];
                        // 向子页面的全局函数child传参
                        iframe.child(data);
                        //layer.setTop(layero); //顶置窗口
                    },
                    yes: function (index, layero) {
                        //确认按钮
                    }
                });
            }else if(obj.event == 'del'){
                layer.confirm('名称：'+data.questionContent, {icon: 3, title:'是否确定删除?'}, function(index){
                    $.ajax({
                        url:'/quetsion/delete',
                        type:'post',
                        data:{'id':data.questionId},
                        dataType:"json",
                        beforeSend:function(){//console.log(JSON.stringify(data.field));
                        },
                        success:function(data){//do something
                            if(data.code==0){
                                layer.msg('恭喜，删除成功！',{icon:1});
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
        //新增账号
        $('.btnAdd').on('click',function(){
            layer.open({
                title: '新增问题',
                type: 2,
                shade: false,
                area: ['700px', '450px'],
                maxmin: true,
                btnAlign: 'c',
                anim: 0,
                shade: [0.5, 'rgb(0,0,0)'],
                content: '/page/InvestigationManager/questionAdd',
                zIndex: layer.zIndex, //重点1
                success: function(layero){
                    //layer.setTop(layero); //顶置窗口
                },
                yes: function(index, layero){
                    //确认按钮
                }
            });
        });

    });
</script>
</html>