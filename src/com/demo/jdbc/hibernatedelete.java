package com.demo.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernatedelete {

public static void main(String[] args) {
		
		SessionFactory sessionFactory=null;
		
		sessionFactory= new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();

		
		try {
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			//delete according to id
//			Student theStudent =session.get(Student.class,24);
//			session.delete(theStudent);
			
			//delete according other parameter
			session.createQuery("delete from com.demo.jdbc.Student where id =1")
			.executeUpdate();

			session.getTransaction().commit();
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