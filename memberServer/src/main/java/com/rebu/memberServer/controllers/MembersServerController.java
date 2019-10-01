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
@RequestMapping(value = "members")
public class MembersServerController {
	@Autowired
	private MembersService membersService;
	
	@RequestMapping(value = "/username/{username}", method = RequestMethod.GET)
	public MembersModel getMembers(@PathVariable("username") String Username){
		System.out.println("username : "+ Username);
		
		MembersModel res = membersService.getMembersModelsByOrg(Username);
		//if(res == null) return "not found";
		//else return res.getPassword();
		return res;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public MembersModel findMembers(@RequestBody MembersModel members) {
		membersService.saveMembersModel(members);
		return members;
	}
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public MembersModel saveMembers(@RequestBody MembersModel members) {
		membersService.saveMembersModel(members);
		return members;
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public MembersModel updateMembers(@RequestBody MembersModel members) {
		MembersModel res = membersService.getMembersModel(members.getUsername(), members.getPassword());
		System.out.println("res wallet" + res.getWallet());
		System.out.println("res password" + res.getPassword());
		System.out.println("res username" + res.getUsername());

		System.out.println("member wallet" + members.getWallet());
		System.out.println("member password" + members.getPassword());
		System.out.println("member username" + members.getUsername());
		
		res.setWallet(members.getWallet());
		membersService.updateMembersModel(res);
		return res;
	}
	@RequestMapping(value = "/getCnt", method = RequestMethod.GET)
	public long getCnt() {
		return membersService.getCnt();
	}
}
