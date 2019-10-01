package com.rebu.orderServer.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rebu.orderServer.model.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, String>{
	public Order findByOrderid(Integer OrderId);
	
	public List<Order> findBySend(String send);
	public List<Order> findByReceive(String receive);
	public List<Order> findByDeliver(String deliver);
	public Order findByDeliverAndStatus(String deliver, Integer status);
	
}
