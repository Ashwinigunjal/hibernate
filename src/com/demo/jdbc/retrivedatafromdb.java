package com.demo.jdbc;



import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class retrivedatafromdb {

	
public static void main(String[] args) {
		
		SessionFactory sessionFactory=null;
		
		sessionFactory= new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();

		
		try {
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			//select * from db
//			List<Student> theStudent = session.createQuery("From com.demo.jdbc.Student").list(); 
			//select record according condition
			String query="from com.demo.jdbc.Student s  where s.name ='ashu'";
			List<Student> theStudent = session.createQuery(query).list(); 
			
			System.out.println(theStudent);
			System.out.println("Data from database: ");
			for(Student tempStudent: theStudent ){
				System.out.println(tempStudent);
			
			
			session.close();
			sessionFactory.close();
	
		}
			}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			System.out.println("exception");
			e.printStackTrace();
		}

}
}
