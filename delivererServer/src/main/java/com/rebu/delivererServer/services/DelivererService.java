package com.rebu.delivererServer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebu.delivererServer.repository.DelivererRepository;
import com.rebu.delivererServer.config.*;
import com.rebu.delivererServer.model.Deliverer;

@Service
public class DelivererService {
	@Autowired
	private DelivererRepository delivererRepository;
	
	@Autowired
	ServiceConfig config;
	
	public List<Deliverer> getDelivererByUsername(String Username){
		return delivererRepository.findByUsername(Username);
	}
	
	public List<Deliverer> getDelivererByUsernameAndPassword(String Username, String Password){
		return delivererRepository.findByUsernameAndPassword(Username, Password);
	}
	
	public List<Deliverer> getDeliverersById(Integer id){
		return delivererRepository.findById(id);
	}
	
	public void saveDeliverer(Deliverer deliverer) {
		delivererRepository.save(deliverer);
	}
	public void deleteDeliverer(Deliverer deliverer) {
		delivererRepository.delete(deliverer);
	}
}
