package com.sahil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.hibernate.entity.Instructor;
import com.sahil.hibernate.entity.InstructorDetail;
import com.sahil.hibernate.entity.Student;

public class CreateDemo {

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
			Instructor instructor = new Instructor("Sahil","Kaura","sahilkaura@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/sahil", "programming");
			
			instructor.setInstructorDetail(instructorDetail);
			
			
			
			session.beginTransaction();
			
			int id = 1;
			InstructorDetail tempInstructor = session.get(InstructorDetail.class, 2);
			System.out.println(tempInstructor);
			session.delete(tempInstructor);
			
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
