package com.hw.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hw.entity.Course;
import com.hw.entity.Student;
import com.hw.util.HBUtils;

public class Test4 {

	@Test
	public void selectCourse(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Course c1 = new Course("java");
		Course c2 = new Course("C#");
		session.save(c1);
		session.save(c2);
		
		Student stu1 = new Student("ÍõÌúÖù","male");
		Student stu2 = new Student("Ìï¶şæ¤","female");
		Set<Course> courses = new HashSet<Course>();
				courses.add(c1);
				courses.add(c2);
		stu1.setCourses(courses);
		stu2.setCourses(courses);
		
		session.save(stu1);
		session.save(stu2);
		tx.commit();
		session.close();
		
	}
}
