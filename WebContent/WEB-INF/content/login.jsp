<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<html lang="en" class="no-js">

    <head>

        <meta charset="utf-8">
        <title>登录(Login)</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="">
        <meta name="author" content="">

        <!-- CSS -->
        <link rel="stylesheet" href="css/reset.css">
        <link rel="stylesheet" href="css/supersized.css">
        <link rel="stylesheet" href="css/Loginstyle.css">

        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->

    </head>

    <body>

        <div class="page-container">
            <h1>登录(Login)</h1>
            <form action="Login.action" method="post" class="form">
                <s:textfield type="name" name="user.name" class="username" placeholder="请输入您的用户名"/>
                <s:textfield type="password" name="user.password" class="password" placeholder="请输入您的用户密码" id="password"/>
                <div class="hide">
                    <input type="Captcha" name="jcaptcha" class="Captcha" placeholder="请输入验证码" required="required">
                    <img src="jcaptcha.jpg" alt="验证码" class="image"/>
                    <span  class="result"></span>
                </div>
                <button type="submit" class="submit_button">登录</button>
                <div class="error"><span>+</span></div>
            </form>
            <div class="connect">
                <p><s:actionmessage/></p>
            </div>
        </div>
        
        <script src="js/jquery-2.1.1.js" ></script>
        <script src="js/supersized.3.2.7.min.js" ></script>
        <script src="js/supersized-init.js" ></script>
        <script src="js/scripts.js" ></script>
        <script src="js/md5.js"></script>
        <script type="text/javascript">
            $(function(){
            	$("#password").val("");
                $(".form").submit(function(){
                    var password = $(".password").val();
                    $(".password").val(hex_md5(password)) ;
                    return true;
                    });
                $(".image").click(function(){
                    $(this).attr("src","jcaptcha.jpg")
                });
            });
        </script>
    </body>

</html>

