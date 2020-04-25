package exercise_a_and_f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private int roomNumber;
	@Column(nullable = false)
	private String building;
	
	@OneToMany (mappedBy = "office")
	private List<Employee> employees= new ArrayList<Employee>();
	
	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Office(int roomNumber, String building) {
		super();
		this.roomNumber = roomNumber;
		this.building = building;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public int getId() {
		return id;
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	public boolean addEmployee(Employee employee) {
		return employees.add(employee);
	}
	public boolean removeEmployee(Employee employee) {
		return employees.remove(employee);
	}
	
	@Override
	public String toString() {
		return "Office [id=" + id + ", roomNumber=" + roomNumber + ", building=" + building + "]";
	}
	
	
}
