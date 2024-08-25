package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;

public class AppointmentDao {
	private Connection con;

	public AppointmentDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean addAppointment(Appointment ap) {
		boolean f=false;
		
		try {
			
			String sql="INSERT INTO appointment (user_id,full_name,gender,age,appoint_date,email,mob_no,diseases,doctor_id,address,status) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, ap.getUserid());
			pst.setString(2, ap.getFullName());
			pst.setString(3, ap.getGender());
			pst.setString(4, ap.getAge());
			pst.setString(5, ap.getAppoinDate());
			pst.setString(6, ap.getEmail());
			pst.setString(7, ap.getMobNo());
			pst.setString(8, ap.getDiseases());
			pst.setInt(9, ap.getDoctorId());
			pst.setString(10, ap.getAddress());
			pst.setString(11, ap.getStatus());
			
			int i=pst.executeUpdate();
			if(i==1) {
				f=true;
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
		
	}
	
	
	public List<Appointment> getAllAppoinmentByLoginUser(int UserId){
		List<Appointment> list=new ArrayList<>();
		Appointment ap=null;
		
		try {
			String sql="SELECT * FROM appointment WHERE user_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, UserId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				ap=new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setMobNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				
				list.add(ap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public List<Appointment> getAllAppoinmentByLoginDoctor(int docId){
		List<Appointment> list=new ArrayList<>();
		Appointment ap=null;
		
		try {
			String sql="SELECT * FROM appointment WHERE doctor_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, docId);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				ap=new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setMobNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				
				list.add(ap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Appointment getAppoinmentById(int id){
		Appointment ap=null;
		
		try {
			String sql="SELECT * FROM appointment WHERE id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				ap=new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setMobNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ap;
	}
	
	public boolean updateComment(int id, int did,String comm) {
		boolean f=false;
		
		try {
			String sql="UPDATE appointment SET status=? WHERE id=? and doctor_id=?";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, comm);
			pst.setInt(2, id);
			pst.setInt(3, did);
			int i=pst.executeUpdate();
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return f;
	}
	
	public List<Appointment> getAllAppoinment(){
		List<Appointment> list=new ArrayList<>();
		Appointment ap=null;
		
		try {
			String sql="SELECT * FROM appointment ORDER BY id desc";
			PreparedStatement pst=con.prepareStatement(sql);
			
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				ap=new Appointment();
				ap.setId(rs.getInt(1));
				ap.setUserid(rs.getInt(2));
				ap.setFullName(rs.getString(3));
				ap.setGender(rs.getString(4));
				ap.setAge(rs.getString(5));
				ap.setAppoinDate(rs.getString(6));
				ap.setEmail(rs.getString(7));
				ap.setMobNo(rs.getString(8));
				ap.setDiseases(rs.getString(9));
				ap.setDoctorId(rs.getInt(10));
				ap.setAddress(rs.getString(11));
				ap.setStatus(rs.getString(12));
				
				list.add(ap);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
