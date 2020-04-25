package exercise05_b;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customer2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstName;
	private String lastName;
	
	@OneToMany(mappedBy = "customer",orphanRemoval = true,cascade = CascadeType.ALL)
	List<Order2> orders=new ArrayList<Order2>();
	
	public Customer2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer2(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
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
	
	public List<Order2> getOrders() {
		return orders;
	}
	public void setOrders(List<Order2> orders) {
		this.orders = orders;
	}
	
	public boolean addOrder(Order2 order ) {
		return orders.add(order);
	}
	public boolean removeOrder(Order2 order ) {
		return orders.remove(order);
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
}
