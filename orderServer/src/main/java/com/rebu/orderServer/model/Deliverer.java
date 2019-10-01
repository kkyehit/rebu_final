package com.rebu.orderServer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class Deliverer {
	private Integer id;
	private String username;
	private String password;
	private Integer status;
	private String x;
	private String y;
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
