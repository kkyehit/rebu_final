package com.rebu.orderServer.model;

import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Order {
	@Id
	@Column(name="orderid", nullable=false)
	Integer orderid;
	
	@Column(name="send", nullable=false)
	String send;
	@Column(name="receive", nullable=false)
	String receive;
	@Column(name="deliver", nullable=false)
	String deliver;
	
	@Column(name="status", nullable=false)
	Integer status;

	@Column(name="image", nullable=false)
	String image;
	

	@Column(name="fromx", nullable=false)
	String fromx;
	@Column(name="fromy", nullable=false)
	String fromy;
	@Column(name="tox", nullable=false)
	String tox;
	@Column(name="toy", nullable=false)
	String toy;
	
	@Column(name="date", nullable=false)
	Timestamp date;
	

	@Column(name="info", nullable=false)
	String info;

	public Integer getOrderId() {return orderid;};
	public void setOrderId(Integer _orderId) {this.orderid = _orderId;};
	
	public String getSend() {return send;};
	public void setSend(String _send) {this.send = _send;};
	public String getReceive() {return receive;};
	public void setReceive(String _receive) {this.receive = _receive;};
	public String getDeliver() {return deliver;};
	public void setDeliver(String _deliver) {this.deliver = _deliver;};
	
	public Integer getStatus() {return status;};
	public void setStatus(Integer _status) {this.status = _status;};
	
	public String getImage() {return image;};
	public void setImage(String _image) {this.image = _image;};

	public String getFromX() {return fromx;};
	public void setFromX(String _fromx) {this.fromx = _fromx;};
	public String getFromY() {return fromy;};
	public void setFromY(String _fromy) {this.fromy = _fromy;};
	public String getToX() {return tox;};
	public void setToX(String _tox) {this.tox = _tox;};
	public String getToY() {return toy;};
	public void setToY(String _toy) {this.toy = _toy;};
	
	public Timestamp getDate() {return date;}
	public void setDate(Timestamp _date) { this.date = _date;}
	
	public String getInfo() {return info;}
	public void setInfo(String _info) {this.info = _info;}
}
