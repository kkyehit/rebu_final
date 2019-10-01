package com.rebu.delivererServer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.rebu.delivererServer.model.MembersModel;

@FeignClient("memberserver")
public interface MemberFerignClient {
	@RequestMapping(method = RequestMethod.GET,
			value = "/members/username/{username}",
			consumes = "application/json")
	MembersModel getMembers(@PathVariable("username") String username);
}
