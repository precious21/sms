package com.momentumTech.rms.springmvc.service;

import java.util.List;

import com.momentumTech.rms.springmvc.domain.Employee;
import com.momentumTech.rms.springmvc.domain.RmsUserDomain;
import com.momentumTech.rms.springmvc.dto.RmsUserDto;
public interface RmsUserService {

	  boolean saveUser(RmsUserDomain userDomain);

	  boolean updateUser(RmsUserDomain userDomain);

	  boolean deleteUser(String userDomain);

	  List<RmsUserDomain> getUserList();

	  RmsUserDomain getUserById(String userId);
	  
	  RmsUserDomain validateUser(RmsUserDto userDto);
	
}

