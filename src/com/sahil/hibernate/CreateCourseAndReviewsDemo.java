package com.sahil.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.hibernate.entity.Course;
import com.sahil.hibernate.entity.Instructor;
import com.sahil.hibernate.entity.InstructorDetail;
import com.sahil.hibernate.entity.Review;
import com.sahil.hibernate.entity.Student;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args)
	{
		//create session factory
		SessionFactory factory = new Configuration().configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		
		try
		{
			
		Course theCourse = new Course("Physics");
		
		theCourse.addReview(new Review("Great Course"));
		theCourse.addReview(new Review("Dumb Course"));
		theCourse.addReview(new Review("Cool Course"));
		session.beginTransaction();
			
			
			
			session.persist(theCourse);
			
			
				
		session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
