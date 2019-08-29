package com.rebu.memberServer.repository;

import com.rebu.memberServer.model.*;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembersRepository extends CrudRepository<MembersModel,String> {
	public List<MembersModel> findByUsername(String Username);
    public MembersModel findByUsernameAndPassword(String Username,String Password);
}
