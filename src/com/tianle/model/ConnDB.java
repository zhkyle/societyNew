package com.tianle.model;

import java.sql.*;

public class ConnDB {

	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

	public Connection getConn() {

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(
					"jdbc:mysql://sqld.duapp.com:4050/gBTTaQRwADZCrEyJLQIW", "6sOh6Ow5ou0sIQh1LfCDtANT", "YOLjSBkLLSdWHd9MXV9DVrook7o0iFH8");
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	 /*//（1）指定服务地址，其中dbname需要自己修改
    //String dbUrl = "jdbc:mysql://sqld.duapp.com:4050/dbname";
    //（2）直接从请求header中获取ip、端口、用户名和密码信息
//String host = request.getHeader("BAE_ENV_ADDR_SQL_IP");
//String port = request.getHeader("BAE_ENV_ADDR_SQL_PORT");
//String username = request.getHeader("BAE_ENV_AK");
//String password = request.getHeader("BAE_ENV_SK");
   //（3）从线程变量BaeEnv接口获取ip、端口、用户名和密码信息
String host = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_IP);
String port = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_PORT);
String username = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_AK);
String password = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_SK);
String driverName = "com.mysql.jdbc.Driver";
String dbUrl = "jdbc:mysql://";
String serverName = host + ":" + port + "/";

    //从平台查询应用要使用的数据库名
String databaseName = "yourDataBaseName";
String connName = dbUrl + serverName + databaseName;
String sql = "select * from test";

Connection connection = null;
Statement stmt = null;
ResultSet rs = null;
try {
	Class.forName(driverName);
            //具体的数据库操作逻辑
	connection = DriverManager.getConnection(connName, username,
			password);
	stmt = connection.createStatement();
	rs = stmt.executeQuery(sql);
	String id = "", name = "";
  out.println("id&nbsp;&nbsp;&nbsp;&nbsp;name<br/>");
	while (rs.next()) {
		id = rs.getString("id");
		name = rs.getString("name");
      out.println(id + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + name + "<br/>");
	}
} catch (ClassNotFoundException ex) {
	// 异常处理逻辑
  throw ex;
} catch (SQLException e) {
	// 异常处理逻辑
		throw e;
} finally {
	try {
		if (connection != null) {
			connection.close();
		}
		} catch (SQLException e) {
				throw e;
	}
}
*/
}
