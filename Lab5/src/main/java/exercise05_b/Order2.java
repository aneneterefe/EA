package exercise05_b;

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
@Table(name="Order_tbl2")
public class Order2 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int orderId;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer2 customer;
	
	@OneToMany
	@JoinColumn(name="order_id")
	List<OrderLine2> orderLines=new ArrayList<OrderLine2>();

	public Order2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order2(Date date) {
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
	
	
	public Customer2 getCustomer() {
		return customer;
	}

	public void setCustomer(Customer2 customer) {
		this.customer = customer;
	}

	public List<OrderLine2> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(List<OrderLine2> orderLines) {
		this.orderLines = orderLines;
	}
	
	public boolean addOrderLine(OrderLine2 orderLine) {
		return orderLines.add(orderLine);
	}
	public boolean removeOrderLine(OrderLine2 orderLine) {
		return orderLines.remove(orderLine);
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", date=" + date + "]";
	}
}
