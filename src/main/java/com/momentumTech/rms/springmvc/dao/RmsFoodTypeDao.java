package com.momentumTech.rms.springmvc.dao;

import java.util.List;

import com.momentumTech.rms.springmvc.domain.RmsFoodConsumptionDomain;
import com.momentumTech.rms.springmvc.domain.RmsFoodTypeDomain;

public interface RmsFoodTypeDao {

	  String save(RmsFoodTypeDomain foodTypeDomain);

	  boolean update(RmsFoodTypeDomain foodTypeDomain);

	  boolean delete(RmsFoodTypeDomain foodTypeDomain);

	  RmsFoodTypeDomain getFoodTypeById(String foodTypeId);

	  List<RmsFoodTypeDomain> getFoodTypeList();
	  
	  RmsFoodTypeDomain getFoodTypeDomainByQuery(String query);
	  
	  
}
