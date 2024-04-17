package product.entites;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OrderDetail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderDetailId")
    private Integer orderDetailId;

    @ManyToOne
    @JoinColumn(name = "UserId")
    private User user;

    @ManyToOne
    @JoinColumn(name = "TourId")
    private Tour tour;

    @Column(name = "OrderDate")
    private Date orderDate  = new Date();;

    @Column(name = "Status")
    private Boolean status =false;
    public OrderDetail() {
		// TODO Auto-generated constructor stub
	}
	public OrderDetail(Integer orderDetailId, User user, Tour tour, Date orderDate, Boolean status) {
		super();
		this.orderDetailId = orderDetailId;
		this.user = user;
		this.tour = tour;
		this.orderDate = orderDate;
		this.status = status;
	}
	public Integer getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Tour getTour() {
		return tour;
	}
	public void setTour(Tour tour) {
		this.tour = tour;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
    
    // Constructors, getters, and setters
}
