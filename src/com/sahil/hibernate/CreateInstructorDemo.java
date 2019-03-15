package com.sahil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.hibernate.entity.Course;
import com.sahil.hibernate.entity.Instructor;
import com.sahil.hibernate.entity.InstructorDetail;
import com.sahil.hibernate.entity.Student;

public class CreateInstructorDemo {

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
			Instructor instructor = new Instructor("Sahil","Chad","SahilDeep@gmail.com");
			InstructorDetail instructorDetail = new InstructorDetail("youtube.com/Sahil", "Programming");
			
			instructor.setInstructorDetail(instructorDetail);
					
			
			session.beginTransaction();
			
			session.save(instructor);
			
			session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
