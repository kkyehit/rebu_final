package com.rebu.memberServer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rebu.memberServer.model.MembersModel;
import com.rebu.memberServer.services.MembersService;

@RestController
@RequestMapping(value = "members/username/{username}")
public class MembersServerController {
	@Autowired
	private MembersService membersService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<MembersModel> getMembers(@PathVariable("username") String Username){
		return membersService.getMembersModelsByOrg(Username);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public MembersModel saveMembers(@RequestBody MembersModel members) {
		membersService.saveMembersModel(members);
		return members;
	}
}
