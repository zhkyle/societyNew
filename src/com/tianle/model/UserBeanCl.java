package com.tianle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBeanCl {

	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement ps = null;

	public boolean checkUser(String user, String password) {

		boolean b = false;

		conn = new ConnDB().getConn();
		String sql = "SELECT password FROM admin WHERE name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);

			rs = ps.executeQuery();

			if (rs.next()) {
				if (rs.getString(1).equals(password)) {
					b = true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			this.close();
		}

		return b;
	}

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
