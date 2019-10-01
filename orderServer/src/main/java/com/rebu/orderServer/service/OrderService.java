package com.rebu.orderServer.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.rebu.orderServer.client.DelivererFerignClient;
import com.rebu.orderServer.client.MemberFerignClient;
import com.rebu.orderServer.config.ServiceConfig;
import com.rebu.orderServer.model.Deliverer;
import com.rebu.orderServer.model.MembersModel;
import com.rebu.orderServer.model.Order;
import com.rebu.orderServer.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ServiceConfig config;
	
	@Autowired
	private DelivererFerignClient client;
	
	@Autowired
	private MemberFerignClient memberClient;
	
	public Order getOrderByOrderId(Integer OrderId){
		return orderRepository.findByOrderid(OrderId);
	}
	public List<Order> getOrderBySend(String send){
		return orderRepository.findBySend(send);
	}
	public List<Order> getOrderByReceive(String receive){
		return orderRepository.findByReceive(receive);
	}
	public List<Order> getOrderByDeliver(String deliver){
		return orderRepository.findByDeliver(deliver);
	}
	
	
	public void saveOrder(Order o) {
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		
		o.setDate(ts);
		System.out.println("timeStamp : "+ts);
		
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		System.out.println("rand : "+rand.nextInt(2123456789));
		o.setOrderId(rand.nextInt(2123456789));
		
		orderRepository.save(o);
	}
	public void updateOrder(Order o) {
		Order res = orderRepository.findByOrderid(o.getOrderId());
		Deliverer d = client.getDelivererByUsername(o.getDeliver());
		
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		
		res.setDate(ts);
		res.setDeliver(o.getDeliver());
		res.setStatus(1);
		d.setStatus(2);

		System.out.println("delivererUsername : "+d.getUsername());
		System.out.println("delivererId : "+d.getId());
		
		setDelivererStatus(d);
		
		orderRepository.save(res);
	}
	
	public List<Deliverer> getDelivererList() {
		List<Deliverer> res = client.getDelivererByStatue();
		return res;
	}
	
	public void setDelivererStatus(Deliverer d) {
		client.setDelivererStatue(d);
	}
	
	public Order getOrderByDeliverCanTake(String Deliver) {
		Order res;
		res = orderRepository.findByDeliverAndStatus(Deliver, 0);
		if(res != null) return res;
		res = orderRepository.findByDeliverAndStatus(Deliver, 1);
		if(res != null) return res;
		res = orderRepository.findByDeliverAndStatus(Deliver, 2);
		return res;
	}
	
	public List<String> getMerchandise(String delivererName) {
		Deliverer deliverer = client.getDelivererByUsername(delivererName);
		deliverer.setStatus(deliverer.getStatus() + 1);
		client.setDelivererStatue(deliverer);
		
		Order order = orderRepository.findByDeliverAndStatus(delivererName, 1);
		order.setStatus(2);
		orderRepository.save(order);
		
		MembersModel member = memberClient.getMembersByUsername(order.getSend());
		List<String> res = new ArrayList<String>();
		res.add(member.getWallet());
		
		member = memberClient.getMembersByUsername(order.getReceive());
		res.add(member.getWallet());
		return res;
	}
	
	public String finishDeliver(String delivererName) {
		Deliverer deliverer = client.getDelivererByUsername(delivererName);
		deliverer.setStatus(0);
		client.setDelivererStatue(deliverer);
		
		Order order = orderRepository.findByDeliverAndStatus(delivererName, 2);
		order.setStatus(3);
		orderRepository.save(order);
		
		MembersModel member = memberClient.getMembersByUsername(order.getReceive());
		System.out.println("member get wallet : "+ member.getWallet());
		return member.getWallet();
	}
	
	public List<Order> getOrderList(String username) {
		List<Order> res = new ArrayList<Order>();
		List<Order> listBySend = orderRepository.findBySend(username);
		List<Order> listByRecv = orderRepository.findByReceive(username);
		res.addAll(listByRecv);
		res.addAll(listBySend);
		return res;
	}
	
	public void reviewed(Integer orderid) {
		Order o = orderRepository.findByOrderid(orderid);
		o.setStatus(4);
		orderRepository.save(o);
	}
	
	public List<Order> getAll() {
		Iterable<Order> tmp = orderRepository.findAll();
		Iterator<Order> tmp2 = tmp.iterator();
		
		List<Order> res = new ArrayList<Order>();
		
		while(tmp2.hasNext()) {
			res.add(tmp2.next());
		}
		
		return res;
	}
	public long getCnt() {
		return orderRepository.count();
	}
}
