package com.school.record.database;

import java.util.ArrayList;
import java.util.List;

/*import javax.annotation.Resource;*/
import javax.persistence.EntityManager;
/*import javax.persistence.EntityManagerFactory;*/
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/*import org.hibernate.Session;*/
/*import org.hibernate.SessionFactory;*/
/*import org.hibernate.cfg.Configuration;*/
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
/*import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.stereotype.Repository;

import com.school.record.model.StudentBean;
 
@Repository
public class StudentDatabase 
{
	
	
	@PersistenceContext
	EntityManager em;
	 
 
	/*@Autowired//@Resource(name = "sessionFactory")
	SessionFactory sessionFactory ;*/
	
 
	public void insert(StudentBean sb){
		
 
		
		/*EntityManager em= emf.createEntityManager();*/
		
		this.em.persist(sb);
		this.em.flush();
		/*session.save(sb);*/
		 
       
	}
 
	
	public List<StudentBean> search(int value){
		 
		 String sql="FROM StudentBean  WHERE roll= :roll";
		 TypedQuery<StudentBean> query = em.createQuery(sql, StudentBean.class);
		 query.setParameter("roll", value);
		 List<StudentBean> list = new ArrayList<StudentBean>();
		 list.add(query.getSingleResult());
		 return list;	
		
		
	}
	
	
	public void delete(int roll){
		
		this.em.remove(search(roll));
	
		
	}
	
	
	public List<StudentBean> displayAll(){
		
		String qlString = "SELECT p FROM Podcast p";
	    TypedQuery<StudentBean> query = em.createQuery(qlString, StudentBean.class);        
	 
	    return query.getResultList();
		 
		
		
	}
	

}
