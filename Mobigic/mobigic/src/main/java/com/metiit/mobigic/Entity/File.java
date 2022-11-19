package com.metiit.mobigic.Entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "file")
public class File {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int F_Id;
	@NotBlank
	@Column(length = 30)
	private String fileName;

	@Column(length = 1000, name = "f_name")
	private String nameOfFile;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "Id")
	private Users user;

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	

	public int getF_Id() {
		return F_Id;
	}

	public void setF_Id(int f_Id) {
		F_Id = f_Id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getNameOfFile() {
		return nameOfFile;
	}

	public void setNameOfFile(String nameOfFile) {
		this.nameOfFile = nameOfFile;
	}

	@Override
	public String toString() {
		return "File [F_Id=" + F_Id + ", fileName=" + fileName + ", nameOfFile=" + nameOfFile + ", user=" + user + "]";
	}

	
	

	
}
