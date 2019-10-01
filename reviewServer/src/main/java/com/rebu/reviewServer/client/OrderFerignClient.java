package com.rebu.reviewServer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebu.reviewServer.model.Order;

@FeignClient("orderserver")
public interface OrderFerignClient {
	@RequestMapping(method = RequestMethod.GET,
			value = "/order/reviewd/{orderid}",
			consumes = "application/json")
	Order reviewed(@PathVariable("orderid") Integer orderid);
	
	
}
