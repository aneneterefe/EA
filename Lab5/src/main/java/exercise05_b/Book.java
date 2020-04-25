package exercise05_b;

import javax.persistence.Entity;

@Entity
public class Book extends Product2 {

	private String title;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public Book(String name, String description,String title) {
		super(name, description);
		this.title = title;
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + "]";
	}
	
}
