package exercise04_b;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	private String name;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="passenger_id", nullable = false)// flight has atleast one passenger 
	private List<Flight> flights=new ArrayList<Flight>();
	
	public Passenger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Passenger(String name) {
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

	public List<Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	
	public boolean addFlight(Flight flight) {
		return flights.add(flight);
	}
	public boolean removeFlight(Flight flight) {
		return flights.remove(flight);
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + "]";
	}
	
}
