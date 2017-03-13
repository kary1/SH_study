package com.hw.entity;

import java.util.Set;

public class Dept {
	
	private int id;				//部门ID
	private String deptName;	//部门名称
	private String description;	//部门描述
	
	private Dept parent;		//上级部门
	
	private Set<Dept> children;	//子部门
	
	private Set<Employee> empSet;	//部门中的所有员工

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
