package com.hw.entity;

import java.util.Set;

public class Dept {
	
	private int id;				//����ID
	private String deptName;	//��������
	private String description;	//��������
	
	private Dept parent;		//�ϼ�����
	
	private Set<Dept> children;	//�Ӳ���
	
	private Set<Employee> empSet;	//�����е�����Ա��

	public Dept() {
	}

	public Dept(String deptName, String description) {
		this.deptName = deptName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Employee> getEmpSet() {
		return empSet;
	}

	public void setEmpSet(Set<Employee> empSet) {
		this.empSet = empSet;
	}

	public Dept getParent() {
		return parent;
	}

	public void setParent(Dept parent) {
		this.parent = parent;
	}

	public Set<Dept> getChildren() {
		return children;
	}

	public void setChildren(Set<Dept> children) {
		this.children = children;
	}
}
