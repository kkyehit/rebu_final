package com.rebu.orderServer.service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebu.orderServer.config.ServiceConfig;
import com.rebu.orderServer.model.Order;
import com.rebu.orderServer.repository.OrderRepository;
@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private ServiceConfig config;
	
	public List<Order> getOrderByOrderId(Integer OrderId){
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
		orderRepository.save(o);
	}
}
