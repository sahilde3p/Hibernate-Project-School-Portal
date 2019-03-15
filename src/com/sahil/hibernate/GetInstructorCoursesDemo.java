package com.sahil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.hibernate.entity.Course;
import com.sahil.hibernate.entity.Instructor;
import com.sahil.hibernate.entity.InstructorDetail;

public class GetInstructorCoursesDemo {

	public static void main(String[] args)
	{
		//create session factory
		SessionFactory factory = new Configuration().configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		
		try
		{
			
		session.beginTransaction();
			Instructor instructor = session.get(Instructor.class, 2);
			System.out.println(instructor.getCourses());
		session.getTransaction().commit();
		
		}
		finally
		{
			factory.close();
		}
	}

}
