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
	 /*//��1��ָ�������ַ������dbname��Ҫ�Լ��޸�
    //String dbUrl = "jdbc:mysql://sqld.duapp.com:4050/dbname";
    //��2��ֱ�Ӵ�����header�л�ȡip���˿ڡ��û�����������Ϣ
//String host = request.getHeader("BAE_ENV_ADDR_SQL_IP");
//String port = request.getHeader("BAE_ENV_ADDR_SQL_PORT");
//String username = request.getHeader("BAE_ENV_AK");
//String password = request.getHeader("BAE_ENV_SK");
   //��3�����̱߳���BaeEnv�ӿڻ�ȡip���˿ڡ��û�����������Ϣ
String host = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_IP);
String port = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_ADDR_SQL_PORT);
String username = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_AK);
String password = BaeEnv.getBaeHeader(BaeEnv.BAE_ENV_SK);
String driverName = "com.mysql.jdbc.Driver";
String dbUrl = "jdbc:mysql://";
String serverName = host + ":" + port + "/";

    //��ƽ̨��ѯӦ��Ҫʹ�õ����ݿ���
String databaseName = "yourDataBaseName";
String connName = dbUrl + serverName + databaseName;
String sql = "select * from test";

Connection connection = null;
Statement stmt = null;
ResultSet rs = null;
try {
	Class.forName(driverName);
            //��������ݿ�����߼�
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
	// �쳣�����߼�
  throw ex;
} catch (SQLException e) {
	// �쳣�����߼�
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
