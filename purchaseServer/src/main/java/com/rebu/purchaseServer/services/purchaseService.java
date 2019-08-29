package com.rebu.purchaseServer.services;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebu.purchaseServer.config.ServiceConfig;
import com.rebu.purchaseServer.model.purchase;
import com.rebu.purchaseServer.repository.purchaseRepository;

@Service
public class purchaseService {
	@Autowired
	private purchaseRepository purchaserepository;
	
	@Autowired
	ServiceConfig config;
	
	public List<purchase> getPurchase(Integer id) {
		return purchaserepository.findByPurchaseid(id);
	}
	public List<purchase> getPurchaseByUserId(Integer UserId) {
		return purchaserepository.findByUserid(UserId);
	}
	public List<purchase> getPurchaseByGoodsId(Integer GoodsId) {
		return purchaserepository.findByGoodsid(GoodsId);
	}
	
	public void savePurchase(purchase p) {
		SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd hh:mm:ss");
		Calendar cal = Calendar.getInstance();
		String today = null;
		today = formatter.format(cal.getTime());
		Timestamp ts = Timestamp.valueOf(today);
		
		p.setDate(ts);
		System.out.println("timeStamp : "+ts);
		purchaserepository.save(p);
	}
}
