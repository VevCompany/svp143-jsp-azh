package kz.azh.model;

import java.util.ArrayList;

public class StudentList {
	
	public static ArrayList<Student> getStudents(){
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		for(int i = 0; i < 6; i++) {
			list.add(new Student("Name " + i,"Group " + i));
		}
		
		return list;
	}

}
