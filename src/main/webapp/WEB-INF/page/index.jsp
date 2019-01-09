<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>汽车市场调研系统</title>
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="/css/main.css" media="all">
</head>
<body>
<div class="layui-layout" style="height: 100%">
	<fieldset class="layui-elem-field layui-field-title" style="margin-top:20px;">
		<legend>控制台页面</legend>
	</fieldset>
	<div style="padding:20px 0px 50px 0px; background-color: #F2F2F2; height: 100%;">
		<div  class="layui-fluid">
			<div class="layui-row layui-col-space15" id="compare_con">
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header">
							作者心语
						</div>
						<div class="layui-card-body layui-text layadmin-text">
							<p>我呕心沥血完成了这个项目，希望能回家过个好年!</p>
							<p>噗...</p>
							<p style="text-align: right;">—— 张粟</p>
						</div>
					</div>

					<div class="layui-card">
						<div class="layui-card-header">
							功能模块
						</div>
						<div class="layui-card-body layui-text layadmin-text">
							<div class="layui-btn-container" id="fun">

							</div>
						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header">
							项目名称
						</div>
						<div class="layui-card-body layui-text layadmin-text">
							<p>汽车市场调研系统</p>
						</div>
					</div>
					<div class="layui-card">
						<div class="layui-card-header">
							技术支持
						</div>
						<div class="layui-card-body layui-text layadmin-text">
							<p>张粟</p>
						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<div class="layui-card">
						<div class="layui-card-header">版本信息</div>
						<div class="layui-card-body layui-text">
							<table class="layui-table">
								<colgroup>
									<col width="100"><col>
								</colgroup>
								<tbody>
									<tr>
										<td>当前版本</td>
										<td>v 1.0 pro</td>
									</tr>
									<tr>
										<td>基于框架</td>
										<td>layui-v2.4.5</td>
									</tr>
									<tr>
										<td>主要特色</td>
										<td>清爽 / 极简 / 颜色鲜艳</td>
									</tr>
									<tr>
										<td>获取渠道</td>
										<td style="padding-bottom: 0;">
											<div class="layui-btn-container">
												<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-normal">不  给</button>
											</div>
										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</div>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script>
	layui.use("jquery",function() {
		var $ = layui.jquery;

		//获取功能列表
		$.ajax({
			url:'/role/findUserFun',
			type:'get',
			dataType:"json",
			async:false,
			beforeSend:function(){
				//console.log(JSON.stringify(data.field));
			},
			success:function(data){
				if(data.code==0){
					var str = '';
					for(i = 0;i < data.data.length;i++){
						str += '<button class="layui-btn layui-btn-sm layui-btn-radius layui-btn-normal">'+data.data[i]+'</button>';
					}
					$('#fun').html(str);
				}
			},
		});

	});
</script>
</html>