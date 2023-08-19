package com.sortingLogic;

import java.util.Comparator;

import com.jspiders.Student;

public class StudentSortByMarks implements Comparator<Student> {

	@Override
	public int compare(Student x, Student y) {
		
		return x.getMarks() - y.getMarks();
	}
	

}
