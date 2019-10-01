package com.rebu.reviewServer.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class Review {
	@Id
	@Column(name ="reviewid", nullable =false)
	private Integer reviewid;

	@Column(name ="deliver", nullable =false)
	private String deliver;

	@Column(name ="date")
	private Timestamp date;

	@Column(name ="text")
	private String text;
	
	public Integer getReviewid() { return reviewid; }
	public void setReviewid(Integer _reviewid) { this.reviewid = _reviewid;}
	
	public String getDeliver() { return deliver; }
	public void setDeliver(String _deliver) { this.deliver = _deliver;}
	
	public Timestamp getDate() { return date; }
	public void setDate(Timestamp _date) { this.date = _date;}
	
	public String getText() { return text; }
	public void setText(String _text) { this.text = _text;}
	
	
}
