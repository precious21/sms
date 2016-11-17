package com.momentumTech.rms.springmvc.dao;

import java.util.List;

import com.momentumTech.rms.springmvc.domain.RmsFoodConsumptionDomain;

public interface RmsFoodConsumptionDao {

	  String save(RmsFoodConsumptionDomain foodConsumptionDomain);

	  boolean update(RmsFoodConsumptionDomain foodConsumptionDomain);

	  boolean delete(RmsFoodConsumptionDomain foodConsumptionDomain);

	  RmsFoodConsumptionDomain getFoodConsumptionById(String foodConsumptionId);

	  List<RmsFoodConsumptionDomain> getFoodConsumptionList();
	  
	  RmsFoodConsumptionDomain getFoodConsumptionDomainByQuery(String query);
	  
	  
}
