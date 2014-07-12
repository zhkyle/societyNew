<%@ page language="java" import="java.util.*,com.tianle.model.*,java.sql.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

	ResultSet rs = null;
	Connection conn = null;
	PreparedStatement ps = null;
	boolean bGrade = false;

	String u = (String) session.getAttribute("username");
	if (u == null) {
		response.sendRedirect("login.jsp?err=1");
		return;
	}

	Manager manager = new Manager();

	int pageNow = 1;
	int pageCount = 1;
	
	String s_pageNow = (String)request.getAttribute("pageNow");
	if(s_pageNow!=null) {
		pageNow = Integer.parseInt(s_pageNow);
	}

	ArrayList<UserBean> al = manager.getUsersByPage(pageNow);
	
	pageCount = manager.getPageCount(10);
	
	conn = new ConnDB().getConn();
	String sql = "SELECT grade FROM admin WHERE name=?";
	ps = conn.prepareStatement(sql);
	ps.setString(1, u);
	rs = ps.executeQuery();
	if(rs.next()) {
		int i = rs.getInt(1);
		if(i == 1) {
			bGrade = true;
		}
	}

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理界面</title>
    
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
    <h2>登陆成功：<%=u %></h2>
    	<table border="1">
    		<tr>
    			<td width="50">用户id</td>
    			<td width="80">姓名</td>
    			<td width="100">学号</td>
    			<td width="80">班级</td>
    			<td width="150">手机</td>
    			<td>宣言</td>
    			
    			<%
    				if(bGrade) {
    					out.println("<td width='50'>删除</td>");
    				}
    			 %>
    			
    		</tr>
    <%
    if(bGrade) {
    	for(int i=0; i<al.size(); i++) {
    		UserBean ub = al.get(i);
    		out.println("<tr>");
    		out.println("<td>"+ub.getId()+"</td>");
    		out.println("<td>"+ub.getName()+"</td>");
    		out.println("<td>"+ub.getNum()+"</td>");
    		out.println("<td>"+ub.getMyclass()+"</td>");
    		out.println("<td>"+ub.getPhone()+"</td>");
    		out.println("<td>"+ub.getDeclaration()+"</td>");
    		out.println("<td width='50'><a href='UserClServlet?del="+ub.getId()+"'>删除</a></td>");
    		out.println("</tr>");
    	}
    } else {
    	for(int i=0; i<al.size(); i++) {
    		UserBean ub = al.get(i);
    		out.println("<tr>");
    		out.println("<td>"+ub.getId()+"</td>");
    		out.println("<td>"+ub.getName()+"</td>");
    		out.println("<td>"+ub.getNum()+"</td>");
    		out.println("<td>"+ub.getMyclass()+"</td>");
    		out.println("<td>"+ub.getPhone()+"</td>");
    		out.println("<td>"+ub.getDeclaration()+"</td>");
    		out.println("</tr>");
    	}
    }
    
     %>
    
    </table>
    
    	<%
			for(int i=1; i<=pageCount; i++) {
				out.println("<a href=UserClServlet?pageNow=" + i +">" + " [" + i + "] </a>");
			
			}
		
		 %>
		 <hr/>
		 <br/>
    
     <p><a href=login.jsp>返回登陆界面</a></p>
     <p><a href=index.html>返回主界面</a></p>
    
    </center>
  </body>
</html>
