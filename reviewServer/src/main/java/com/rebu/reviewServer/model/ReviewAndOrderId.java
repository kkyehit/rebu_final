package com.rebu.reviewServer.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public class ReviewAndOrderId {
	private Integer reviewid;

	private Integer order;
	
	private String deliver;

	private Timestamp date;

	private String text;
	
	public Integer getReviewid() { return reviewid; }
	public void setReviewid(Integer _reviewid) { this.reviewid = _reviewid;}
	
	public Integer getOrder() { return order; }
	public void setOrder(Integer _order) { this.order = _order;}
	
	public String getDeliver() { return deliver; }
	public void setDeliver(String _deliver) { this.deliver = _deliver;}
	
	public Timestamp getDate() { return date; }
	public void setDate(Timestamp _date) { this.date = _date;}
	
	public String getText() { return text; }
	public void setText(String _text) { this.text = _text;}
	
	
}
