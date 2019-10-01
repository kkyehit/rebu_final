package com.rebu.orderServer.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rebu.orderServer.model.Deliverer;
import com.rebu.orderServer.model.Order;
import com.rebu.orderServer.repository.OrderRepository;
import com.rebu.orderServer.service.OrderService;

@RestController
@RequestMapping(value="order")
public class OrderServerController {
	@Autowired
	OrderService orderService;
	
	@RequestMapping(value="/orderid/{orderid}", method = RequestMethod.GET)
	public Order getOrderById(@PathVariable("orderid") Integer OrderId) {
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
	
	@RequestMapping(value="/update", method = RequestMethod.POST)
	public Order updateOrder(@RequestBody Order order) {
		//order res = orderService.get
		orderService.updateOrder(order);
		return order;
	}
	
	
	@RequestMapping(value="/delivererList", method = RequestMethod.GET)
	public List<Deliverer> getDeliverer() {
		return orderService.getDelivererList();
	}
	
	@RequestMapping(value="/setDelivererStatus", method = RequestMethod.POST)
	public Deliverer setDelivererStatus(@RequestBody Deliverer d) {
		orderService.setDelivererStatus(d);
		return d;
	}
	
	@RequestMapping(value = "/getCurOrder/{deliver}", method = RequestMethod.GET)
	public Order getCurOrder(@PathVariable("deliver") String deliver) {
		Order res = orderService.getOrderByDeliverCanTake(deliver);
		return res;
	}
	
	@RequestMapping(value = "/getMerchandise/{deliver}", method = RequestMethod.GET)
	public List<String> getMerchandise(@PathVariable("deliver") String deliver) {
		return orderService.getMerchandise(deliver);
	}
	
	@RequestMapping(value = "/finishDeliver/{deliver}", method = RequestMethod.GET)
	public String finishDeliver(@PathVariable("deliver") String deliver) {
		return orderService.finishDeliver(deliver);
	}
	
	
	@RequestMapping(value = "/getOrderList/{username}", method = RequestMethod.GET)
	public List<Order> getOrderList(@PathVariable("username") String username) {
		return orderService.getOrderList(username);
	}
	
	@RequestMapping(value = "/reviewed/{orderid}", method = RequestMethod.GET)
	public void reviewed(@PathVariable("orderid") Integer orderid) {
		orderService.reviewed(orderid);
	}
	
	@RequestMapping(value = "/getCnt", method = RequestMethod.GET)
	public long getCnt() {
		return orderService.getCnt();
	}
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Order> getAll() {
		return orderService.getAll();
	}
}
