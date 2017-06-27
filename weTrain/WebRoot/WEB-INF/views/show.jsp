<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>页面测试</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
	<!--<link rel="stylesheet" href="http://res.wx.qq.com/open/libs/weui/0.4.0/weui.min.css">
	<link rel="stylesheet" type="text/css" href="styles.css">-->
	
  <link rel="stylesheet" href="${ctx }/static/weui/weui.min.css" type="text/css"></link>
  <script type="text/javascript" src="${ctx }/static/jquery/jquery-1.9.1.min.js"></script>
  <script type="text/javascript" src="${ctx }/static/weui/weui.min.js"></script>
  
  </head>
  
  <body ontouchstart>
  
		
		<a href="javascript:;" class="weui_btn weui_btn_disabled weui_btn_primary">按钮</a>
		<a href="javascript:;" class="weui_btn weui_btn_warn">确认</a>
		<a href="javascript:;" class="weui_btn weui_btn_disabled weui_btn_warn">确认</a>
		<a href="javascript:;" class="weui_btn weui_btn_default">按钮</a>
		<a href="javascript:;" class="weui_btn weui_btn_disabled weui_btn_default">按钮</a>
		<div class="button_sp_area">
		    <a href="javascript:;" class="weui_btn weui_btn_plain_default">按钮</a>
		    <a href="javascript:;" class="weui_btn weui_btn_plain_primary">按钮</a>
		
		    <a href="javascript:;" class="weui_btn weui_btn_mini weui_btn_primary">按钮</a>
		    <a href="javascript:;" class="weui_btn weui_btn_mini weui_btn_default">按钮</a>
		</div>
		
		<div class="weui_msg">
	    <div class="weui_icon_area"><i class="weui_icon_success weui_icon_msg"></i></div>
	    <div class="weui_text_area">
	        <h2 class="weui_msg_title">操作成功</h2>
	        <p class="weui_msg_desc">内容详情，可根据实际需要安排</p>
	    </div>
	    <div class="weui_opr_area">
	        <p class="weui_btn_area">
	            <a href="javascript:;" class="weui_btn weui_btn_primary">确定</a>
	            <a href="javascript:;" class="weui_btn weui_btn_default">取消</a>
	        </p>
	    </div>
	    <div class="weui_extra_area">
	        <a href="">查看详情</a>
    </div>
</div>
  </body>
</html>
