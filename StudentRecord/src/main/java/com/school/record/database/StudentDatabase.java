package com.school.record.database;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.school.record.model.StudentBean;
 
@Repository
public class StudentDatabase 
{
	
	
	/*@Resource(name="dataSource")
	private DataSource dataSource;*/
 
	@Autowired//@Resource(name = "sessionFactory")
	SessionFactory sessionFactory ;
	
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}*/
 
	public void insert(StudentBean sb){
		
 
		/*String sql = "INSERT INTO student " +
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
		}*/
		
		/*Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory factory = configuration.buildSessionFactory(builder.build());*/
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		
		session.save(sb);
		 
        //Commit the transaction
        //session.getTransaction().commit();
        //session.close();
	}
 
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<StudentBean> search(/*String category, */int value){
		
		//Configuration configuration = new Configuration().configure();
		//StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		//= configuration.buildSessionFactory(builder.build());
		Session session = sessionFactory.openSession();
		//session.beginTransaction();
        List<StudentBean> list = session.createQuery("from com.school.record.model.StudentBean stud where stud.roll = :roll")
            .setParameter("roll", value)
            .list();
        return list.size() > 0 ? list: null;
		
		
		/*String sql = "SELECT * FROM student where "+category+" = "+value;
 
		Connection conn = null;
		
 
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
		
			return student;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				
				} catch (SQLException e) {}
			}
		}*/
	}
	public void delete(int roll){
		/*String sql = "DELETE FROM student where roll = "+roll;
		 
		Connection conn = null;
		
 
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
		}*/
	
		
	}
	@SuppressWarnings("unchecked")
	public List<StudentBean> displayAll(int page_no, int contents_per_page){
		//Configuration configuration = new Configuration().configure();
				//StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
				//= configuration.buildSessionFactory(builder.build());
				Session factory = sessionFactory.openSession();
		return factory
	            .createQuery("from com.school.record.model.StudentBean").list();
		 
		/*String sql = "SELECT * FROM student limit "+(((page_no-1)*contents_per_page)+1)+" , "+contents_per_page;
		
		Connection conn = null;
		Connection conn1=null;
		
 
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
		}*/
		
	}
	

}
