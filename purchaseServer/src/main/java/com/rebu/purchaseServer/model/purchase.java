package com.rebu.purchaseServer.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchases")
public class purchase {
	@Id
	@Column(name = "purchaseid", nullable = false)
	private Integer purchaseid;
	
	@Column(name = "userid", nullable = false)
	private Integer userid;
	
	@Column(name = "goodsid", nullable = false)
	private Integer goodsid;
	
	@Column(name = "date", nullable = false)
	private Timestamp date;

	public Integer getId() { return purchaseid;}
	public void setId(Integer _purchaseid) { this.purchaseid = _purchaseid;}

	public Integer getUserId() { return userid;}
	public void setUserId(Integer _userid) { this.userid = _userid;}

	public Integer getGoodsId() { return goodsid;}
	public void setGoodsId(Integer _goodsid) { this.goodsid = _goodsid;}

	public Timestamp getDate() { return date;}
	public void setDate(Timestamp _date) { this.date = _date;}
}
