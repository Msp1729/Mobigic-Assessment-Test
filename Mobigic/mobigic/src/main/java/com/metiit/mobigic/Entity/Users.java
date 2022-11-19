package com.metiit.mobigic.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;

import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity // table creation
@Table(name = "users")
public class Users extends BaseEntity {

	@NotBlank(message = "password not be blank")
	@Column(length = 100, nullable = false)
	private String password;
	@NotBlank
	@Column(name = "first_name", length = 30, nullable = false)
	private String firstName;
	@NotBlank
	@Column(name = "last_name", length = 30)
	private String lastName;
	@NotBlank
	@Column(length = 30, unique = true, nullable = false)
	private String email;

	private String status = "Active";

	private String role;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.MERGE)
	@JsonIgnore
	private List<File> filelist;

	public List<File> getFilelist() {
		return filelist;
	}

	public void setFilelist(List<File> filelist) {
		this.filelist = filelist;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Users [password=" + password + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", status=" + status + ", role=" + role + ", filelist=" + filelist + "]";
	}

	

}
