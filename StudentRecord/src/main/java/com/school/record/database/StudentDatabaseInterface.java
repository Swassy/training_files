package com.school.record.database;

import java.util.ArrayList;
import com.school.record.model.StudentBean;

public interface StudentDatabaseInterface {
	public void insert(StudentBean sb);
	public ArrayList<StudentBean> displayAll(int a, int b);
	public ArrayList<StudentBean> search(String category,String value);
	public void delete(int roll);

}
