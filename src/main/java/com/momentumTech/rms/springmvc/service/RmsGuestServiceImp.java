package com.momentumTech.rms.springmvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.momentumTech.rms.springmvc.dao.RmsGuestDao;
import com.momentumTech.rms.springmvc.dao.RmsVisitDao;
import com.momentumTech.rms.springmvc.dao.RmsVisitMenuPlaneDao;
import com.momentumTech.rms.springmvc.domain.RmsFoodTypeDomain;
import com.momentumTech.rms.springmvc.domain.RmsGuestDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitMenuPlaneDomain;
import com.momentumTech.rms.springmvc.dto.RmsGuestDto;

@Service("guestService")
@Transactional
public class RmsGuestServiceImp implements RmsGuestService {
	@Autowired
	private RmsGuestDao guestDao;
	
	@Autowired
	private RmsVisitDao visitDao;
	
	@Autowired
	private RmsVisitMenuPlaneDao visitMenuPlaneDao;
	
	public boolean saveGuest(RmsGuestDto guestDto) {
		RmsGuestDomain guestDomain = convertGuestDtoToDomain(guestDto);
		String guestId= guestDao.save(guestDomain);
		boolean flag = false;
	    if (guestId != null && !guestId.equals("")) {
	      guestDto.setGuestId(guestId);//set GuestId for saving visit Table
	      String visitId=saveVisit(guestDto);
	      if(visitId!=null && !("").equalsIgnoreCase(visitId.trim())){
	    	  guestDto.setTmpVisitId(visitId);//set visit ID in guestDto for saving visitMenuPlaneTable
	    	  List<String> listVisitMenuPlaneId=saveVisitMenuPlane(guestDto);
	    	  if(listVisitMenuPlaneId!=null && listVisitMenuPlaneId.size()>0 ){
	    		  flag = true;
	    	  }
	      }
	    }
	    return flag;
	}
	
	//saving RmsVisit after RmsGuest
	public String saveVisit(RmsGuestDto guestDto){
		RmsVisitDomain visitDomain=new RmsVisitDomain();
		
		RmsGuestDomain guestDomain=new RmsGuestDomain();
		guestDomain.setGuestId(guestDto.getGuestId());
		
		visitDomain=guestDto.getRmsVisitDomain();
		visitDomain.setRmsGuestDomain(guestDomain);
		visitDomain.setVisitStatus(true);
		return guestDao.saveVisit(visitDomain);
	}
	
	//saving RmsVisit after RmsGuest
		public List<String> saveVisitMenuPlane(RmsGuestDto guestDto){
			RmsVisitMenuPlaneDomain rmsVisitMenuPlaneDomain=new RmsVisitMenuPlaneDomain();
			List<String> stringList=new ArrayList<String>();
			RmsVisitDomain rmsVisitDomain=new RmsVisitDomain();
			rmsVisitDomain.setVisitId(guestDto.getTmpVisitId().trim());
			
			rmsVisitMenuPlaneDomain.setRmsVisitDomain(rmsVisitDomain);
			if(guestDto.getBreakFast()!=null && !("").equalsIgnoreCase(guestDto.getBreakFast().trim())){
				RmsFoodTypeDomain foodTypeDomain=new RmsFoodTypeDomain();
				foodTypeDomain.setFoodTypeId("1");
				rmsVisitMenuPlaneDomain.setRmsFoodTypeDomain(foodTypeDomain);
				
				rmsVisitMenuPlaneDomain.setFoodLimit(guestDto.getBreakFast().trim());
				rmsVisitMenuPlaneDomain.setRemaining(guestDto.getBreakFast().trim());
				stringList.add(guestDao.saveVisitMenuPlane(rmsVisitMenuPlaneDomain));
			}
			if(guestDto.getLunch()!=null && !("").equalsIgnoreCase(guestDto.getLunch().trim())){
				RmsFoodTypeDomain foodTypeDomain=new RmsFoodTypeDomain();
				foodTypeDomain.setFoodTypeId("2");
				rmsVisitMenuPlaneDomain.setRmsFoodTypeDomain(foodTypeDomain);
				
				rmsVisitMenuPlaneDomain.setFoodLimit(guestDto.getLunch().trim());
				rmsVisitMenuPlaneDomain.setRemaining(guestDto.getLunch().trim());
				stringList.add(guestDao.saveVisitMenuPlane(rmsVisitMenuPlaneDomain));
			}
			if(guestDto.getDinner()!=null && !("").equalsIgnoreCase(guestDto.getDinner().trim())){
				RmsFoodTypeDomain foodTypeDomain=new RmsFoodTypeDomain();
				foodTypeDomain.setFoodTypeId("3");
				rmsVisitMenuPlaneDomain.setRmsFoodTypeDomain(foodTypeDomain);
				
				rmsVisitMenuPlaneDomain.setFoodLimit(guestDto.getDinner().trim());
				rmsVisitMenuPlaneDomain.setRemaining(guestDto.getDinner().trim());
				stringList.add(guestDao.saveVisitMenuPlane(rmsVisitMenuPlaneDomain));
			}
			
			
			return stringList;
		}
	
	public RmsGuestDomain convertGuestDtoToDomain(RmsGuestDto guestDto){
		RmsGuestDomain rmsGuestDomain = new RmsGuestDomain();
		rmsGuestDomain.setGuestId(guestDto.getGuestId());
		rmsGuestDomain.setGuestCode(guestDto.getGuestCode());
		rmsGuestDomain.setGuestName(guestDto.getGuestName());
		rmsGuestDomain.setFatherName(guestDto.getFatherName());
		rmsGuestDomain.setGender(guestDto.getGender());
		rmsGuestDomain.setContactNo(guestDto.getContactNo());
		rmsGuestDomain.setRoomNo(guestDto.getRoomNo());
		rmsGuestDomain.setCnic(guestDto.getCnic());
		rmsGuestDomain.setGuestStatus(guestDto.getGuestStatus());
		rmsGuestDomain.setRegDate(guestDto.getRegDate());
		rmsGuestDomain.setClientID(guestDto.getClientID());
		rmsGuestDomain.setUserId(guestDto.getUserId());
		rmsGuestDomain.setCreatedBy(guestDto.getCreatedBy());
		rmsGuestDomain.setUpdatedBy(guestDto.getUpdatedBy());
		rmsGuestDomain.setCreatedOn(guestDto.getCreatedOn());
		rmsGuestDomain.setUpdatedOn(guestDto.getUpdatedOn());
		return rmsGuestDomain;
	}
	
	public RmsGuestDto convertGuestDomainToDto(RmsGuestDomain guestDomain){
		RmsGuestDto rmsGuestDto = new RmsGuestDto();
		rmsGuestDto.setGuestId(guestDomain.getGuestId());
		rmsGuestDto.setGuestCode(guestDomain.getGuestCode());
		rmsGuestDto.setGuestName(guestDomain.getGuestName());
		rmsGuestDto.setFatherName(guestDomain.getFatherName());
		rmsGuestDto.setGender(guestDomain.getGender());
		rmsGuestDto.setContactNo(guestDomain.getContactNo());
		rmsGuestDto.setRoomNo(guestDomain.getRoomNo());
		rmsGuestDto.setCnic(guestDomain.getCnic());
		rmsGuestDto.setGuestStatus(guestDomain.getGuestStatus());
		rmsGuestDto.setRegDate(guestDomain.getRegDate());
		rmsGuestDto.setClientID(guestDomain.getClientID());
		rmsGuestDto.setUserId(guestDomain.getUserId());
		rmsGuestDto.setCreatedBy(guestDomain.getCreatedBy());
		rmsGuestDto.setUpdatedBy(guestDomain.getUpdatedBy());
		rmsGuestDto.setCreatedOn(guestDomain.getCreatedOn());
		rmsGuestDto.setUpdatedOn(guestDomain.getUpdatedOn());
		if(guestDomain.getGuestId()!=null && !("").equalsIgnoreCase(guestDomain.getGuestId().trim())){
			RmsVisitDomain visitDomain=visitDao.getVisitDomainByQuery("From RmsVisitDomain WHERE rmsGuestDomain.guestId = '"+guestDomain.getGuestId()+"' AND visitStatus = TRUE ");
			rmsGuestDto.setRmsVisitDomain(visitDomain);
			
			if(visitDomain!=null && visitDomain.getVisitId()!=null && !("").equalsIgnoreCase(visitDomain.getVisitId().trim())){
				List<RmsVisitMenuPlaneDomain> visitMPDomainList=visitMenuPlaneDao.getVisitMenuPlaneListByQuery("From RmsVisitMenuPlaneDomain WHERE rmsVisitDomain = '"+visitDomain.getVisitId().trim()+"'");
		        if(visitMPDomainList!=null && visitMPDomainList.size()>0){
		        	for(RmsVisitMenuPlaneDomain visitMPDomain:visitMPDomainList){
		        		RmsFoodTypeDomain foodTypeDomain=visitMPDomain.getRmsFoodTypeDomain();
		        		if(foodTypeDomain.getFoodTypeName().equalsIgnoreCase("Break Fast")){
		        		   rmsGuestDto.setBreakFast(visitMPDomain.getFoodLimit());
		        		   rmsGuestDto.setBreakFastRemainig(visitMPDomain.getRemaining());
		        		}else if(foodTypeDomain.getFoodTypeName().equalsIgnoreCase("Lunch")){
		        			rmsGuestDto.setLunch(visitMPDomain.getFoodLimit());
			        		rmsGuestDto.setLunchRemaining(visitMPDomain.getRemaining());
		        		}else if(foodTypeDomain.getFoodTypeName().equalsIgnoreCase("Dinner")){
		        			rmsGuestDto.setDinner(visitMPDomain.getFoodLimit());
			        		rmsGuestDto.setDinnerRemaining(visitMPDomain.getRemaining());
		        		}
		        	}
		        }		
			}
			
		}
		return rmsGuestDto;
	}
	
	public boolean updateGuest(RmsGuestDto guestDto) {
	    //boolean flag = guestDao.update(guestDto);
	    return true;//flag;
	}
	
	public boolean deleteGuest(String userId) {
		//RmsGuestDto guestDto = guestDao.getUserById(userId);
	   // boolean flag = guestDao.delete(guestDto);
	    return true;//flag;
	  }
	
	public List<RmsGuestDto> getGuestList() {
	    List<RmsGuestDomain> guestDomainList =guestDao.getGuestList();
	    List<RmsGuestDto> rmsGuestDtoList = new ArrayList<RmsGuestDto>();
		for (RmsGuestDomain rmsGuestDomain : guestDomainList) {
			rmsGuestDtoList.add(convertGuestDomainToDto(rmsGuestDomain));
		}
	    return rmsGuestDtoList;
	  }
	
	public RmsGuestDto getGuestById(String userId) {
		//RmsGuestDto guestDto = guestDao.getUserById(userId);
	    //if (guestDto != null)
	   //   return guestDto;
	  //  else
	      return null;
	  }
	public RmsGuestDto getGuestDomainBySearchCretaria(RmsGuestDto guestDto) {
		RmsGuestDto rmsGuestDto=null;
		StringBuffer whereClause=new StringBuffer();
		StringBuffer select=new StringBuffer();
		select.append(" FROM RmsGuestDomain ");
		whereClause.append(" WHERE 1=1 AND guestStatus = 'ACTIVE' ");
		if(guestDto.getGuestId()!=null && !("").equalsIgnoreCase(guestDto.getGuestId().trim())){
			whereClause.append(" AND guestId = '").append(guestDto.getGuestId().trim()).append("' ");
		}
		if(guestDto.getGuestCode()!=null && !("").equalsIgnoreCase(guestDto.getGuestCode().trim())){
			whereClause.append(" AND guestCode = '").append(guestDto.getGuestCode().trim()).append("' ");
		}
		if(guestDto.getGuestName()!=null && !("").equalsIgnoreCase(guestDto.getGuestName().trim())){
			whereClause.append(" AND guestName = '").append(guestDto.getGuestName().trim()).append("' ");
		}
		RmsGuestDomain guestDomain=new RmsGuestDomain();
		  guestDomain=guestDao.getGuestDomainByQuery(select.append(whereClause).toString());
		  if(guestDomain!=null){
			  rmsGuestDto=convertGuestDomainToDto(guestDomain);
		  }
		  return rmsGuestDto;
	  }
	
	
}
