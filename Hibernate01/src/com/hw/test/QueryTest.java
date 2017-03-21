package com.hw.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hw.dao.EmployeeDao;
import com.hw.entity.Employee;
import com.hw.util.HBUtils;

public class QueryTest {
	
	private EmployeeDao empDao = new EmployeeDao();
	
	@Test
	public void testQ1(){
		
		Session session = HBUtils.getSession();
		
		String hql = "from Employee where id = ?";
		Query query = session.createQuery(hql).setMaxResults(3).setFirstResult(0).setInteger(0, 3);
		
		List<Employee> list = query.list();
		
		System.out.println(list);
		
	}
	
	@Test
	public void testDeleteByHql(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		String hql = "delete from Employee where gender ='男'";
		
		Query query = session.createQuery(hql);
		
		System.out.println(query.executeUpdate());
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void testDelete(){
		empDao.testDelete("女");
	}
	
	@Test
	public void testUpdate(){
		empDao.testUpdate(20, "男");
	}
	
	@Test
	public void queryNameAndAge(){
		
		for(Employee emp : empDao.queryNameAndAge()){
			System.out.println(emp.getName()+"---"+emp.getAge());
		}
	}
	
	@Test
	public void queryNameAndGender(){
		for(Object[] objArr : empDao.queryNameAndGender()){
			System.out.println("姓名："+objArr[0]+"\t"+"性别："+objArr[1]);
		}
	}
}
