package kz.azh.dao;

import java.util.ArrayList;

import kz.azh.model.Student;

public class StudentDAO {

	
	public static ArrayList<Student> init(){			
			
			ArrayList<Student> list = new ArrayList<Student>();
			for(int i = 0; i < 6; i++) {
				list.add(new Student("Name " + i,"Group " + i));
			}	
			return list;
		}
	
	public static ArrayList<Student> getByName(String name){
		
		ArrayList<Student> list = init();
		ArrayList<Student> students = new ArrayList<Student>();
		for (Student student : list) {
			if(student.getName().equals(name))
				students.add(student);
		}
		return students;		
	}
}
