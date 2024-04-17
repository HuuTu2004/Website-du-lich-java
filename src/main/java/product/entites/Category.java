package product.entites;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;
    @NotEmpty(message = "Tên không được để trống")
    @Column(name = "Name", unique = true)
    private String name;
    @NotNull(message = "Trạng thái không được để trống")
    @Column(name = "Status")
    private boolean status;
    @NotEmpty(message = "Mô tả không được để trống")
    @Column(name = "Description")
    private String description;
    
    @OneToMany(mappedBy = "category")
    private Set<Tour> listTour;
    public Category() {
		// TODO Auto-generated constructor stub
	}
	public Category(int id, @NotEmpty(message = "Tên không được để trống") String name,
			@NotNull(message = "Trạng thái không được để trống") boolean status,
			@NotEmpty(message = "Mô tả không được để trống") String description) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

    
}
