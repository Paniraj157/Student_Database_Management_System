package com.jspiders;

import java.util.Scanner;

import customexception.InvalidChoiceException;

public class Solution {
	
	public static void main(String[] args) {
		//Menu Driven program
		//Upcasting
		//switch case
		//System.exit(0);
		//Infinite loop ->while(true) { } 
		
		// To Accept Input from the user
		Scanner scan = new Scanner (System.in);
		
		//Upcasting for achieving abstraction
		StudentManagementSystem sms = new StudentManagementImpl();
		
		System.out.println("Welcome to Student database management system");
		System.out.println(".................................................");
		while(true) {
		System.out.println("1:Add Student\n2:Display Student");
		System.out.println("3:Display all students\n4:Remove Students");
		System.out.println("5:Remove all student\n6:Update student");
		System.out.println("7:Count Student\n8:Sort Student");
		System.out.println("9:Exit\nEnter choice");
		int choice = scan.nextInt();
		
		switch(choice) {
		case 1:
			sms.addStudent();
			break;
		case 2:
			sms.displayStudent();
			break;
		case 3:
			sms.displayAllStudent();
			break;
		case 4:
			sms.removeStudent();
			break;
		case 5:	
			sms.removeAllStudent();
			break;
		case 6:
			sms.updateStudent();
			break;
		case 7:
			sms.countStudent();
			break;
		case 8:
			sms.sortStudent();
			break;
		case 9:
			System.out.println("Thank you!!!");
			System.exit(0);
			
		default:	
			try {
				throw new invalidChoiceException("Invalid choice, kindly Enter valid choice");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
					
		}
		System.out.println("....................");//After switch statement
	}
	}

}
