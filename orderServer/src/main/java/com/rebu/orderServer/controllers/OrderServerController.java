package com.rebu.orderServer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rebu.orderServer.model.Order;
import com.rebu.orderServer.service.OrderService;

@RestController
@RequestMapping(value="order")
public class OrderServerController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/orderid/{orderid}", method = RequestMethod.GET)
	public List<Order> getOrderById(@PathVariable("orderid") Integer OrderId) {
		return orderService.getOrderByOrderId(OrderId);
	}
	@RequestMapping(value="/send/{send}", method = RequestMethod.GET)
	public List<Order> getOrderBySend(@PathVariable("send") String send) {
		return orderService.getOrderBySend(send);
	}
	@RequestMapping(value="/receive/{receive}", method = RequestMethod.GET)
	public List<Order> getOrderByReceive(@PathVariable("receive") String receive) {
		return orderService.getOrderByReceive(receive);
	}
	@RequestMapping(value="/deliver/{deliver}", method = RequestMethod.GET)
	public List<Order> getOrderByDeliver(@PathVariable("deliver") String deliver) {
		return orderService.getOrderByDeliver(deliver);
	}
	
	
	@RequestMapping(value="/", method = RequestMethod.POST)
	public Order saveOrder(@RequestBody Order order) {
		orderService.saveOrder(order);
		return order;
	}
	
	
}
