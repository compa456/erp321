<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Sign On</title>
    <link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/bootstrap/css/bootstrap.min.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/jquery-easyui/themes/default/easyui.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/jquery-easyui/themes/icon.css'/>"/>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/js/jquery-easyui/demo/demo.css'/>">
	<script type="text/javascript" src="<c:url value='/resources/js/jquery-easyui/jquery.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/bootstrap/js/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-easyui/jquery.easyui.min.js'/>"></script>
	<script type="text/javascript">
		$(function(){
			var url="<c:url value='/framework/login!login.action'/>";
			$('#loginBtn').click(function(){
				$.ajax({
					  type: "POST",
					  url: url,
					  data: $("#loginForm").serialize(),
					  dataType:'json',
					  beforeSend:function( ){
						  return $("#loginForm").form('validate');
					  },
					  success: function(success){
						  if(success){
							  location.href="<c:url value='/framework/login!initMenuAuthorities.action'/>";
						  }else{
							  $('#msg').text("登陆失败：请检查用户名密码");
						  }
					  }
					});
			})
		})
	</script>
</head>

<body>
<form id="loginForm">
    <div class="container">
        <section class="loginBox row-fluid">
          <section class="span7 left">
            <h2>用户登录</h2>
            <p><input type="text" name="loginAccount.loginName" placeholder="Login Name" class="easyui-validatebox" data-options="required:true"></p>
            <p><input type="password" name="password" placeholder="Password" class="easyui-validatebox" data-options="required:true"></p>
            <p>
	            <select name="loginAccount.lang">
				  <option value="zh">简体中文</option>
				  <option value="en">English</option>
				</select>
			</p>
            <section class="row-fluid">
              <section class="span8 lh30"><label><input type="checkbox" name="rememberme">下次自动登录</label></section>
          <section class="span1"><input id="loginBtn" type="button" value=" 登录 " class="btn btn-primary"></section>
            </section>
          </section>
          <section class="span5 right">
            <h2>浏览器支持</h2>
            <section>
              <p>请使用支持HTML5的浏览器：Safari，Firefox，Chrome，IE9+</p>
              <p>HTML5 web browser support：Safari，Firefox，Chrome，IE9+</p>
              <p><font id="msg" color="red"></font></p>
            </section>
          </section>
        </section>
    </div> 
 
</form> 


    	<style>*{margin:0;padding: 0;}
      body{background: #444 url(<c:url value='/resources/img/carbon_fibre_big.png'/>)}
      .loginBox{width:420px;height:230px;padding:0 20px;border:1px solid #fff; color:#000; margin-top:40px; border-radius:8px;background: white;box-shadow:0 0 15px #222; background: -moz-linear-gradient(top, #fff, #efefef 8%);background: -webkit-gradient(linear, 0 0, 0 100%, from(#f6f6f6), to(#f4f4f4));font:11px/1.5em 'Microsoft YaHei' ;position: absolute;left:50%;top:50%;margin-left:-210px;margin-top:-115px;}
      .loginBox h2{height:45px;font-size:20px;font-weight:normal;}
      .loginBox .left{border-right:1px solid #ccc;height:100%;padding-right: 20px; }</style>
	    		<script></script>
	
</body>
</html>
