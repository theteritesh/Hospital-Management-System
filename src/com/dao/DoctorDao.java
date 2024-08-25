package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {
	private Connection con;

	public DoctorDao(Connection con) {
		super();
		this.con=con;
	}
	public boolean registerDoctor(Doctor d) {
		boolean f=false;
		
		try {
			String sql="INSERT INTO doctor(d_name,dob,qualification,specialist,email,mobNo,password) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, d.getFullname());
			pst.setString(2, d.getDob());
			pst.setString(3, d.getQualification());
			pst.setString(4, d.getSpecialist());
			pst.setString(5, d.getEmail());
			pst.setString(6, d.getMobNo());
			pst.setString(7, d.getPassword());
			int i =pst.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Doctor> getAllDoctor(){
		List<Doctor> list=new ArrayList<>();
		Doctor d=null;
		try {
			String sql="SELECT * FROM doctor ORDER BY d_id DESC";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				list.add(d);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Doctor getDoctorById(int id){
		Doctor d=null;
		try {
			String sql="SELECT * FROM doctor WHERE d_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	
	public boolean updateDoctor(Doctor d) {
		boolean f=false;
		
		try {
			String sql="UPDATE doctor SET d_name=?,dob=?,qualification=?,specialist=?,email=?,mobNo=?,password=? WHERE d_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, d.getFullname());
			pst.setString(2, d.getDob());
			pst.setString(3, d.getQualification());
			pst.setString(4, d.getSpecialist());
			pst.setString(5, d.getEmail());
			pst.setString(6, d.getMobNo());
			pst.setString(7, d.getPassword());
			pst.setInt(8, d.getId());
			int i =pst.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public boolean deleteDoctor(int id) {
		boolean f=false;
		try {
			String sql="DELETE FROM doctor WHERE d_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public Doctor login(String email,String password) {
		Doctor d=null;
		try {
			String sql="SELECT * FROM doctor WHERE email=? AND password=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				d=new Doctor();
				d.setId(rs.getInt(1));
				d.setFullname(rs.getString(2));
				d.setDob(rs.getString(3));
				d.setQualification(rs.getString(4));
				d.setSpecialist(rs.getString(5));
				d.setEmail(rs.getString(6));
				d.setMobNo(rs.getString(7));
				d.setPassword(rs.getString(8));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public int countDoctor() {
		int i=0;
		
		try {
			String sql="SELECT * FROM doctor";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				i++;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int countAppointment() {
		int i=0;
		
		try {
			String sql="SELECT * FROM appointment";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				i++;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int countAppointmentByDocId(int did) {
		int i=0;
		
		try {
			String sql="SELECT * FROM appointment WHERE doctor_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, did);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				i++;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int countUser() {
		int i=0;
		
		try {
			String sql="SELECT * FROM user_login";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				i++;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public int countSpecialist() {
		int i=0;
		
		try {
			String sql="SELECT * FROM specialist";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				i++;
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return i;
	}
	
	public boolean checkOldPassword(int usrId,String oldPassword) {
		boolean f=false;
		try {
			String sql="SELECT * FROM doctor WHERE d_id=? and password=?";
			PreparedStatement pst=con.prepareStatement(sql);
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
			String sql="UPDATE doctor SET password=? WHERE d_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
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
	
	public boolean editDoctorProfile(Doctor d) {
		boolean f=false;
		
		try {
			String sql="UPDATE doctor SET d_name=?,dob=?,qualification=?,specialist=?,email=?,mobNo=? WHERE d_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, d.getFullname());
			pst.setString(2, d.getDob());
			pst.setString(3, d.getQualification());
			pst.setString(4, d.getSpecialist());
			pst.setString(5, d.getEmail());
			pst.setString(6, d.getMobNo());
			pst.setInt(7, d.getId());
			int i =pst.executeUpdate();
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
}
