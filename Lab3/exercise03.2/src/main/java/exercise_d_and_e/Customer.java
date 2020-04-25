package exercise_d_and_e;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private int id;
	@Column(nullable = false)
	private String name;
	
	@OneToMany
	@JoinColumn(name="customer_id")
	private List<Reservation> reservations=new ArrayList<Reservation>();
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(String name) {
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
	public boolean addReservation(Reservation r) {
		return reservations.add(r);
	}
	public boolean removeReservation(Reservation r) {
		return reservations.remove(r);
	}
	
	public List<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}
	
	
}
