package com.rebu.delivererServer.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rebu.delivererServer.model.Deliverer;
import com.rebu.delivererServer.model.MembersModel;
import com.rebu.delivererServer.services.DelivererService;

@RestController
@RequestMapping(value = "deliverer")
public class DelivererController {
	@Autowired
	private DelivererService delivererService;
	
	/*@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	public MembersModel getDelivererByUsername(@PathVariable("username") String Username) {
		return delivererService.getModeByName(Username);
	}*/
	
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public Deliverer getDelivererById(@PathVariable("id") Integer id) {
		return delivererService.getDeliverersById(id);
	}
	
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	public Deliverer getDelivererByUsername(@PathVariable("username") String Username) {
		System.out.println("getDelivererByUsername user : " + Username);
		return delivererService.getDelivererByUsername(Username);
	}
	
	@RequestMapping(value = "/getStatus/{username}", method = RequestMethod.GET)
	public int getStatusByUsername(@PathVariable("username") String Username) {
		System.out.println("getStatusByUsernam user : " + Username);
		return delivererService.getDelivererByUsername(Username).getStatus();
	}
	@RequestMapping(value = "/delivererList", method = RequestMethod.GET)
	public List<Deliverer> getWaiting() {
		return delivererService.getList();
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public Deliverer saveDeliverer(@RequestBody Deliverer d) {
		delivererService.saveDeliverer(d);
		return d;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public Deliverer getDelivererUpdate(@RequestBody Deliverer d) {
		delivererService.updateDeliverer(d);
		return d;
	}
	
	@RequestMapping(value = "/refreshXY", method = RequestMethod.POST)
	public Deliverer getDelivererUsetDelivererStatuspdateXY(@RequestBody Deliverer d) {
		delivererService.updateDelivererXY(d);
		return d;
	}
	@RequestMapping(value = "/refreshStatus", method = RequestMethod.POST)
	public Deliverer getDelivererUpdateStatus(@RequestBody Deliverer d) {
		if(d.getStatus() == null) d.setStatus(new Integer(0));
		delivererService.updateDelivererStatus(d);
		return d;
	}
	@RequestMapping(value = "/getCnt", method = RequestMethod.GET)
	public long getCnt() {
		return delivererService.getCnt();
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<Deliverer> getAll() {
		return delivererService.getAll();
	}
}
