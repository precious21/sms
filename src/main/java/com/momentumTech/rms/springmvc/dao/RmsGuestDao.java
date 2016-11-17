package com.momentumTech.rms.springmvc.dao;

import java.util.List;

import com.momentumTech.rms.springmvc.domain.RmsGuestDomain;
import com.momentumTech.rms.springmvc.domain.RmsUserDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitMenuPlaneDomain;

public interface RmsGuestDao {

	  String save(RmsGuestDomain guestDomain);

	  boolean update(RmsGuestDomain guestDomain);

	  boolean delete(RmsGuestDomain guestDomain);

	  RmsGuestDomain getGuestById(String userId);

	  List<RmsGuestDomain> getGuestList();
	  
	  String saveVisit(RmsVisitDomain visitDomain);
	  
	  String saveVisitMenuPlane(RmsVisitMenuPlaneDomain visitPlaneDomain);
	  
	  RmsGuestDomain getGuestDomainByQuery(String query);
	  
	  
}
