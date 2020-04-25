package exercise05_a;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Order_tbl")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@OneToMany
	@JoinColumn(name="order_id")
	List<OrderLine> orderLines=new ArrayList<OrderLine>();

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(Date date) {
		super();
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}
	
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
	public boolean addOrderLine(OrderLine orderLine) {
		return orderLines.add(orderLine);
	}
	public boolean removeOrderLine(OrderLine orderLine) {
		return orderLines.remove(orderLine);
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + "]";
	}
}
