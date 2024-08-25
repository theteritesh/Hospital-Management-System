package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Specalist;;


public class SpecialistDao {
	private Connection con;

	public SpecialistDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean addSpecialist(String name) {
		boolean f=false;
		try {
			String sql="INSERT INTO specialist(spec_name)VALUES(?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1, name);
			int i=pst.executeUpdate();
			
			if(i==1) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return f;
	}
	
	public List<Specalist> getAllSpecialist(){
		List<Specalist> list=new ArrayList<>();
		Specalist s=null;
		try {
			String sql="SELECT * FROM specialist";
			PreparedStatement pst=con.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				s=new Specalist();
				s.setId(rs.getInt(1));
				s.setSpecialistName(rs.getString(2));
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
