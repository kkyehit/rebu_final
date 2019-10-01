package com.rebu.orderServer.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebu.orderServer.model.Deliverer;
import com.rebu.orderServer.model.MembersModel;

@FeignClient("memberserver")
public interface MemberFerignClient {
	@RequestMapping(method = RequestMethod.GET,
			value = "/members/username/{username}",
			consumes = "application/json")
	MembersModel getMembersByUsername(@PathVariable("username") String Username);
;
}
