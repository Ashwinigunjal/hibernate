package com.hibernet.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.demo.jdbc.Student;

public class saveData {

	
	public static void setUp() throws Exception {
		// A SessionFactory is set up once for an application!
		SessionFactory sessionFactory=null;
		Session session=null;
		sessionFactory= new Configuration().configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class).buildSessionFactory();
		try {
			 session = sessionFactory.openSession();
			Student st = new Student("yuvi","gunjal","yuvraj");
			session.beginTransaction();
			session.save(st);
			session.getTransaction().commit();
		
			
			System.out.println("upload data successfully");
			System.out.println("student id:" + st.getId());
	        session = sessionFactory.openSession();
	        session.beginTransaction();
	        st = session.get(Student.class, st.getId());
			System.out.println("data: " + st);
			session.getTransaction().commit();
			System.out.println("done");
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			System.out.println("exception");
			e.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	
}
