package com.rebu.reviewServer.services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebu.reviewServer.client.OrderFerignClient;
import com.rebu.reviewServer.config.ServiceConfig;
import com.rebu.reviewServer.model.Order;
import com.rebu.reviewServer.model.Review;
import com.rebu.reviewServer.repository.ReviewRepository;


@Service
public class ReivewService {
	@Autowired
	private ReviewRepository repository;
	
	@Autowired
	ServiceConfig config;
	
	@Autowired
	OrderFerignClient client;
	
	public List<Review> getReviewByReviewid(int reviewid) {
		return repository.findByReviewid(reviewid);
	}
	
	public List<Review> getReviewByDeliver(String deliver) {
		return repository.findByDeliver(deliver);
	}
	
	public void saveReqeuset(Review r) {
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		
		r.setDate(ts);
		System.out.println("timeStamp : "+ts);

		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		System.out.println("rand : "+rand.nextInt(2123456789));
		r.setReviewid(rand.nextInt(2123456789));
		
		repository.save(r);
	}
	
	public Iterable<Review> getAll() {
		return repository.findAll();
	}
	
	public long getCnt() {
		return repository.count();
	}
	
	public void reviewed(Integer orderid) {
		client.reviewed(orderid);
	}
}
