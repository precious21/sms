package com.momentumTech.rms.springmvc.service;

import java.util.List;

import com.momentumTech.rms.springmvc.domain.RmsGuestDomain;
import com.momentumTech.rms.springmvc.dto.RmsGuestDto;

public interface RmsGuestService {

	  boolean saveGuest(RmsGuestDto guestDto);

	  boolean updateGuest(RmsGuestDto guestDto);

	  boolean deleteGuest(String guestDto);

	  List<RmsGuestDto> getGuestList();

	  RmsGuestDto getGuestById(String userId);
	  
	  RmsGuestDto getGuestDomainBySearchCretaria(RmsGuestDto rmsGuestDto);
	  
	  RmsGuestDomain convertGuestDtoToDomain(RmsGuestDto rmsGuestDto);
	  
	  RmsGuestDto convertGuestDomainToDto(RmsGuestDomain guestDomain);
	  
}
