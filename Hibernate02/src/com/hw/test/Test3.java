package com.hw.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.hw.entity.Account;
import com.hw.entity.Dept;
import com.hw.entity.Employee;
import com.hw.util.HBUtils;

public class Test3 {

	@Test
	public void addEmployee(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp = new Employee("寒冰射手",4000,"female");
		
		Set<String> hobbies = new HashSet<String>();
		hobbies.add("躲在队友身后");
		
		emp.setHobbies(hobbies);
		
		List<String> addresses = new ArrayList<String>();
		
		addresses.add("召唤师峡谷");
		addresses.add("月亮街250号");
		
		emp.setAddresses(addresses);
		
		session.save(emp);
		
		tx.commit();
		
		session.close();
	}
	
	@Test
	public void testAddDept(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Employee emp1 = new Employee("寒冰射手",4000,"female");
		Employee emp2 = new Employee("Timo",4000,"male");
		session.save(emp1);
		session.save(emp2);
		Dept dept = new Dept("财务部","打钱");
		
		Set<Employee> empSet = new HashSet<Employee>();
		empSet.add(emp1);
		empSet.add(emp2);
		dept.setEmpSet(empSet);
		
		session.save(dept);
		tx.commit();
		session.close();
		
	}
	
	@Test
	public void addEmployee1(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Dept dept = new Dept("技术部","技术研发");
		session.save(dept);
		
		Employee emp1 = new Employee("马云",48,"male");
		emp1.setDept(dept);
		Employee emp2 = new Employee("马化腾",48,"male");
		emp2.setDept(dept);
		Employee emp3 = new Employee("李彦宏",48,"male");
		emp3.setDept(dept);
		
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void addEmployee2(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Dept dept = new Dept();
		dept.setId(1);
		
		Employee emp1 = new Employee("刘强东",41,"male");
		emp1.setDept(dept);
		session.save(emp1);
		
		tx.commit();
		session.close();
	}
	
	@Test
	public void testAddDept1(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Dept parent = new Dept("技术部","技术研发");
		session.save(parent);
		
		Dept child1 = new Dept("运维部","产品运维");
		child1.setParent(parent);
		Dept child2 = new Dept("测试部","产品测试");
		child2.setParent(parent);
		
		session.save(child1);
		session.save(child2);
		tx.commit();
		session.close();
	}
	
	@Test
	public void testAccount(){
		Session session = HBUtils.getSession();
		Transaction tx = session.beginTransaction();
		
		Account account = new Account("zhangsan","1234",1000.0);
		session.save(account);
		
		Employee emp = new Employee("张三",19,"male");
		emp.setAccount(account);
		session.save(emp);
		
		tx.commit();
		session.close();
	}
	
	
}
