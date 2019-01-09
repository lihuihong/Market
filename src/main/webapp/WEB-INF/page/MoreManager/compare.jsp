
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
    </style>
</head>
<body>
    <form class="layui-form" lay-filter="form">
        <div class="layui-form-item layui-elem-quote">
            <label class="layui-form-label">车品牌</label>
            <div class="layui-input-inline">
                <select name="vehicleId" lay-filter="vehicleId" id="vehicleId" lay-verify="required" >
                </select>
            </div>
            <button type="button" class="layui-btn btnAdd">添加对比</button>
        </div>
    </form>
    <fieldset class="layui-elem-field layui-field-title" style="margin-top:20px;">
        <legend>车型对比</legend>
    </fieldset>
    <div style="padding:20px; background-color: #F2F2F2;">
        <div  class="layui-container">
        <div class="layui-row layui-col-space15" id="compare_con">
            <div class="layui-col-md3">
                <div class="layui-card">
                    <div class="layui-card-header">车名</div>
                    <div class="layui-card-body">
                        <p>车品牌</p>
                        <p>车型</p>
                        <p>车色</p>
                        <p>装载人数</p>
                    </div>
                    <div class="layui-card-header">基础配置</div>
                    <div class="layui-card-body">
                        <p>发动机</p>
                        <p>最大马力</p>
                        <p>最大扭矩</p>
                        <p>变速箱</p>
                        <p>最高车速</p>
                    </div>
                    <div class="layui-card-header">更多配置</div>
                    <div class="layui-card-body">
                        <p>踏板</p>
                        <p>座椅</p>
                        <p>换挡拨片</p>
                        <p>后视镜</p>
                        <p>轮胎</p>
                        <p>车载导航</p>
                        <p>大灯</p>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script>

    layui.use(['table','form'], function() {
        var table = layui.table;
        var $ = layui.jquery;
        var form = layui.form;

        $.ajax({
            url:'/vehicle/findAll',
            type:'get',
            dataType:"json",
            success:function(dat){
                //do something
                var html = '';
                if(dat.code==0){
                    $.each(dat.data,function(index,value){
                        if (index === 0){
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

        var num = 0;

        function isEmToStr(str){
            return str==null ? "" :str;
        }

        //重载表格
        $('.btnAdd').on('click', function () {

            num++;
            if(num > 3){
                layer.alert("最多只能比较3辆车型！");
            }else{
                var comCon = $('#compare_con');
                $.ajax({
                    url:'/more/addCompare',
                    type:'post',
                    data:{vehicleId:$('#vehicleId').val()},
                    dataType:"json",
                    success:function(result){
                        //do something
                        if(result.code==0){

                            var vehicle = result.data.vehicle;
                            var data = result.data.data;
                            var configure = result.data.configure;

                            var newContent = "<div class=\"layui-col-md3\">\n" +
                                "<div class=\"layui-card\">\n" +
                                "<div class=\"layui-card-header\">"+vehicle.vehicleName+"</div>\n" +
                                "<div class=\"layui-card-body\">\n" +
                                "<p>"+vehicle.vehicleBrand+"</p>\n" +
                                "<p>"+vehicle.vehicleType+"</p>\n" +
                                "<p>"+vehicle.vehicleColor+"</p>\n" +
                                "<p>"+vehicle.vehicleNumber+"</p>\n" +
                                "</div>\n";
                            if(data == null){
                                newContent+="<div class=\"layui-card-header\"></div>\n" +
                                    "<div class=\"layui-card-body\">\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "</div>";
                            }else{
                                newContent+="<div class=\"layui-card-header\"></div>\n" +
                                    "<div class=\"layui-card-body\">\n" +
                                    "<p>"+data.dataEngine+"</p>\n" +
                                    "<p>"+data.dataPower+"</p>\n" +
                                    "<p>"+data.dataTorque+"</p>\n" +
                                    "<p>"+data.dataCase+"</p>\n" +
                                    "<p>"+data.dataSpeed+"</p>\n" +
                                    "</div>\n";
                            }

                            if(configure == null){
                                newContent+="<div class=\"layui-card-header\"></div>\n" +
                                    "<div class=\"layui-card-body\">\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "<p>暂无</p>\n" +
                                    "</div>\n" +
                                    "</div>\n" +
                                    "</div>";
                            }else{
                                newContent+="<div class=\"layui-card-header\"></div>\n" +
                                    "<div class=\"layui-card-body\">\n" +
                                    "<p>"+configure.configurePedal+"</p>\n" +
                                    "<p>"+configure.configureSeat+"</p>\n" +
                                    "<p>"+configure.configurePick+"</p>\n" +
                                    "<p>"+configure.configureMirror+"</p>\n" +
                                    "<p>"+configure.configureTyre+"</p>\n" +
                                    "<p>"+configure.configureCompass+"</p>\n" +
                                    "<p>"+configure.configureHeadlamps+"</p>\n" +
                                    "</div>\n" +
                                    "</div>\n" +
                                    " </div>";
                            }
                            comCon.append(newContent);
                        } else {
                            layer.alert('抱歉，系统繁忙，请稍后再试！',{icon:2});
                        }
                    },
                });

            }

        });


    });

</script>
</html>
