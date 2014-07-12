<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>管理员登陆</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<center>
		<%
			String err = request.getParameter("err");
			if (err != null) {
				if (err.equals("1")) {
					out.println("<h2>请重新登陆</h2><br/>");
				}
			}
		%>
		<h1>管理登陆</h1>
		<form action="LoginClServlet" method="post">
			用户名&nbsp;<input type="text" name="user"><br />
			<br /> 密&nbsp;&nbsp;码&nbsp;<input type="password" name="password"><br />
			<br />
			<br /> <input type="submit" value="登陆">
		</form>
		<br/><a href=index.html>返回主界面</a>
		<hr>
	</center>
</body>
</html>
