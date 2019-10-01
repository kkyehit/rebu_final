package com.rebu.memberServer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "members")
public class MembersModel {
	@Id
	@Column(name = "id", nullable = false)
	private Integer id;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "wallet")
	private String wallet;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer _id) {
		this.id = _id;
	}
	
	public String getUsername() {
		return username;
	}public void setUsername(String _username) {
		this.username = _username;
	}
	
	public String getPassword() {
		return password;
	}public void setPassword(String _password) {
		this.password = _password;
	}
	
	public String getWallet() {
		return wallet;
	}public void setWallet(String _wallet) {
		this.wallet = _wallet;
	}
}
