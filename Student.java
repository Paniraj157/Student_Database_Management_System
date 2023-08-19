package com.jspiders;

public class Student {
	private String Id;
	private int age;
	private String name;
	private int marks;
	private static int count = 101;
	public Student(String id, int age, String name, int marks) {
		super();
		this.Id = "JSP"+count;
		this.age = age;
		this.name = name;
		this.marks = marks;
		count++;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public String getId() {
		return Id;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public int getMarks() {
		return marks;
	}
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", age=" + age + ", name=" + name + ", marks=" + marks + "]";
	}
	

}
