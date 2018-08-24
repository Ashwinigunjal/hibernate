package com.demo.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hobernateprimarykey {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory=null;
		
		sessionFactory= new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();
		try {
			Session session = sessionFactory.openSession();
			
			session.beginTransaction();
			session.save( new Student("Ashu","gunjal","ahsindncx"));
			session.save( new Student("ishu","gunjal","ahsindncx"));
			session.save( new Student("piyu","gunjal","ahsindncx"));
			session.getTransaction().commit();
		
			session.close();
			sessionFactory.close();
			System.out.println("upload data successfully");
		
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			System.out.println("exception");
			e.printStackTrace();
		}

	}
}
