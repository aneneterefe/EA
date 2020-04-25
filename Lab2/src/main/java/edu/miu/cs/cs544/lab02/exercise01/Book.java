package edu.miu.cs.cs544.lab02.exercise01;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="BOOK")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="TITLE",nullable = false)
	private String title;
	@Column(nullable = false, unique = true)
	private String ISBN;
	
	@Column(name="AUTHOR",nullable = false)
	private String author;
	
	@Column(name="PRICE")
	private Double price;
	
	@Column(name="PUBLISH_DATE")
	@Temporal(TemporalType.DATE)
	private Date publish_date;

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String iSBN, String author, Double price, Date publish_date) {
		super();
		this.title = title;
		ISBN = iSBN;
		this.author = author;
		this.price = price;
		this.publish_date = publish_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getPublish_date() {
		return publish_date;
	}

	public void setPublish_date(Date publish_date) {
		this.publish_date = publish_date;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", ISBN=" + ISBN + ", author=" + author + ", price=" + price
				+ ", publish_date=" + publish_date + "]";
	}
	
}
