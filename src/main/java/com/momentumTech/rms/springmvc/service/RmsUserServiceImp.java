package com.momentumTech.rms.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.momentumTech.rms.springmvc.dao.RmsUserDao;
import com.momentumTech.rms.springmvc.domain.RmsUserDomain;
import com.momentumTech.rms.springmvc.dto.RmsUserDto;

@Service("userService")
@Transactional
public class RmsUserServiceImp implements RmsUserService {
	@Autowired
	private RmsUserDao userDao;
	
	public boolean saveUser(RmsUserDomain userDomain) {
		String userId= userDao.save(userDomain);
		boolean flag = false;
	    if (userId != null && !userId.equals("")) {
	      flag = true;
	    }
	    return flag;
	}
	
	public boolean updateUser(RmsUserDomain userDomain) {
	    boolean flag = userDao.update(userDomain);
	    return flag;
	}
	
	public boolean deleteUser(String userId) {
		RmsUserDomain userDomain = userDao.getUserById(userId);
	    boolean flag = userDao.delete(userDomain);
	    return flag;
	  }
	
	public List<RmsUserDomain> getUserList() {
	    List<RmsUserDomain> userDomainList = userDao.getUserList();
	    return userDomainList;
	  }
	
	public RmsUserDomain getUserById(String userId) {
		RmsUserDomain userDomain = userDao.getUserById(userId);
	    if (userDomain != null)
	      return userDomain;
	    else
	      return null;
	  }
	
	public RmsUserDomain validateUser(RmsUserDto userDto) {
		RmsUserDomain rmsUserDomain=convertUserDtoToDomain(userDto);
	    return userDao.validateUser(rmsUserDomain);
	  }
	
	public RmsUserDomain convertUserDtoToDomain(RmsUserDto userDto){
		RmsUserDomain rmsUserDomain = new RmsUserDomain();
		rmsUserDomain.setUserId(userDto.getUserId());
		rmsUserDomain.setUsername(userDto.getUsername());
		rmsUserDomain.setUserType(userDto.getUserType());
		rmsUserDomain.setEmailId(userDto.getEmailId());
		rmsUserDomain.setFirstName(userDto.getFirstName());
		rmsUserDomain.setLastName(userDto.getLastName());
		rmsUserDomain.setPassword(userDto.getPassword());
		rmsUserDomain.setPhoneNo(userDto.getPhoneNo());
		rmsUserDomain.setStatus(userDto.getStatus());
		rmsUserDomain.setCreatedBy(userDto.getCreatedBy());
		rmsUserDomain.setCreatedOn(userDto.getCreatedOn());
		rmsUserDomain.setUpdatedBy(userDto.getUpdatedBy());
		rmsUserDomain.setUpdatedOn(userDto.getUpdatedOn());
		return rmsUserDomain;
	}
	public RmsUserDto convertUserDomainToDto(RmsUserDomain userDomain){
		RmsUserDto rmsUserDto = new RmsUserDto();
		rmsUserDto.setUserId(userDomain.getUserId());
		rmsUserDto.setUsername(userDomain.getUsername());
		rmsUserDto.setUserType(userDomain.getUserType());
		rmsUserDto.setEmailId(userDomain.getEmailId());
		rmsUserDto.setFirstName(userDomain.getFirstName());
		rmsUserDto.setLastName(userDomain.getLastName());
		rmsUserDto.setPassword(userDomain.getPassword());
		rmsUserDto.setPhoneNo(userDomain.getPhoneNo());
		rmsUserDto.setStatus(userDomain.getStatus());
		rmsUserDto.setCreatedBy(userDomain.getCreatedBy());
		rmsUserDto.setCreatedOn(userDomain.getCreatedOn());
		rmsUserDto.setUpdatedBy(userDomain.getUpdatedBy());
		rmsUserDto.setUpdatedOn(userDomain.getUpdatedOn());
		return rmsUserDto;
	}
}
