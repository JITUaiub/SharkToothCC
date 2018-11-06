package main.java.org.sharktooth.gms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Size(min = 1)
	@Column(name = "username")
	private String username;

	@Size(min = 7, max = 11)
	@Column(name = "igg_id")
	private String iggId;

	@Size(min = 1)
	@Column(name = "name")
	private String name;

	@Size(min = 1)
	@Column(name = "email")
	private String email;

	@Size(min = 1)
	@Column(name = "password")
	private String password;
	
	@Column(name = "gender")
	private String gender = "";
	
	@Column(name = "country")
	private String country = "";
	
	@Column(name = "accountType")
	private String accountType = "member";
	
	@Column(name = "status")
	private String status = "pending";
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getIggId() {
		return iggId;
	}

	public void setIggId(String iggId) {
		this.iggId = iggId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
