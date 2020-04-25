package exercise05_b;

import javax.persistence.Entity;

@Entity
public class DVD extends Product2 {

	private String genre;

	public DVD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DVD(String name, String description) {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public DVD(String name, String description,String genre) {
		super(name, description);
		this.genre = genre;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "DVD [genre=" + genre + "]";
	}
	
	
	
}
