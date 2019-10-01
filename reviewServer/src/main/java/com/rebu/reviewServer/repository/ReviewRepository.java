package com.rebu.reviewServer.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rebu.reviewServer.model.Review;

import java.util.List;

@Repository
public interface ReviewRepository extends CrudRepository<Review, String> {
	public List<Review> findByReviewid(Integer reviewid); 
	public List<Review> findByDeliver(String deliver); 
}
