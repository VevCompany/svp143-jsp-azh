package kz.azh.model;

public class Student {
	
	private Long id;
	private String name;
	
	public Student() {}
	public Student(Long id, String name) {
		this.name = name;
		this.id = id;
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
}
