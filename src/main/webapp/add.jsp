<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="jquery-1.8.2.min.js"></script>
</head>
<script type="text/javascript">
	$(function(){
		$.post("findfenlei.do",function(date){
			var str="";
			for(var i in date){
				str+="<input type='checkbox' value='"+date[i].id+"' name='fname'>"+date[i].fname+"";
			}
			$("#d").html(str);
		},"json");
	})
</script>
<body>
<form action="">
	电影名称:<input type="text" name="dname" id="dname"><br><br>
	电影介绍:<input type="text" name="jieshao" id="jieshao"><br><br>
	导演:<input type="text" name="daoyan" id="daoyan"><br><br>
	发行时间:<input type="text" name="startdate" id="startdate"><br><br>
	类型:<div id="d">
		<input type="checkbox" value="" name="fname">
	</div><br>
	<input type="button" value="提交" onclick="tj()">
</form>
</body>
<script type="text/javascript">
	function tj(){
		$.post("insertOne.do",$("form").serialize(),function(Date){
			if(Date){
				alert("添加电影成功");
				var a=confirm("点击确定回到主页");
				if(a){
					location.href="list.do";
				}
			}
		})
	}
</script>
</html>