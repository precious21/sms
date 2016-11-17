package com.momentumTech.rms.springmvc.service;

import java.util.List;

import com.momentumTech.rms.springmvc.dto.RmsGuestDto;

public interface RmsFoodConsumptionService {

	  boolean saveFoodConsumption(RmsGuestDto guestDto);
	  
}