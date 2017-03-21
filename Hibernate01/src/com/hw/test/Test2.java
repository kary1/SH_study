package com.hw.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import com.hw.entity.Employee;
import com.hw.util.HBUtils;

public class Test2 {

	@Test
	public void add(){
		
		Session session = HBUtils.getSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee emp = new Employee("ÀîÁù",26,"ÄÐ");
		
		session.save(emp);
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void delete(){
		
		Session session = HBUtils.getSession();
		
		Transaction tx = session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setId(4);
		
		session.delete(emp);
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void modify(){
		
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp = new Employee();
		emp.setId(1);
		emp.setAge(99);
		session.update(emp);
		tx.commit();
		session.close();
	}
	
	@Test
	public void modify2(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp = (Employee) session.load(Employee.class, 2);
		emp.setAge(88);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void query1(){
		Session session = HBUtils.getSession();
		
		Employee emp = (Employee) session.get(Employee.class, 2);
		
		System.out.println(emp);
		
		session.close();
	}
	
}
