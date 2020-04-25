package exercise04_a;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Laptop {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String brand;
	private String type;

	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false)//a laptop has atleast one owner
	private Employee employee;

	public Laptop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Laptop(String brand, String type) {
		super();
		this.brand = brand;
		this.type = type;
	}
    
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}
    
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Laptop laptop = (Laptop) obj;
		if (id == laptop.id && (brand == laptop.brand || (brand != null && brand.equals(laptop.getBrand())))
				&& (type == laptop.type && (type != null && type.equals(laptop.getType())))) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((brand == null) ? 0 : brand.hashCode());
		result = prime * result + id;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "Laptop [id=" + id + ", brand=" + brand + ", type=" + type + "]";
	}

}
