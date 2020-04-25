package exercise04_b;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String flightNumber;
	@Column(name="from_location")
	private String from;
	@Column(name="to_location")
	private String to;
	@Temporal(TemporalType.DATE)
	private Date date;

	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Flight(String flightNumber, String from, String to, Date date) {
		super();
		this.flightNumber = flightNumber;
		this.from = from;
		this.to = to;
		this.date = date;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightNumber=" + flightNumber + ", from=" + from + ", to=" + to + ", date="
				+ date + "]";
	}
}
