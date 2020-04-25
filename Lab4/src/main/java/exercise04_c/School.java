package exercise04_c;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

@Entity
public class School {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String name;
	
	@OneToMany
	@JoinColumn(name="school_id")
	@MapKey(name="firstName")
	private Map<String, Student> students=new HashMap<String, Student>();
	
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}

	public School(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}
	public Map<String, Student> getStudents() {
		return students;
	}
	public void setStudents(Map<String, Student> students) {
		this.students = students;
	}
	
	public Student addStudent(Student stu) {
		return students.put(stu.getFirstName(), stu);
	}
	public Student removeStudent(String key) {
		return students.remove(key);
	}
	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + "]";
	}
	
}
