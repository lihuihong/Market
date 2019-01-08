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
            <label class="layui-form-label">问卷名称</label>
            <input type="hidden" name="questionId">
            <div class="layui-input-inline">
                <select name="surveyId" lay-filter="surveyId" id="surveyId">
                </select>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-label">问题</div>
            <div class="layui-input-block">
                <textarea name="questionContent" required lay-verify="required" placeholder="请输入问题"  class="layui-textarea"></textarea>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-form-label">类型</div>
            <div class="layui-input-inline">
                <select name="questionType" lay-filter="questionType" id="questionType">
                    <option value="A">单选</option>
                    <option value="B">多选</option>
                    <option value="C">填空</option>
                </select>
            </div>
        </div>
        <div class="layui-form-item item2" style="display: none">
            <div class="layui-form-label">填空回答答案</div>
            <div class="layui-input-inline">
                <input type="text" name="questionA" id="ans_A" placeholder="此空不填" class="layui-input" readonly>
            </div>
        </div>

        <div class="item1">
            <div class="layui-form-item">
                <div class="layui-form-label">选项A</div>
                <div class="layui-input-inline">
                    <input type="text" name="questionA" id="select_A"  placeholder="请输入选项" class="layui-input">
                </div>
                <div class="layui-form-label">选项B</div>
                <div class="layui-input-inline">
                    <input type="text" name="questionB"  placeholder="请输入选项" class="layui-input">
                </div>
            </div>
            <div class="layui-form-item">
                <div class="layui-form-label">选项C</div>
                <div class="layui-input-inline">
                    <input type="text" name="questionC"  placeholder="请输入选项" class="layui-input">
                </div>
                <div class="layui-form-label">选项D</div>
                <div class="layui-input-inline">
                    <input type="text" name="questionD" placeholder="请输入选项" class="layui-input">
                </div>
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

        $.ajax({
            url:'/survey/findAll',
            type:'get',
            dataType:"json",
            success:function(dat){
                //do something
                var html = '';
                if(dat.code==0){
                    $.each(dat.data,function(index,value){
                        if (data.surveyId === value.surveyId){
                            html += '<option value="'+value.surveyId+'" selected>'+value.surveyName+'</option>';
                        }else {
                            html += '<option value="'+value.surveyId+'">'+value.surveyName+'</option>';
                        }
                        //html += '<option value="'+value.surveyId+'">'+value.surveyName+'</option>';
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

        function selectCha(){
            if($('#questionType').val()=='A' || $('#questionType').val()=='B') {
                $('.item1').css('display','block');
                $('.item2').css('display','none');

            }else{
                $('.item2').css('display','block');
                $('.item1').css('display','none');
                $('#ans_A').val('');
            }
        }

        form.on('select(questionType)',function(data){
            selectCha();
        });


        form.val('form',{
            'questionId':data.questionId,
            'questionContent':data.questionContent,
            'questionType':data.questionType,
            'questionA':data.questionA,
            'questionB':data.questionB,
            'questionC':data.questionC,
            'questionD':data.questionD,
        });
        selectCha();
        form.render();

        //监听提交
        form.on('submit(submit)',function(data){

            layer.confirm('是否确定新增？',{icon: 3, title:'系统信息'},function(index){

                if($('#questionType').val()!='C'){
                    data.field.questionA = $('#select_A').val();
                }else{
                    data.field.questionA = '';
                }

                $.ajax({
                    url:'/question/save',
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