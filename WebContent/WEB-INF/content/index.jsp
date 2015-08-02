<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>个人博客</title>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css"> 
	<script src="js/jquery-2.1.1.js" type="text/javascript"></script>
</head>
<body>
	<!-- 头部 -->
	<div class="container hd">
		<div class="title">
			<img src="image/head.png" class="img-circle img-responsive center-block" alt="头像">
			<h1>没有什么难的</h1>
		</div>
		<div class="navs">
			<ul class="nav nav-tabs">
				<li role="presentation"><a href="index">首页</a></li>
				<li role="presentation"><a href="list">归档</a></li>
				<li role="presentation"><a href="https://github.com/759796385">github</a></li>
				<li role="presentation"><a href="about.html">关于</a></li>
			</ul>
		</div>
	</div>
	<!-- 主体 -->
	<div class="container main"> 
		<div class="row">
			<!-- 博文显示区 -->
			<div class="col-md-9 content">
			<s:iterator  value="%{articles}" var="article">
				<div class="page">
					
				    	<h1><a href="read?id=<s:property value='#article.aid'/>"><s:property value="#article.title"/></a></h1>
				    	<p><s:property value="#article.remark"/></p> 
				    
			    	<div class="message"> 
			        	<span class="badge badge-success"><s:date format="dd/MM/yyyy" name="#article.date" /></span>
				        <!-- 阅读和喜欢 -->
				        <div class="sum">
				        	<span class="glyphicon glyphicon-comment"></span>
				        	<span><s:property value="#article.messages.size"/></span>
				        	<span class="glyphicon glyphicon-eye-open"></span>
				        	<span><s:property value="#article.view"/></span>
				        </div>
				        <div class="pull-right">
				        <s:iterator value='%{#article.labels}' var='label'>
				       
				        	<span class="label"> <s:property value='#label.name'/></span> 
				        	</s:iterator>
				        </div> 
			   		</div>  
		    		<hr>
		    	</div> 
		</s:iterator>

			 	<!-- 翻页 -->
			 	<nav>
			 	<form action="index" method="POST" id="formindex">	
				  <ul class="pager">
				   	 	<li  class="previous"><a id="previous" href="javascritp:;">上一页</a></li>
				    	<input type="hidden" name="pageNo" value="<s:property value='%{pageNo}'/>"/>
				    	<input type="hidden" name="pageSize" value="<s:property value='%{pageSize}'/>"/>
				    	<li  class="next"><a id="next" href="javascritp:;">下一页</a></li>
				  </ul>
				  </form>
				</nav>
		    </div> 
			<!-- 菜单显示区 -->
			<div class="menu col-md-3 hidden-xs">
				<form action="search" id="searchform" method="POST">
				<input type="" placeholder="搜索" class="search" id="search" name="search"  onkeypress="getKey();">
				</form>
				<!-- 分类 -->
				<div class="sort">
					<h4>分类</h2>
					<div class="list-group" id="category_list">
						<!-- ajax -->
					</div>
				</div>
				
				<!-- 标签 -->
				<div class="labels" >
					<h4>标签</h2>
						<div class="span-group" role="group" id="label_list">
							<!-- ajax -->
						</div>
				</div>
				<!-- weibo -->
				<div class="weibo">
					<div class="embed-responsive embed-responsive-4by3">
					<iframe width="100%" height="550" class="share_self"  frameborder="0" scrolling="no" src="http://widget.weibo.com/weiboshow/index.php?language=&width=0&height=550&fansRow=2&ptype=1&speed=0&skin=1&isTitle=0&noborder=0&isWeibo=1&isFans=0&uid=3142404422&verifier=e323b3f2&dpc=1"></iframe>
					</div>
				</div>
			</div> 
		</div>  
	</div>
	    <!-- 尾部 -->
    <div class="container ft">
    	<p>您是第
    		<a target="_blank" title="网店计数器" href="http://gostats.cn"><img alt="网店计数器" 
			src="http://c4.gostats.cn/bin/count/a_403257/t_7/i_3/z_0/show_hits/counter.png" 
			style="border-width:0" /></a>位访客
		</p>
		<p>
			<a href="Login" style="text-decoration: none;color:#333;">后台管理</a>|Powered by newtonk  | Theme by LOFTER.|湘ICP备15004649号-1
		</p>
	<script type="text/javascript">
		function getKey(){ 
				if(event.keyCode==13){
					var value  = document.getElementById("search");
					if(value.value!=null && value.value!="") 
					 document.getElementById("searchform").submit(); 
				}     
		}  
		$(function(){
			$.getJSON("json/label",function(data){
            		var $node = $("#label_list");
            		var obj = eval(data);
            		var label= obj.labels;
            		for(var index in label){
            			var key =index;
            			var value =label[index];
            			$node.append("<span class='label label-info'><a href='labels?id="+key+"'>"+value+"</a></span>");
            		}
            	});
			$.getJSON("json/category",function(data){
            		var $node = $("#category_list");
            		var obj = eval(data);
            		var category= obj.category;
            		for(var index in category){
            			var key =index;
            			var message = category[index];
            			for(var ca in message){
            				var name = ca;
            				var size  = message[ca];
            				$node.append("<a href='categorys?id="+key+"' class='list-group-item'>"+name+"<span class='badge'>"+size+"</span></a>");
            			}
            		}
            	});

			var $pageno = $(":input[name='pageNo']").val();
			$("#next").click(function(){
				$(":input[name='pageNo']").val(Number($pageno)+1);
				$("#formindex").submit();
			});
			$("#previous").click(function(){
				$(":input[name='pageNo']").val(Number($pageno)-1);
				$("#formindex").submit();
			});
		});
	</script>

    </div> 

</body>
</html>