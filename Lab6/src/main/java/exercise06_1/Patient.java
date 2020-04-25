package exercise06_1;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.SecondaryTables;

@Entity
@SecondaryTables(
		@SecondaryTable(name="Address", pkJoinColumns = {
				@PrimaryKeyJoinColumn(name="Patient_Id", referencedColumnName = "id")
		} )
)
//or @SecondaryTable(name="Address")
public class Patient {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
	
	@Column(table = "Address")
	private String street;
	@Column(table = "Address")
	private String zip;
	@Column(table = "Address")
	private String city;
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Patient(String name, String street, String zip, String city) {
		super();
		this.name = name;
		this.street = street;
		this.zip = zip;
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getId() {
		return id;
	}
	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", street=" + street + ", zip=" + zip + ", city=" + city + "]";
	}
	
	
}
