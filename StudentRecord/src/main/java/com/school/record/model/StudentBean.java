package com.school.record.model;

import java.sql.ResultSet;
import java.sql.SQLException;


//@Entity
public class StudentBean implements StudentBeanInterface {
	
	private String name,gender,school;
	private int roll,std,percentage;
	private int total_content;
	
	public StudentBean(){
		
	}
	public StudentBean(ResultSet rs){
		try {
			rs.next();
			total_content=(int)rs.getInt("student_count");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getTotalContent();
	}
	
	public int getTotalContent(){
		return total_content;
	}
	
	public StudentBean(int roll ,String name ,int std ,String gender , String school, int percentage){
		this.roll=roll;
		setName(name);
		setStd(std);
		setGender(gender);
		setSchool(school);
		setPercentage(percentage);
	//	System.out.println("Inside the bean :"+roll+"\t"+name+"\t"+gender+"\t"+school+"\t"+percentage);
		
	}
	
	
	public void setName(String name){
		this.name=name;
	}
	public void setStd(int std){
		this.std=std;
	}
	public void setGender(String gender){
		this.gender=gender;
	}
	public void setSchool(String school){
		this.school=school;
	}
	public void setPercentage(int percentage){
		this.percentage=percentage;
	}
	public int getRoll(){
		return roll;
	}
	public String getName(){
		return name;
	}
	public int getStd(){
		return std;
	}
	public String getGender(){
		return gender;
	}
	public String getSchool(){
		return school;
	}
	public int getPercentage(){
		return percentage;
	}

}
