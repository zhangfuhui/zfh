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
<body>
<a href="add.jsp"><input type="button" value="添加"></a>
<input type="button" value="批量删除" onclick="pl()">
<form action="list.do" method="post">
电影名称:<input type="text" name="dname">
<input type="submit" value="搜索">
	</form>
	<table>
		<tr>
			<td>
				<input type="button" value="全选/全不选" onclick="quan()">
				<input type="button" value="反选" onclick="fan()">
			</td>
			<td>编号</td>
			<td>电影名称</td>
			<td>电影介绍</td>
			<td>导演</td>
			<td>发行时间</td>
			<td>类型</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${page.list }" var="l">
			<tr>
				<td>
					<input type="checkbox" value="${l.id }" name="ck">
				</td>
				<td>${l.id }</td>
				<td>${l.dname }</td>
				<td>${l.jieshao }</td>
				<td>${l.daoyan }</td>
				<td>${l.startdate }</td>
				<td>${l.fname }</td>
				<td>
					<a href="updatee.jsp?id=${l.id }"><input type="button" value="修改"></a>
				</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="10">
				<a href="?pageNum=1">首页</a>
				<a href="?pageNum=${page.pageNum-1<1?page.pageNum:page.pageNum-1 }">上一页</a>
				<a href="?pageNum=${page.pageNum+1>page.pages?page.pageNum:page.pageNum+1 }">下一页</a>
				<a href="?pageNum=${page.pages }">尾页</a>
			</td>
		</tr>
	</table>
</body>
<script type="text/javascript">
	function quan(){
		var a = $("[name='ck']");
		var b = $(":input[name='ck']:checked");
		if(a.length!=b.length){
			a.each(function(){
				$(this).prop("checked",true);
			})
		}else{
			a.each(function(){
				$(this).prop("checked",false);
			})
		}
	}
	
	function fan(){
		var a = $("[name='ck']");
		a.each(function(){
			if($(this).prop("checked")==true){
				$(this).prop("checked",false);
			}else{
				$(this).prop("checked",true);
			}
		})
	}
	
	function pl(){
		var b = $(":input[name='ck']:checked");
		var a = new Array();
		b.each(function(){
			a.push($(this).val());
		})
		if(b.length==0){
			alert("请选择要删除的数据");
		}else{
			var d = confirm("确定删除id为"+a+"的数据吗?");
			if(d){
				$.post("deleteduo.do",{a:a.toString()},function(date){
					if(date){
						alert("删除成功");
						location.reload();
					}
				})
			}
		}
	}
</script>
</html>