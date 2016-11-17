package com.momentumTech.rms.springmvc.dao;

import java.util.List;

import com.momentumTech.rms.springmvc.domain.Employee;
import com.momentumTech.rms.springmvc.domain.RmsUserDomain;

public interface RmsUserDao {

	  String save(RmsUserDomain userDomain);

	  boolean update(RmsUserDomain userDomain);

	  boolean delete(RmsUserDomain userDomain);

	  RmsUserDomain getUserById(String userId);

	  List<RmsUserDomain> getUserList();

	  RmsUserDomain validateUser(RmsUserDomain userDomain);
	  
	  //RmsUserDomain getUserByQuery(String query);

}

