package com.sortingLogic;

import java.util.Comparator;

import com.jspiders.Student;

public class StudentSortById implements Comparator<Student> {
	
	
	@Override
	public int compare(Student x,Student y) {
		
		return x.getId().compareTo(y.getId());
	}
}