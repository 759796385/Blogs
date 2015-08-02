<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>

        <script src="lib/jquery.peity.min.js"></script>
    <link rel="stylesheet" href="lib/fancy-zoom/css/fancyzoom.css" type="text/css" />
	<script type="text/javascript" src="lib/fancy-zoom/src/fancyzoom.js"></script>
    <script type="text/javascript">
        $(function() {
            $(".bar").peity("bar", { fill: ['#5cb85c'], height: 18, width: 32});
            $(".line").peity("line", {stroke: '#3c983c', fill: '#5cb85c', height: 18, width: 32});
			$('.thumb-md img').fancyZoom({closeOnClick: true, directory:'lib/fancy-zoom/img/'});
        });
    </script>


    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">

</head>
<body class=" theme-blue">


<!--Use of these features requires a premium license.-->
<!--See http://www.portnine.com/bootstrap-themes for details.-->
<!--After purchasing a premium license, the full source code will be available for download.-->


    <!-- Demo page code -->

    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>

    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="" href="index"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> Newtonk</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span> <s:property value="#session.user.name"/>
                    <i class="fa fa-caret-down"></i>
                </a>

              <ul class="dropdown-menu">
                <li><a href="./">My Account</a></li>
                <li class="divider"></li>
                <li class="dropdown-header">Admin Panel</li>
                <li><a href="./">修改密码</a></li>
                <li><a href="./">待定</a></li>
                <li><a tabindex="-1" href="./">待定</a></li>
                <li class="divider"></li>
                <li><a tabindex="-1" href="Logout">注销</a></li>
              </ul>
            </li>
          </ul>

        </div>
      </div>
    </div>
    

    <div class="sidebar-nav">
    <ul>
    <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i>博客管理<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">
            <li><a href="menu"><span class="fa fa-caret-right"></span> 主页</a></li>
            <li><a href="ArticleList"><span class="fa fa-caret-right"></span> 博客列表</a></li>
            <li ><a href="WriteArticle"><span class="fa fa-caret-right"></span> 写博客</a></li>
            <li ><a href="LabelList"><span class="fa fa-caret-right"></span> 标签管理</a></li>
            <li ><a href="CategoryList"><span class="fa fa-caret-right"></span> 分类管理</a></li>

    </ul></li>


    <li data-popover="true"  rel="popover" data-placement="right"><a href="#" data-target=".premium-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i> 日志<i class="fa fa-collapse"></i></a></li>
        <li><ul class="premium-menu nav nav-list collapse in">
            <li class="active"><a href="LoginLog"><span class="fa fa-caret-right"></span> 登陆日志</a></li>
            <li  ><a href="DoLog"><span class="fa fa-caret-right"></span> 操作日志</a></li>
        
    </ul></li>


        <li><a href="#" data-target=".legal-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-legal"></i>留言板管理 <i class="fa fa-collapse"></i></a></li>
        <li><ul class="legal-menu nav nav-list collapse in">
            <li ><a href="MessageList"><span class="fa fa-caret-right"></span> 留言动态 <span class="label label-info">+<s:property value="#session.noread"/></span></a></li>
        
    </ul></li>

       
            </ul>
    </div>

    <div class="content">
        <div class="header">
            
            <h1 class="page-title">Blogs</h1>
                    <ul class="breadcrumb">
            <li><a href="menu">主页</a> </li>
            <li class="active">登陆日志</li>
        </ul>

        </div>
        <div class="main-content">
            

</div>
<table class="table table-hover">
  <thead>
    <tr>
      <th>操作对象</th>
      <th>操作描述</th>
      <th>操作结果</th>
      <th>操作时间</th>
    </tr>
  </thead>
  <tbody>
  <s:iterator value="%{logs}" var="log">
    <tr>
      <td><s:property value="#log.object"/></td>
      <td><s:property value="#log.description"/></td>
      <td><s:property value="#log.result"/></td>
      <td><s:date format="yyyy-MM-dd HH:mm:ss" name="#log.date" /></td>
    </tr>
    </s:iterator>
  </tbody>
</table>

<ul class="pagination">
<!--动态插入-->
</ul>


            <footer>
                <hr>

                <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
                <p>© 2014 <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
            </footer>
        </div>
    </div>


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
    	// 分页算法(当前页，总共页，展示页)
    	var page = function(current,length,displayLength){
    		var index = [1];
    		//总页数小于展示长度
    		if(length<=displayLength){
    			//全部展示
    			for (var i = 2; i <= length; i++) {
    				index.push(i);	
    			};
    			return index;
    		}
    		displayLength = displayLength-2;
    		var start =  current-Math.floor(displayLength/2);
    		var end =  current+Math.floor(displayLength/2);
    		//首极限
    		if(start<2){
    			start = 2;
    			end = start+displayLength-1;
    			//保证length长度
    			if(end>length-1){
    			end = length - 1;
    			}
    		}
    		//尾极限
    		if(end>length-1){
    			end = length-1;
    			start = end-displayLength+1;
    			//保证length长度
    			if(start<2){
    				start = 2;
    			}
    		}
	    	if (start !== 2) {
	        	index.push("...");
		    }else{
		    	index.push("2");
		    }
		    for (var i = start+1; i <end; i++) {
		        index.push(i);
		    }
		    if (end !== length - 1) {
		        index.push("...");
		    }else{
		    	 index.push(end);
		    }
		    //最大页数
		    index.push(length);
		    return index;
    	}

        $("[rel=tooltip]").tooltip();
        $(function() {
        	var current =  <s:property value="%{pageNo}"/>;//当前页数
        	var length =<s:property value="%{pageSum}"/>;//总共页数
        	var displayLength = 9;//展现页数
        	var arr = page(current,length,displayLength);
        	//dom插入
        	$(".pagination").append("<li><a href='LoginLog?page="+(Number(current)-1)+"'>&laquo;</a></li>");
        	for(var i=0;i<arr.length;i++){
        		if(arr[i]!='...'){
        			$(".pagination").append("<li><a href='LoginLog?page="+Number(arr[i])+"'>"+arr[i]+"</a></li>");
        		}else{
        			$(".pagination").append("<li><a href='javascript:;'>"+arr[i]+"</a></li>");
        		}
        	}
        	$(".pagination").append("<li><a href='LoginLog?page="+(Number(current)+1)+"'>&raquo;</a></li>");


            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>
