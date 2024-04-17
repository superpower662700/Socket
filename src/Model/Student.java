package Model;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 1L; // Đảm bảo tính nhất quán của serialization
	private int id;
	private String name;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name) {
		this.id = id;
		this.name = name;
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

}
