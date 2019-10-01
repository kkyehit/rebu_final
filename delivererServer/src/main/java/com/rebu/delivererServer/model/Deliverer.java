package com.rebu.delivererServer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deliverers")
public class Deliverer {

	@Id
	@Column(name = "id")
	private Integer id;
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name="status")
	private Integer status;
	@Column(name="x")
	private String x;
	@Column(name="y")
	private String y;
	@Column(name="wallet")
	private String wallet;
	
	public Integer getId() { return id;}
	public void setId(Integer _id) {this.id = _id;}
	
	public String getUsername() { return username;}
	public void setUsername(String _username) {this.username = _username;}
	
	public String getPassword() { return password;}
	public void setPassword(String _password) {this.password = _password;}
	
	public Integer getStatus() { return status;}
	public void setStatus(Integer _status) {this.status = _status;}
	
	public String getX() { return x;}
	public void setX(String _x) {this.x = _x;}

	public String getY() { return y;}
	public void setY(String _y) {this.y = _y;}
	
	public String getWallet() {
		return wallet;
	}public void setWallet(String _wallet) {
		this.wallet = _wallet;
	}
}
