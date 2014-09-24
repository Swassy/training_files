package com.school.record.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.school.record.database.StudentDatabaseInterface;
import com.school.record.model.*;
 
public class StudentDatabase implements StudentDatabaseInterface
{
	private DataSource dataSource;
 
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
 
	public void insert(StudentBean sb){
 
		String sql = "INSERT INTO student " +
				"(roll,name, std, gender,school, percentage) VALUES (?, ?, ?, ?, ?, ?)";
		Connection conn = null;
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sb.getRoll());
			ps.setString(2, sb.getName());
			ps.setInt(3, sb.getStd());
			ps.setString(4, sb.getGender());
			ps.setString(5, sb.getSchool());
			ps.setInt(6, sb.getPercentage());
			ps.executeUpdate();
			ps.close();
 
		} catch (SQLException e) {
			throw new RuntimeException(e);
 
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {}
			}
		}
	}
 
	public ArrayList<StudentBean> search(String category, String value){
		
		//System.out.println("Category:"+category+"\nValue:"+value);
		String sql = "SELECT * FROM student where "+category+" = "+value;
 
		Connection conn = null;
		//String a="";
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ArrayList<StudentBean> student= new ArrayList<StudentBean>();
			 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StudentBean sb = new StudentBean(
						rs.getInt("roll"),
					rs.getString("name"),
					rs.getInt("std"),
					rs.getString("gender"),
					rs.getString("school"),
					rs.getInt("percentage")

				);
				student.add(sb);
				
			}
			rs.close();
			ps.close();
			//System.out.println(student);
			return student;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				
				} catch (SQLException e) {}
			}
		}
	}
	public void delete(int roll){
		String sql = "DELETE FROM student where roll = "+roll;
		 
		Connection conn = null;
		//String a="";
 
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			
			 
			ResultSet rs = ps.executeQuery();
			
			rs.close();
			ps.close();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				
				} catch (SQLException e) {}
			}
		}
	
		
	}
	public ArrayList<StudentBean> displayAll(int page_no, int contents_per_page){
		 
		String sql = "SELECT * FROM student limit "+(((page_no-1)*contents_per_page)+1)+" , "+contents_per_page;
		System.out.println("page no : "+page_no+" \ncpp : "+contents_per_page);
		Connection conn = null;
		Connection conn1=null;
		//String a="";
 
		try {
			ArrayList<StudentBean> student= new ArrayList<StudentBean>();
			conn = dataSource.getConnection();
			conn1 = dataSource.getConnection();
			PreparedStatement ps2=conn1.prepareStatement("SELECT COUNT(*) as 'student_count' FROM student");
			ResultSet rs2=ps2.executeQuery();
			student.add(new StudentBean(rs2));
			PreparedStatement ps = conn.prepareStatement(sql);
			
			 
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				StudentBean sb = new StudentBean(
						rs.getInt("roll"),
					rs.getString("name"),
					rs.getInt("std"),
					rs.getString("gender"),
					rs.getString("school"),
					rs.getInt("percentage")

				);
				student.add(sb);
				
			}
			rs.close();
			ps.close();
			rs2.close();
			ps2.close();
			
			return student;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				
				} catch (SQLException e) {}
			}
		}
	}
	

}
