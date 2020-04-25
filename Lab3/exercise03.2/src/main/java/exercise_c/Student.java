package exercise_c;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(unique = true, nullable = false)
	private String studentId;
	
	@Column(nullable = false)
	private String firstName;
	
	private String lastName;
	
	@ManyToMany
	@JoinTable(name="student_course", joinColumns = {@JoinColumn(name="student_id")}, inverseJoinColumns = {@JoinColumn(name="course_id")})
	private List<Course> courses=new ArrayList<Course>();
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String firstName, String lastName) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}
    
	public List<Course> getCourses() {
		return courses;
	}

	public boolean addCourse(Course course) {
		return courses.add(course);
	}
	public boolean removeCourse(Course course) {
		return courses.remove(course);
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
}
