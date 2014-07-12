package com.tianle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 
 * 加入报名信息
 * @author tianle
 * @version 1.0
 *
 */
public class Enroll {

	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement ps = null;

	//向数据库添加信息
	public boolean enrollDatebase(String name, int num, String myclass,
			String phone, String declaration) {

		boolean b = false;

		try {
			System.out.println(name);
			conn = new ConnDB().getConn();
			
			String sql = "insert into users values(null,?,?,?,?,?)";
//			String sql = "insert into users(name) values(?)";
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, num);
			ps.setString(3, myclass);
			ps.setString(4, phone);
			ps.setString(5, declaration);
			
			int r = ps.executeUpdate();
			
			//Statement stmt = conn.createStatement();
			
			if (r == 1) {
				b = true;
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		} finally {
			close();
		}

		return b;
	}

	//关闭连接
	private void close() {

		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (ps != null) {
				ps.close();
				ps = null;
			}
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
