package com.rebu.purchaseServer.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import com.rebu.purchaseServer.model.*;
import java.util.List;

@Repository
public interface purchaseRepository extends CrudRepository<purchase, String>{
	public List<purchase> findByPurchaseid(Integer purchaseid);
	public List<purchase> findByUserid(Integer Userid);
	public List<purchase> findByGoodsid(Integer Goodsid);
}
