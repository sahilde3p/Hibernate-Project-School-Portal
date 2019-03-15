package com.sahil.hibernate;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.hibernate.entity.Course;
import com.sahil.hibernate.entity.Instructor;
import com.sahil.hibernate.entity.InstructorDetail;
import com.sahil.hibernate.entity.Review;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args)
	{
		//create session factory
		SessionFactory factory = new Configuration().configure()
									.addAnnotatedClass(Instructor.class)
									.addAnnotatedClass(InstructorDetail.class)
									.addAnnotatedClass(Course.class)
									.addAnnotatedClass(Review.class)
									.buildSessionFactory();
		//create session
		Session session = factory.getCurrentSession();
		
		
		try
		{
			
		Course theCourse = new Course("Physics");
		
		
		session.beginTransaction();
			
session.createQuery("from Course where title='Physics'",Course.class).stream().forEach(o->session.delete(o));
		
		session.getTransaction().commit();
		}
		finally
		{
			factory.close();
		}
	}

}
