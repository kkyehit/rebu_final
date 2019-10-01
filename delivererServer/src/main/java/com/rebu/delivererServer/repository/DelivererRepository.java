package com.rebu.delivererServer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rebu.delivererServer.model.Deliverer;

@Repository
public interface DelivererRepository extends CrudRepository<Deliverer, String>{
	public Deliverer findById(Integer id);
	public Deliverer findByUsername(String Username);
	public List<Deliverer> findByStatus(Integer Status);
	public Deliverer findByUsernameAndPassword(String Username, String Password);
}
