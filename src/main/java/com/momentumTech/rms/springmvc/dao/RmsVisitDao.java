package com.momentumTech.rms.springmvc.dao;

import java.util.List;

import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;

public interface RmsVisitDao {

	  String save(RmsVisitDomain visitDomain);

	  boolean update(RmsVisitDomain guestDomain);

	  boolean delete(RmsVisitDomain guestDomain);

	  RmsVisitDomain getVisitById(String visitId);

	  List<RmsVisitDomain> getVisitList();
	  
	  List<RmsVisitDomain> getVisitListByQuery(String query);
	  
	  RmsVisitDomain getVisitDomainByQuery(String query);
}
