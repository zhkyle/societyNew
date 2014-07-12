package com.tianle.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Manager {
	
	private ResultSet rs = null;
	private Connection conn = null;
	private PreparedStatement ps = null;

	public int getPageCount(int pageSize) {

		int pageCount = 0;
		int rowCount = 0;

		try {
			conn = new ConnDB().getConn();
			ps = conn.prepareStatement(
					"SELECT count(*) FROM users");
			rs = ps.executeQuery();

			if (rs.next()) {
				rowCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		if (rowCount % pageSize == 0) {
			pageCount = rowCount / pageSize;
		} else {
			pageCount = rowCount / pageSize + 1;
		}

		return pageCount;
	}
	
	public ArrayList<UserBean> getUsersByPage(int pageNow) {

		ArrayList<UserBean> al = new ArrayList<UserBean>();

		try {
			String sql = "SELECT * FROM users LIMIT " + ((pageNow - 1) * 10) + "," + 10;
//			System.out.println(sql);
			conn = new ConnDB().getConn();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				UserBean ub = new UserBean();
				
				ub.setId(rs.getInt(1));
				ub.setName(rs.getString(2));
				ub.setNum(rs.getInt(3));
				ub.setMyclass(rs.getString(4));
				ub.setPhone(rs.getString(5));
				ub.setDeclaration(rs.getString(6));
				
				al.add(ub);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}

		return al;
	}
	
	//É¾³ýÓÃ»§
	public boolean delUser(String id) {
		boolean b = false;
		
		try {
			conn = new ConnDB().getConn();
			String sql = "DELETE from users where id=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			int r = ps.executeUpdate();
			if(r==1) {
				b = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return b;
	}
	
	
	private void close() {

		try {
			if (rs!=null) {
				rs.close();
				rs = null;
			}
			if (!ps.isClosed()) {
				ps.close();
				ps = null;
			}
			if (conn!=null) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
