package com.momentumTech.rms.springmvc.dao;

import java.util.List;

import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitMenuPlaneDomain;

public interface RmsVisitMenuPlaneDao {
	
	  String save(RmsVisitMenuPlaneDomain visitMenuPlaneDomain);

	  boolean update(RmsVisitMenuPlaneDomain visitMenuPlaneDomain);

	  boolean delete(RmsVisitMenuPlaneDomain visitMenuPlaneDomain);

	  RmsVisitMenuPlaneDomain getVisitMenuPlaneById(String visitId);

	  List<RmsVisitMenuPlaneDomain> getVisitMenuPlaneList();
	  
	  List<RmsVisitMenuPlaneDomain> getVisitMenuPlaneListByQuery(String query);
	  
	  RmsVisitMenuPlaneDomain getVisitMenuPlaneDomainByQuery(String query);
}
