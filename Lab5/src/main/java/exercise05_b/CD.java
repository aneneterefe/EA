package exercise05_b;

import javax.persistence.Entity;

@Entity
public class CD extends Product2 {

	private String artist;

	public CD() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CD(String name, String description, String artist) {
		super(name, description);
		this.artist=artist;
	}

	public CD(String name, String description) {
		super(name, description);
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	@Override
	public String toString() {
		return "CD [artist=" + artist + "]";
	}
	
}
