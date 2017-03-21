package com.hw.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hw.entity.Employee;
import com.hw.util.HBUtils;

public class EmployeeDao {

	public int testDelete(String gender){
		
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "delete from Employee where gender =?";
		
		Query query = session.createQuery(hql);
		query.setString(0, gender);
		
		int count = query.executeUpdate();
		
		tx.commit();
		session.close();
		
		return count;
	}
	
	public int testUpdate(int age, String gender){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "update Employee set age=:age where gender=:gender";
		
		Query query = session.createQuery(hql);
		query.setParameter("age", age);
		query.setParameter("gender", gender);
		
		int count = query.executeUpdate();
		
		tx.commit();
		session.close();
		
		return count;
	}
	
	public List<Employee> queryNameAndAge(){
		Session session = HBUtils.getSession();
		
		String hql = "select new Employee(name,age) from Employee";
		Query query = session.createQuery(hql);
		
		List<Employee> list = query.list();
		session.close();
		return list;
	}
	
	public List<Object[]> queryNameAndGender(){
		Session session = HBUtils.getSession();
		
		String hql = "select name,gender from Employee";
		Query query = session.createQuery(hql);
		
		List<Object[]> list = query.list();
		
		return list;
	}
	
}
