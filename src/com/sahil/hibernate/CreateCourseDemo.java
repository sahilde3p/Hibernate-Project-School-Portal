package com.sahil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.hibernate.entity.Course;
import com.sahil.hibernate.entity.Instructor;
import com.sahil.hibernate.entity.InstructorDetail;

public class CreateCourseDemo {

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
			
		Course theCourse = new Course("Physics");
		Course theCourse1 = new Course("Chemistry");
		Course theCourse2 = new Course("English");
		session.beginTransaction();
			
			Instructor i =	(Instructor)session.get(Instructor.class, 2);
			
			i.add(theCourse);
			i.add(theCourse1);
			i.add(theCourse2);
			
			session.persist(i);
			
			
				
		session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
