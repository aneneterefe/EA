package exercise05_b;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;

@Entity
public class OrderLine2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private int quantity;
	
	@ManyToOne
	@JoinTable(name="product_orderline2")//avoids null FK 
	private Product2 product;
	
	public OrderLine2() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderLine2(int quantity) {
		super();
		this.quantity = quantity;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	
	public Product2 getProduct() {
		return product;
	}
	public void setProduct(Product2 product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "OrderLine [id=" + id + ", quantity=" + quantity + "]";
	}
}
