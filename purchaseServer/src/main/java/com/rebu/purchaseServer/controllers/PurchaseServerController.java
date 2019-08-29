package com.rebu.purchaseServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rebu.purchaseServer.model.purchase;
import com.rebu.purchaseServer.services.purchaseService;

@RestController
@RequestMapping(value="purchase")
public class PurchaseServerController {
	@Autowired
	private purchaseService purchaseservice;
	
	@RequestMapping(value = "/userId/{userId}", method = RequestMethod.GET)
	public List<purchase> getPurchasesUserId(@PathVariable("userId") Integer userId){
		return purchaseservice.getPurchaseByUserId(userId);
	}
	@RequestMapping(value = "/Id/{Id}", method = RequestMethod.GET)
	public List<purchase> getPurchasesId(@PathVariable("Id") Integer Id){
		System.out.println("Id : "+Id);
		return purchaseservice.getPurchase(Id);
	}
	@RequestMapping(value = "/goodsId/{goodId}", method = RequestMethod.GET)
	public List<purchase> getPurchasesGoodsId(@PathVariable("goodsId") Integer goodsId){
		return purchaseservice.getPurchaseByUserId(goodsId);
	}
	@RequestMapping(value="/",method = RequestMethod.POST)
    public void saveLicenses(@RequestBody purchase p) {
       purchaseservice.savePurchase(p);
    }
}
