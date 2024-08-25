package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {
	
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean userRegistration(User u) {
		boolean f=false;
		String sql="INSERT INTO user_login(fullname,email,password) VALUES(?,?,?)";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, u.getFullname());
			pst.setString(2, u.getEmail());
			pst.setString(3, u.getPassword());
			
			int i=pst.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public User login(String em,String pass) {
		User u=null;
		try {
			String sql="SELECT * FROM user_login WHERE email=? AND password=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, em);
			pst.setString(2, pass);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setId(rs.getInt(1));
				u.setFullname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
		
	}
	public boolean checkOldPassword(int usrId,String oldPassword) {
		boolean f=false;
		try {
			String sql="SELECT * FROM user_login WHERE id=? and password=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, usrId);
			pst.setString(2, oldPassword);
			
			ResultSet rs=pst.executeQuery();
			
			while(rs.next()) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean changePassword(int usrId,String newPassword) {
		boolean f=false;
		try {
			String sql="UPDATE user_login SET password=? WHERE id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, newPassword);
			pst.setInt(2, usrId);
			
			int i=pst.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
}
 