package com.rebu.delivererServer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rebu.delivererServer.model.Deliverer;

@Repository
public interface DelivererRepository extends CrudRepository<Deliverer, String>{
	public List<Deliverer> findById(Integer id);
	public List<Deliverer> findByUsername(String Username);
	public List<Deliverer> findByUsernameAndPassword(String Username, String Password);
}
