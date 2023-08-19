package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.sortingLogic.StudentSortByAge;
import com.sortingLogic.StudentSortById;
import com.sortingLogic.StudentSortByMarks;
import com.sortingLogic.StudentSortByName;

import customexception.StudentNotFoundException;

/**
 * 
 * @author paniraj
 * @since 2022
 */

public class StudentManagementImpl implements  StudentManagementSystem {
	
	//Collection -> Database -> Map & LinkedHashMap -> key(String) -> value(Student)
	//Scanner Object
	
	Map<String, Student> db = new LinkedHashMap<String, Student>();
	Scanner scan = new Scanner(System.in);

	@Override
	public void addStudent() {
		//Accept name, age & marks
		//Student object
		
		System.out.println("Enter name");
		String name= scan.next();
		System.out.println("Enter age");
		int age = scan.nextInt();
		System.out.println("Enter Marks");
		int marks = scan.nextInt();
		
		Student s = new Student ( name, age, name, marks);
		db.put(s.getId(), s);
		System.out.println("Student Record Inserted Successfully");
		System.out.println("Your Student Id is "+s.getId());
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student Id:");
		String id = scan.next();
		if(db.containsKey(id)) {
			Student obj = db.get(id);
			System.out.println("Id:"+obj.getId());
			System.out.println("Name:"+obj.getName());
			System.out.println("Age:"+obj.getAge());
			System.out.println("Marks:"+obj.getMarks());
			//System.out.println(obj); // tostring() is overridden ->optional
		}
		else {
			try {
				throw new StudentNotFoundException("Student Record not found");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void displayAllStudent() {
		Set<String> keys = db.keySet();  //"JSP101" "JSP102"
		System.out.println("Student records are as Follows:");
		System.out.println("....................................");
		if(db.size()!=0) {
			for(String key : keys) {
				System.out.println(db.get(key));  //printing references variable
			}
		}
		else {
			try {
				throw new StudentNotFoundException("Student records not available to Display");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
			
		
		
		
	}

	@Override
	public void removeStudent() {
		//Accept the id -> String
		//uppercase
		//containskey()
		//remove()
		//else - > SNFE -> handle
		
		System.out.println("Enter the student id: ");
		String id = scan.next().toUpperCase();
		//String id = scan.next();
		//id = id.toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student record deleted successfully");
		}
		else {
			//Exception and handle
			try {
			    throw new StudentNotFoundException("Student record not found!");
			}
			catch(Exception e) {
				String message =e.getMessage();
				System.out.println(message);//System.out.println(e.getMessage());
			}
		}
		
		
	}

	@Override
	public void removeAllStudent() {
		System.out.println("Total students record available: "+db.size());
		db.clear();
		System.out.println("All student records deleted successfully");
	}

	@Override
	public void updateStudent() {
		//Accept Id & uppercase, containsKey, get the student object
		//switch case 1:update name,age, marks
		//invoke exception
		
		System.out.println("Enter student id:");
		String id= scan.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std =db.get(id);
			System.out.println("1:Update name\n2:Update age\n3:Update marks");
			System.out.println("Enter choice:");
			int choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter name:");
				String name = scan.next();
				std.setName(name); //std.setName(scan.next());
				System.out.println("Name updated successfully");
				break;
			case 2:
				System.out.println("Enter Age:");
				int age = scan.nextInt();
				std.setAge(age);; //std.setAge(scan.next());
				System.out.println("Age updated successfully");
				break;
			case 3:
				System.out.println("Enter marks:");
				int marks = scan.nextInt();
				std.setMarks(marks);; //std.setName(scan.next());
				System.out.println("Marks updated successfully");
				break;
			default:
				try {
					throw new invalidChoiceException("Invalid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}			
			}
		}
		else {
			try {
				throw new StudentNotFoundException("Student record not found!");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
	}

	@Override
	public void countStudent() {
		System.out.println("Total no. of records:"+db.size());
		
	}

	@Override
	public void sortStudent() {
		//Convert Map into Set -> keySet()
		//List & ArrayList ->Student
		//for-each, getbthe values(Student objects) and store into AL
		
		/**
		 * Converting Map into Set
		 * Keys are student Id and datatype is String
		 */
		
		Set<String> keys =db.keySet(); //"JSP101" "JSP102"
		
		/**
		 * Achieving upcasting between list & ArrayList
		 * list can store student objects
		 */
		
		List<Student> list = new ArrayList<Student>();
		
		for(String key : keys) {
			list.add(db.get(key)); //Adding Student objects from Map to List
		}
		
		System.out.println("1:Sort By Id\n2:Sort By Name\n3:Sort By Age");
		System.out.println("4:Sort By Marks\n Enter Choice:");
		
		int choice=scan.nextInt();
		
		switch(choice)
		{
		case 1:
			Collections.sort(list, new StudentSortById());
			//for(Student s : list) {
				//System.out.println(s);
			display(list);
			break;
		case 2:
			Collections.sort(list, new StudentSortByName());
			display(list);
			break;
		case 3:
			Collections.sort(list, new StudentSortByAge());
			display(list);
			break;
		case 4:
			Collections.sort(list, new StudentSortByMarks());
			display(list);
			break;
		default:
			try {
				throw new invalidChoiceException("Invalid choice");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
						
		}
						
	}
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}	

}
