package com.rebu.delivererServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rebu.delivererServer.model.Deliverer;
import com.rebu.delivererServer.services.DelivererService;

@RestController
@RequestMapping(value = "deliverer")
public class DelivererController {
	@Autowired
	private DelivererService delivererService;
	
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	public List<Deliverer> getDelivererByUsername(@PathVariable("username") String Username) {
		return delivererService.getDelivererByUsername(Username);
	}
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public List<Deliverer> getDelivererById(@PathVariable("id") Integer id) {
		return delivererService.getDeliverersById(id);
	}
	
	@RequestMapping(value = "/username/{username}/", method = RequestMethod.POST)
	public List<Deliverer> getDelivererByUsernameAndPassword(@PathVariable("username") String Username, @RequestBody Deliverer d) {
		return delivererService.getDelivererByUsernameAndPassword(Username, d.getPassword());
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public Deliverer getDelivererByUsernameAndPassword(@RequestBody Deliverer d) {
		delivererService.saveDeliverer(d);
		return d;
	}
}
