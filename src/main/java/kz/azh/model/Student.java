package kz.azh.model;

public class Student {
	
	private Long id;
	private String name;
	private Long age;
	
	public Student() {}
	public Student(Long id, String name) {
		this.name = name;
		this.id = id;
	}
	public Student(Long id, String name, Long age) {
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name; 
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}	
}
