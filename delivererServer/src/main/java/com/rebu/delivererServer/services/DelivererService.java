package com.rebu.delivererServer.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.tools.Diagnostic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebu.delivererServer.repository.DelivererRepository;
import com.rebu.delivererServer.client.MemberFerignClient;
import com.rebu.delivererServer.config.*;
import com.rebu.delivererServer.model.Deliverer;
import com.rebu.delivererServer.model.MembersModel;

@Service
public class DelivererService {
	@Autowired
	private DelivererRepository delivererRepository;
	
	@Autowired
	ServiceConfig config;
	
	@Autowired
	MemberFerignClient memberFerignClient;
	public Deliverer getDelivererByUsername(String Username){
		return delivererRepository.findByUsername(Username);
	}
	
	public Deliverer getDelivererByUsernameAndPassword(String Username, String Password){
		return delivererRepository.findByUsernameAndPassword(Username, Password);
	}
	
	public Deliverer getDeliverersById(Integer id){
		return delivererRepository.findById(id);
	}
	
	public void saveDeliverer(Deliverer deliverer) {
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		System.out.println("rand : "+rand.nextInt(2123456789));
		deliverer.setId(rand.nextInt(2123456789));
		
		delivererRepository.save(deliverer);
	}
	public void updateDeliverer(Deliverer deliverer) {
		Deliverer res = getDelivererByUsernameAndPassword(deliverer.getUsername(), deliverer.getPassword());
		res.setWallet(deliverer.getWallet());
		delivererRepository.save(res);
	}
	
	public void updateDelivererXY(Deliverer deliverer) {
		Deliverer res = getDeliverersById(deliverer.getId());
		res.setX(deliverer.getX());
		res.setY(deliverer.getY());
		res.setStatus(deliverer.getStatus());
		delivererRepository.save(res);
	}
	
	public void updateDelivererStatus(Deliverer deliverer) {
		Deliverer res = getDeliverersById(deliverer.getId());
		res.setStatus(deliverer.getStatus());
		delivererRepository.save(res);
	}
	
	public void deleteDeliverer(Deliverer deliverer) {
		delivererRepository.delete(deliverer);
	}
	
	public List<Deliverer> getList(){
		return delivererRepository.findByStatus(1);
	}
	
	public MembersModel getModeByName(String username) {
		MembersModel members = memberFerignClient.getMembers(username);
		return members;
	}
	
	public List<Deliverer> getAll() {
		Iterable<Deliverer> tmp = delivererRepository.findAll();
		Iterator<Deliverer> tmp2 = tmp.iterator();
		
		List<Deliverer> res = new ArrayList<Deliverer>();
		
		while(tmp2.hasNext()) {
			res.add(tmp2.next());
		}
		
		return res;
	}
	
	public long getCnt() {
		return delivererRepository.count();
	}
}
