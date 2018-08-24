package com.demo.jdbc;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibenateupdatedata {

public static void main(String[] args) {
		
		SessionFactory sessionFactory=null;
		
		sessionFactory= new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();

		
		try {
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			//update according to id
//			Student theStudent = session.get(Student.class,1);
//			theStudent.setName("vishal");
			
			//update more than one record
			session.createQuery("update com.demo.jdbc.Student set email='ashwinigunjal1994@gmail.com'")
			.executeUpdate();
			session.getTransaction().commit();
			
//			System.out.println(theStudent);
			System.out.println("Done");
			
			session.close();
			sessionFactory.close();
	
		
			}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			System.out.println("exception");
			e.printStackTrace();
		}

}

	
	
}
