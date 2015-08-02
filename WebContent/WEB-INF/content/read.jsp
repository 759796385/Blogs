<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*,com.tq.entity.Message" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>个人博客</title>
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" href="editor/css/editormd.min.css" />
	<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<style type="text/css">
	#other{
		background-color: white;
		padding-left: 10px;
		padding-bottom: 10px;
	}
	.jiathis_style{
		margin-left: 20px;
	}
	</style>
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

		  	<div id="editormd" class="col-md-12" >
		  	<h1><s:property value="%{article.title}"/></h1>

<textarea style="display:none;">
<s:property value="%{article.text}"/>
</textarea>

		  	</div>
	<div id="other">
		<span class="badge badge-important"><s:date format="dd/MM/yyyy" name="%{article.date}" /></span>
		<s:iterator value='%{article.labels}' var='label'>
			<span class="label label-info"> <s:property value='#label.name'/></span> 
		</s:iterator>
<div class="jiathis_style" style="display:inline-block;">
	<a class="jiathis_button_qzone"></a>
	<a class="jiathis_button_tsina"></a>
	<a class="jiathis_button_tqq"></a>
	<a class="jiathis_button_weixin"></a>
	<a class="jiathis_button_renren"></a>
	<a href="http://www.jiathis.com/share" class="jiathis jiathis_txt jtico jtico_jiathis" target="_blank"></a>
	<a class="jiathis_counter_style"></a>
</div>

	</div>
		  </div>
		<div class="msgboard">
			<ul class="container">
			<!-- 回复 -->
			<s:iterator value="%{messagesList}" var="messages">
				<%-- 根节点list--%>
				<s:iterator value="#messages" var="message" status="length">
				<%-- 根节点 --%>
				<s:if test="#message.parentmsg==null">  
				<li class="media">
	  				<div class="media-left">
				      	<img class="media-object" src="image/img.png" alt="头像">	
				  	</div>
				  	<div class="media-body">
				    	<h4 class="media-heading"> <s:property value="#message.name" escape="true" /></h4>
				    	<p><s:property value="#message.text" escape="true" /></p>
				    	<div class="repmsg">
				    		<s:date format="yyyy-MM-dd HH:mm:ss" name="#message.date" />
				    		<a href="javascript:;" class="pull-right comment-reply">回复</a>
				    	</div>
				    	<div class="repform hidden">
				    			<form class="form-horizontal" action="message" method="POST">
									<div class="form-group">
									    <div class="col-md-3">
					      					<input type="text" class="form-control" name="message.name" id="exampleInputName2" placeholder="输入昵称" required="required">
					      					<input type="hidden" name="message.parentmsg.mid" value="<s:property value='#message.mid'/>">
				    						<input type="hidden" name="message.article.aid" value="<s:property value='%{article.aid}'/>">
					    				</div>
									 </div>
									 <div class="form-group">
									 	<div class="col-md-12">
									 		<textarea class="form-control" required="required" name="message.text" rows="3" placeholder="输入内容,不支持md语法哦"></textarea>
									 	</div>
									 </div>
									 <div class="form-group">
									 		<button type="submit" class="btn btn-default pull-right">回复</button>
									 </div>
								</form>
				    	</div><!--div class="repform hidden"-->
				    	</s:if>
				    	<!-- 楼中楼 -->
				    	<s:else>
				    		<div class="media">
				    		<div class="media-left">
				      			<img class="media-object" src="image/img.png" alt="头像">	
				  			</div>
						  	<div class="media-body">
						    	<h4 class="media-heading"> <s:property value="#message.name" escape="true" /></h4>
						    	<p><s:property value="#message.text" escape="true" /></p>
						    	<div class="repmsg">
						    		<s:date format="yyyy-MM-dd HH:mm:ss" name="#message.date" />
						    		<a href="javascript:;" class="pull-right comment-reply">回复</a>
						    	</div>
						    	<div class="repform hidden">
						    			<form class="form-horizontal" action="message" method="POST">
											<div class="form-group">
											    <div class="col-md-3">
							      					<input type="text" class="form-control" name="message.name" id="exampleInputName2" placeholder="输入昵称" required="required">
							      					<input type="hidden" name="message.parentmsg.mid" value="<s:property value='#message.mid'/>">
						    						<input type="hidden" name="message.article.aid" value="<s:property value='%{article.aid}'/>">
							    				</div>
											 </div>
											 <div class="form-group">
											 	<div class="col-md-12">
											 		<textarea class="form-control" required="required" name="message.text" rows="3" placeholder="输入内容,不支持md语法哦"></textarea>
											 	</div>
											 </div>
											 <div class="form-group">
											 		<button type="submit" class="btn btn-default pull-right">回复</button>
											 </div>
										</form>
						    	</div>
						    </div>
						    </div>
				    	</s:else>
				    	<s:if test="#length.last">
					</div><!--div class=media-body-->
				</li><!--li class=media-->
				</s:if>
				</s:iterator>
			</s:iterator>
			</ul>
		</div>
		<!-- 留言板 -->
			<form class="form-horizontal" action="message" method="POST">
				<div class="form-group">
				    <label for="name" class="col-md-2 control-label">Name</label>
				    <input type="hidden" name="message.article.aid" value="<s:property value='%{article.aid}'/>">
				    <div class="col-md-4">
      					<input type="text" class="form-control" name="message.name" id="exampleInputName2" placeholder="输入昵称" required="required">
    				</div>
				 </div>
				 <div class="form-group">
				 	<label for="name" class="col-md-2 control-label">留言内容</label>
				 	<div class="col-md-5">
				 		<textarea class="form-control" name="message.text" rows="3" placeholder="输入内容,不支持md语法哦" required="required"></textarea>
				 	</div>
				 </div>
				 <div class="form-group">
				 	<div class="col-md-5 col-md-push-2">
				 		<button type="submit" class="btn btn-default pull-right">留言</button>
				 	</div>
				 </div>
			</form>
		</div>
	</div>

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
		 		$(".comment-reply").click(function(event){
		 			var name = $(this).parent().parent().children("h4").text();
		 			var text = $(this).parent().parent().children("p").text();
		 			var $form = $(this).parent().next();
		 			$form.find("textarea").html("回复"+name+":  ");
		 			var sty = $form.attr('class');
		 			if(sty=="repform hidden"){
		 				$form.removeClass("hidden");
		 			}else{
		 				$form.addClass("hidden");
		 			}
		 		})

		        var editor = editormd.markdownToHTML("editormd", {
		            path : "lib/", // Autoload modules mode, codemirror, marked... dependents libs path
		            width: "90%",
        			tocm    		:true,
        			emoji           : true,
        			tex             : true,  // 默认不解析
                    flowChart       : true,  // 默认不解析
                    sequenceDiagram : true,
                    pageBreak : true,//分页符 [========]
                    atLink    : true,    // disable @link
        			emailLink : true,
        			taskList : true,
		        });
		    });
	</script>

	    <!-- 尾部 -->
    <div class="container ft">
    	<p>您是第
    		<a target="_blank" title="网店计数器" href="http://gostats.cn"><img alt="网店计数器" 
			src="http://c4.gostats.cn/bin/count/a_403257/t_7/i_3/z_0/show_hits/counter.png" 
			style="border-width:0" /></a>位访客
		</p>
		<p>
			Powered by newtonk  | Theme by LOFTER.|湘ICP备15004649号-1
		</p>
		
    </div> 
    <script type="text/javascript" src="http://v3.jiathis.com/code_mini/jia.js" charset="utf-8"></script> 
</body>
</html>