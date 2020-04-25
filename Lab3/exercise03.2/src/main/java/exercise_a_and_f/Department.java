package exercise_a_and_f;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	@OneToMany(mappedBy = "department")
	@OrderBy("name ASC")
	private List<Employee> employee=new ArrayList<Employee>();
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(String name) {
		super();
		this.name = name;
	}

	public Department(String name, List<Employee> employee) {
		super();
		this.name = name;
		this.employee = employee;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	public int getId() {
		return id;
	}
	
	public boolean addEmployee(Employee emp) {
		return employee.add(emp);
	}
	public boolean removeEmployee(Employee emp) {
		return employee.remove(emp);
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name+"]";
	}
	
	
		
}
