package exercise06_1;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String doctorType;
	private String firstName;
	private String lastName;
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Doctor(String doctorType, String firstName, String lastName) {
		super();
		this.doctorType = doctorType;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getDoctorType() {
		return doctorType;
	}
	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
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
	@Override
	public String toString() {
		return "Doctor [id=" + id + ", doctorType=" + doctorType + ", firstName=" + firstName + ", lastName=" + lastName
				+ "]";
	}
	
}
