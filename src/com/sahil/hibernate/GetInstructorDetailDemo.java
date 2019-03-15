package com.sahil.hibernate;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.hibernate.entity.Instructor;
import com.sahil.hibernate.entity.InstructorDetail;

public class GetInstructorDetailDemo {

	public static void main(String[] args)
	{
		//create session factory
		SessionFactory factory = new Configuration().configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		try
		{
			session.beginTransaction();
			
			
	Instructor i = (Instructor)	session.createQuery("from Instructor where id=37").getResultList().get(0);
	
	session.delete(i);
			
			
			session.getTransaction().commit();
			
			
			
		/*	Session session2 = factory.getCurrentSession();
			
			session2.beginTransaction();

			session2.persist(instructor);
			
			session2.getTransaction().commit();
			*/
		}
		finally
		{
			factory.close();
		}
	}

}
