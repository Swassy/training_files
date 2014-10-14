package com.school.record.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.school.record.database.*;
import com.school.record.model.*;

import com.school.record.database.StudentDatabase;
 
@Service
public class StudentService {
 
    @Autowired
    private StudentDatabase stud;
    
    @Transactional
    public void insert(StudentBean sb) {
        stud.insert(sb);
    }
 
    @Transactional
    public void removeBook(int roll) {
        stud.delete(roll);
    }
 
    
    public List<StudentBean> displayAll() {
        return stud.displayAll(1, 10);
    }
 
    /*@Transactional
    public void updateBook(StudentBean sb) {
        stud.updateBook(sb);
    }*/
 
    
    public List<StudentBean> search(int bookId) {
        return stud.search(bookId);
    }
 
}