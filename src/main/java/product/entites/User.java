package product.entites;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty(message = "Tên tài khoản không được trống")
    @Size(min = 5, max = 50, message = "Tên tài khoản phải từ 5 đến 50 ký tự")
	@Column(name = "username")
	private String userName;
	@NotEmpty(message = "Mật khẩu không được trống")
    @Size(min = 8, max = 100, message = "Mật khẩu phải từ 8 đến 100 ký tự")
	@Column(name = "password")
	private String passWord;
	@Column(name = "enabled")
	private Boolean enabled = true;
	
	@NotEmpty(message = "Họ và tên không được trống")
    @Size(max = 100, message = "Họ và tên không được quá 100 ký tự")
	@Column(name = "fullname")
	private String fullName;
	@Column(name = "gender")
	private Boolean gender;
	@Column(name = "birthday")
	private Date birthday;
	
	@NotEmpty(message = "Địa chỉ không được trống")
	@Size(max = 200, message = "Địa chỉ không được quá 200 ký tự")
	@Column(name = "address")
	private String address;
	@Column(name = "email")
	private String email;
	@Column(name = "telephone")
	private String telephone;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private Set<User_Role> userRoles;

	public User() {
		super();
// TODO Auto-generated constructor stub
	}

	public User(Long id, String userName, String passWord, Boolean enabled, String fullName, Boolean gender,
			Date birthday, String address, String email, String telephone, Set<User_Role> userRoles) {
		super();
		this.id = id;
		this.userName = userName;
		this.passWord = passWord;
		this.enabled = enabled;
		this.fullName = fullName;
		this.gender = gender;
		this.birthday = birthday;
		this.address = address;
		this.email = email;
		this.telephone = telephone;
		this.userRoles = userRoles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Boolean getGender() {
		return gender;
	}

	public void setGender(Boolean gender) {
		this.gender = gender;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Set<User_Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<User_Role> userRoles) {
		this.userRoles = userRoles;
	}
}