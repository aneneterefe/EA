package exercise_c;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Course {

	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false, unique = true)
	private String courseNumber;
	
	private String courseName;

	@ManyToMany(mappedBy = "courses")
	private List<Student> students=new ArrayList<Student>();
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String courseNumber, String courseName) {
		super();
		this.courseNumber = courseNumber;
		this.courseName = courseName;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getId() {
		return id;
	}
  
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	public boolean addStudent(Student student) {
		return students.add(student);
	}
	public boolean removeStudent(Student student) {
		return students.remove(student);
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", courseNumber=" + courseNumber + ", courseName=" + courseName + "]";
	}
	
	
}
