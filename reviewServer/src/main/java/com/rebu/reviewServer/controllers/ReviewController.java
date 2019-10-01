package com.rebu.reviewServer.controllers;

import java.util.List;
import java.util.Map;

import org.bouncycastle.util.Iterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rebu.reviewServer.model.Review;
import com.rebu.reviewServer.model.ReviewAndOrderId;
import com.rebu.reviewServer.services.ReivewService;

@RestController
@RequestMapping(value = "review")
public class ReviewController {
	@Autowired
	ReivewService reivewService;
	
	@GetMapping(value = "/reviewid/{reviewId}")
	public List<Review> getReviewByReviewId(@PathVariable("reviewId") Integer reviewid) {
		return reivewService.getReviewByReviewid(reviewid);
	}
	@GetMapping(value = "/deliver/{deliver}")
	public List<Review> getReviewByDeliver(@PathVariable("deliver") String deliver) {
		List<Review> r = reivewService.getReviewByDeliver(deliver);
		return reivewService.getReviewByDeliver(deliver);
	}
	/*
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public Review saveReview(@RequestBody Review review) {
		reivewService.saveReqeuset(review);
		return review;
	}
	*/
	@RequestMapping(value = "/getCnt", method = RequestMethod.GET)
	public long getCnt() {
		return reivewService.getCnt();
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ReviewAndOrderId uploadReview(@RequestBody ReviewAndOrderId reviewAndOrderId) {
		Review review = new Review();
		Integer orderid = reviewAndOrderId.getOrder();
		
		review.setDeliver(reviewAndOrderId.getDeliver());
		review.setText(reviewAndOrderId.getText());
		
		reivewService.reviewed(orderid);
		reivewService.saveReqeuset(review);
		
		return reviewAndOrderId;
	}
}
