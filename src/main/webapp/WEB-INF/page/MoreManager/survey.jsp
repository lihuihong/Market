
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/layui/css/layui.css" media="all">
    <style>
        #compare_con{
            text-align: center;
        }
        #compare_con p{
            line-height: 30px;
            background: #00BCD4;
            margin-bottom: 5px;
            padding: 3px 0px;
            color: white;
        }
        .layui-card-header{
            font-size: 20px;
            color: #2196f3;
        }
        .layui-card:last-child {
            margin-bottom: 0;
            height: 150px;
            padding: 10px;
            box-shadow: 0 0 15px rgba(152,152,152,0.3);
            border-radius: 10px;
        }
        .layui-card:last-child:hover {
            box-shadow: 0 0 15px rgba(30,160,250,0.4);
        }
    </style>
</head>
<body>
    <div style="padding: 50px 20px; background-color: #F2F2F2; height: 100%;">
        <div  class="layui-container">
        <div class="layui-row layui-col-space15" id="compare_con">
        </div>
        </div>
    </div>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script>

    layui.use(['table','form'], function() {
        var table = layui.table;
        var $ = layui.jquery;

        $.ajax({
            url:'/survey/findAll',
            type:'get',
            dataType:"json",
            success:function(data){
                //do something
                var html = '';
                if(data.code===0){
                    $.each(data.data,function(index,value){
                       html += "<div class=\"layui-col-md3\">" +
                           "<div class=\"layui-card\">" +
                           "<div class=\"layui-card-header\">"+value.surveyName+"</div>" +
                           "<div class=\"layui-card-body\">" +
                               value.surveyDesc
                           + "</div></div></div>"
                    });
                    $('#compare_con').html(html);
                } else {
                    layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                }
            },
        });

    });

</script>
</html>
