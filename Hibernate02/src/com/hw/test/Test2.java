package com.hw.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;

import com.hw.entity.Employee;
import com.hw.util.HBUtils;

public class Test2 {

	@Test
	public void testHql(){
		
		String hql = "from Employee order by age desc";
		
		List<Employee> list = 
				HBUtils.getSession().createQuery(hql).list();
		
		for(Employee emp : list){
			System.out.println(emp);
		}
	}
	
	@Test
	public void testHql1(){
		
		String sql = "select * from employee";
		
		List<Object[]> list = 
				HBUtils.getSession().createSQLQuery(sql).list();
		
		for(Object[] obj: list){
			System.out.println(obj[1]);
		}
	}
	
	@Test
	public void testHql2(){
		
		String sql = "select * from employee";
		
		List<Employee> list = 
				HBUtils.getSession().createSQLQuery(sql).addEntity(Employee.class).list();
		
		for(Employee emp: list){
			System.out.println(emp);
		}
	}
	
	@Test
	public void testCriteria(){
		Criteria cri = HBUtils.getSession().createCriteria(Employee.class);
		
		List<Employee> list = cri.list();
		
		for(Employee emp: list){
			System.out.println(emp);
		}
	}
	
	@Test
	public void testCriteria1(){
		Criteria cri = 
				HBUtils.getSession()
				.createCriteria(Employee.class)
				.add(Restrictions.like("name", "李%"))
				.add(Restrictions.eq("age", 28));
		
		List<Employee> list = cri.list();
		
		for(Employee emp: list){
			System.out.println(emp);
		}
	}
	
	/**
	 * 命名查询
	 */
	@Test
	public void test2(){
		Session session = HBUtils.getSession();
		
		Query query = 
				session.getNamedQuery("queryAllEmployee")
				.setParameter("age", 28);
		
		List<Employee> list = query.list();
		
		for(Employee emp: list){
			System.out.println(emp);
		}
	}
	
	@Test
	public void test3(){
		Session session = HBUtils.getSession();
		
		Query query = 
				session.getNamedQuery("com.hw.entity.Employee.queryAllByName")
				.setParameter("name", "张三");
		
		List<Employee> list = query.list();
		
		for(Employee emp: list){
			System.out.println(emp);
		}
	}
	
}
