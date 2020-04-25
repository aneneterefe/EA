package exercise_d_and_e;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import exercise_b.Book;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	@JoinTable(name="reservation_book")
	private Book book;
	
	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Date date) {
		super();
		this.date = date;
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
    
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + "]";
	}
	
	
}
