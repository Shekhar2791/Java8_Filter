package com.java8features;

import java.util.Date;
import java.util.List;

public class Employee {
	
	private int id;
	private String name;
	private int age;
	private Double salary;
	private Date doj;
	private char sex;
	private long mobile;
	List<String> email;
	
	
	public Employee() {
		super();
	}

	public Employee(int id, String name, int age, Double salary, Date doj, char sex, long mobile, List<String> email) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.doj = doj;
		this.sex = sex;
		this.mobile = mobile;
		this.email = email;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getDoj() {
		return doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}	
	
	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public List<String> getEmail() {
		return email;
	}

	public void setEmail(List<String> email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", salary=" + salary + ", doj=" + doj
				+ ", sex=" + sex + ", mobile=" + mobile + ", email=" + email + "]";
	}

}
