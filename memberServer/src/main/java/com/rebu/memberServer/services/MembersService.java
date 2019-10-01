package com.rebu.memberServer.services;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebu.memberServer.config.ServerConfig;
import com.rebu.memberServer.model.MembersModel;
import com.rebu.memberServer.repository.MembersRepository;

@Service
public class MembersService {
	@Autowired
	private MembersRepository membersRepository;
	
	@Autowired
	ServerConfig config;
	
	public MembersModel getMembersModel(String Username, String Password) {
		MembersModel members = membersRepository.findByUsernameAndPassword(Username, Password);
		return members;
	}
	
	public MembersModel getMembersModelsByOrg(String Username){
		return membersRepository.findByUsername(Username);
	}
	
	public void saveMembersModel(MembersModel members) {
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		System.out.println("rand : "+rand.nextInt(2123456789));
		members.setId(rand.nextInt(2123456789));
		membersRepository.save(members);
	}
	public void updateMembersModel(MembersModel members) {
		membersRepository.save(members);
	}
	public void deleteMembersModel(MembersModel members) {
		membersRepository.delete(members);
	}
	public Iterable<MembersModel> getAll() {
		return membersRepository.findAll();
	}
	public long getCnt() {
		return membersRepository.count();
	}
}
