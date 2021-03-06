<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>汽车市场调研系统</title>
	<meta name="keywords" content="">
	<meta name="description" content="">
	<meta name="renderer" content="webkit">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
	<link rel="stylesheet" href="/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="/css/main.css" media="all">
</head>
<body>
<div class="layui-layout">
	<!-- 头部区域 -->
	<div class="layui-header">
		<ul class="box">
			<li class="header-left">
				<a href="javascript:;" class="btnHeader flexible" title="侧边伸缩">
					<i class="layui-icon layui-icon-shrink-right"></i>
				</a>
				<a href="javascript:;" class="btnHeader refresh" title="刷新">
					<i class="layui-icon layui-icon-refresh-3"></i>
				</a>
			</li>
			<li class="header-right">
				<span class="navHeader">
					<div class="layui-nav">
						<div class="layui-nav-item">
							<a href="javascript:;">
								<cite>${admin.userName}</cite>
							</a>
							<dl class="layui-nav-child">
								<dd><a id="personalEdit">个人资料</a></dd>
								<dd><a id="personalPassword">修改密码</a></dd>
							</dl>
						</div>
					</div>
				</span>
				<a href="javascript:;" class="btnHeader logout">安全退出</a>
			</li>
		</ul>
	</div>
	<!-- 侧边菜单 -->
	<div class="layui-side">
		<div class="layui-side-scroll">
			<div class="layui-logo" lay-href="html/index.html">
				<span>汽车市场调研系统</span>
			</div>
			<ul class="layui-nav layui-nav-tree" lay-filter="nav">
				<li data-name="home" class="layui-nav-item layui-this">
					<a href="javascript:;" lay-href="/page/index" class="nav-tab" lay-id="home" data-type="tabChange" lay-tips="控制台">
						<i class="layui-icon layui-icon-theme"></i><label>控制台</label>
					</a>
				</li>
				<c:forEach var="role" items="${roles}" varStatus="item">
					<li data-name="template" class="layui-nav-item">
						<a href="javascript:;" lay-tips="${role.key}">
							<i class="layui-icon ${icons[item.index]}"></i><label>${role.key}</label>
						</a>
						<dl class="layui-nav-child">
							<c:forEach var="fun" items="${role.value}">
								<dd>
									<a lay-href="${fun.url}" class="nav-tab" lay-id="${fun.id}" data-type="tabAdd">
										<i class="layui-icon"></i><label>${fun.name}</label>
									</a>
								</dd>
							</c:forEach>
						</dl>
					</li>
				</c:forEach>
			</ul>
		</div>
	</div>
	<!-- 主体内容 -->
	<div class="layui-bodier">
		<div class="layui-tab" lay-filter="tab" lay-allowClose="true">
			<ul class="layui-tab-title">
				<li class="firstTab layui-this" lay-id="home">控制台</li>
			</ul>
			<div class="layui-tab-content">
				<div class="layui-tab-item layui-show">
					<iframe src="/page/index" frameborder="0" name="tabFrame" class="tabFrame"></iframe>
				</div>
			</div>
		</div>
	</div>
	<!-- 版权信息 -->
	<div class="layui-footer">
		<span>Copyright 2019 汽车市场调研系统 by: 张粟</span>
	</div>
</div>
</body>
<script src="/layui/layui.js" charset="utf-8"></script>
<script src="/js/main.js" charset="utf-8"></script>
</html>