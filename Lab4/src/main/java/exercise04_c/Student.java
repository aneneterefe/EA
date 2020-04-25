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
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentid;
	
	@Column(nullable = false)
	private String firstName;
	private String LastName;
	
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		LastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public int getStudentid() {
		return studentid;
	}
	
	@Override
	public String toString() {
		return "Student [studentid=" + studentid + ", firstName=" + firstName + ", LastName=" + LastName + "]";
	}
	
}
