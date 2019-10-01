package com.rebu.orderServer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebu.orderServer.model.Deliverer;

@FeignClient("delivererserver")
public interface DelivererFerignClient {
	@RequestMapping(method = RequestMethod.GET,
			value = "/deliverer/delivererList",
			consumes = "application/json")
	List<Deliverer> getDelivererByStatue();
	
	@RequestMapping(method = RequestMethod.GET,
			value = "/deliverer/username/{username}",
			consumes = "application/json")
	Deliverer getDelivererByUsername(@PathVariable("username") String Username);

	@RequestMapping(method = RequestMethod.POST,
			value = "/deliverer/refreshStatus",
			consumes = "application/json")
	Deliverer setDelivererStatue(@RequestBody Deliverer d);
}
