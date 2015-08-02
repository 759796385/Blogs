<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!doctype html>
<html lang="en"><head>
    <meta charset="utf-8">
    <title>后台管理</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>

    

    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">
<link rel="stylesheet" href="editor/css/editormd.min.css" />
</head>
<body class=" theme-blue">

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

		.message>label{
			color: black;
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
            <li ><a href="menu"><span class="fa fa-caret-right"></span> 主页</a></li>
            <li><a href="ArticleList"><span class="fa fa-caret-right"></span> 博客列表</a></li>
            <li class="active"><a href="WriteArticle"><span class="fa fa-caret-right"></span> 写博客</a></li>
            <li ><a href="LabelList"><span class="fa fa-caret-right"></span> 标签管理</a></li>
            <li ><a href="CategoryList"><span class="fa fa-caret-right"></span> 分类管理</a></li>
    </ul></li>


    <li data-popover="true" data-content="查看博客记录." rel="popover" data-placement="right"><a href="#" data-target=".premium-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i> 日志<i class="fa fa-collapse"></i></a></li>
        <li><ul class="premium-menu nav nav-list collapse in">
            <li ><a href="LoginLog"><span class="fa fa-caret-right"></span> 登陆日志</a></li>
            <li ><a href="DoLog"><span class="fa fa-caret-right"></span> 操作日志</a></li>
         
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
            <li class="active">写博客</li>
        </ul>

        </div>
        <div class="main-content">

  <div class="container-fluid">
  		
        <form action="WriteArticle" method="POST">
        <div class="message" style="  margin: 0 50px 15px;">
        	<input type="hidden" name="article.id" value="<s:property value='%{article.aid}'/>"/>
        	<label>标题:</label><input type="text" placeholder="请输入标题" name="article.title" required="required" value="<s:property value='%{article.title}'/>">
        	<br>
			<!-- 选择类别 -->
			<!-- <s:select list="#{1:'WEB前端',2:'后端',3:'杂文'}" label="请选择类别"  listKey="key" listValue="value" name="article.category.cid"/>
			 -->
			 <label for="article_category_cid" class="label">请选择类别:</label>
			 <select name="article.category.cid" id="article_category_cid">
			 	
			 </select>	
	        <!-- 标签 -->
	        <label>标签:</label>
	        <input type="text" placeholder="标签~多个标签以,隔开" name="labels" value="<s:iterator value='%{article.labels}' var='label' status='st'><s:if test='#st.last'><s:property value='#label.name'/></s:if><s:else><s:property value='#label.name'/>,</s:else></s:iterator>">
			<br/>
			<label>摘要:</label>
	        <textarea  placeholder="输入摘要,用于简略显示" name="article.remark" cols="80%" rows="5" required="required"><s:property value='%{article.remark}'/></textarea>
 		</div>
        <div id="editormd">
            <textarea style="display:none;" name="article.text"><s:property value="%{article.text}"/></textarea>
        </div>
        <!-- token防止提交两次 -->
        <s:token></s:token>
        <input type="submit">

    </form>
    <script src="js/jquery-2.1.1.js"></script>
    <script src="editor/editormd.min.js"></script>
            <script src="lib/marked.min.js"></script>
        <script src="lib/prettify.min.js"></script>
        
        <script src="lib/raphael.min.js"></script>
        <script src="lib/underscore.min.js"></script>
        <script src="lib/sequence-diagram.min.js"></script>
        <script src="lib/flowchart.min.js"></script>
        <script src="lib/jquery.flowchart.min.js"></script>
        <script type="text/javascript">
            $(function() {
            	$.getJSON("json/category",function(data){
            		var $node = $("#article_category_cid");
            		var obj = eval(data);
            		var category= obj.category;
            		for(var index in category){
            			var key =index;
            			var message = category[index];
            			for(var ca in message){
            				var name = ca;
            				var size  = message[ca];
            				$node.append("<option value='"+key+"'>"+name+"</option>");
            			}
            		}
            	});

                editormd.emoji     = {
                    path  : "http://www.emoji-cheat-sheet.com/graphics/emojis/",
                    ext   : ".png"
                };
                // Twitter Emoji (Twemoji)  graphics files url path    
                editormd.twemoji = {
                    path : "http://twemoji.maxcdn.com/72x72/",
                    ext  : ".png"
                };
                var editor = editormd("editormd", {
                    path : "lib/", // Autoload modules mode, codemirror, marked... dependents libs path
                    width: "90%",
                    toc : true,
                    height: 640,
                    tocm            :true,
                    emoji           : true,
                    tex             : true,  // 默认不解析
                    flowChart       : true,  // 默认不解析
                    sequenceDiagram : true,
                    pageBreak : true,//分页符 [========]
                    atLink    : true,    // disable @link
                    emailLink : true,
                    htmlDecode : true,
                    taskList : true,
                    imageUpload    : true,
                    imageFormats   : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
                    imageUploadURL : "json/upload",//图片上传地址
                });

                
            });
    </script>
  </div>



            <footer>
                <hr>

                <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
                <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
                <p>© 2014 <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
            </footer>
        </div>
    </div>


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>
