package product.entites;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "Tour")
public class Tour {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TourId")
	private int tourId;

	@NotEmpty(message = "Tên tour không được để trống")
	@Column(name = "Tourname")
	private String tourName;

	@NotEmpty(message = "Mô tả không được để trống")
	@Column(name = "description")
	private String description;
	
	@NotNull(message = "Giá không được để trống")
	@Column(name = "Price")
	private float price;
	
	@NotNull(message = "Sức chứa không được để trống")
	@Column(name = "Capacity")
	private int capacity;

	@NotNull(message = "Trạng thái không được để trống")
	@Column(name = "Status")
	private boolean status;
	
	@Column(name = "Image")
	private String image;

	@ManyToOne
	@JoinColumn(name = "Category_id",referencedColumnName = "id")
	private Category category;

	public Tour() {
		// TODO Auto-generated constructor stub
	}

	public Tour(int tourId, @NotEmpty(message = "Tên tour không được để trống") String tourName,
			@NotEmpty(message = "Mô tả không được để trống") String description,
			@NotNull(message = "Giá không được để trống") float price,
			@NotNull(message = "Sức chứa không được để trống") int capacity,
			@NotNull(message = "Trạng thái không được để trống") boolean status,
			@NotEmpty(message = "Ảnh không được để trống") String image, Category category) {
		super();
		this.tourId = tourId;
		this.tourName = tourName;
		this.description = description;
		this.price = price;
		this.capacity = capacity;
		this.status = status;
		this.image = image;
		this.category = category;
	}

	public int getTourId() {
		return tourId;
	}

	public void setTourId(int tourId) {
		this.tourId = tourId;
	}

	public String getTourName() {
		return tourName;
	}

	public void setTourName(String tourName) {
		this.tourName = tourName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	

}
