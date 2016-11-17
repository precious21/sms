package com.momentumTech.rms.springmvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.momentumTech.rms.springmvc.dao.RmsCommonDao;
import com.momentumTech.rms.springmvc.dao.RmsFoodConsumptionDao;
import com.momentumTech.rms.springmvc.dao.RmsFoodTypeDao;
import com.momentumTech.rms.springmvc.dao.RmsGuestDao;
import com.momentumTech.rms.springmvc.dao.RmsVisitDao;
import com.momentumTech.rms.springmvc.dao.RmsVisitMenuPlaneDao;
import com.momentumTech.rms.springmvc.domain.RmsFoodConsumptionDomain;
import com.momentumTech.rms.springmvc.domain.RmsFoodTypeDomain;
import com.momentumTech.rms.springmvc.domain.RmsGuestDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitDomain;
import com.momentumTech.rms.springmvc.domain.RmsVisitMenuPlaneDomain;
import com.momentumTech.rms.springmvc.dto.RmsGuestDto;

@Service("foodConsumptionService")
@Transactional
public class RmsFoodConsumptionServiceImp implements RmsFoodConsumptionService {
	@Autowired
	private RmsFoodTypeDao foodTypeDao;
	
	@Autowired
	private RmsVisitMenuPlaneDao visitMenuPlaneDao;
	
	@Autowired
	private RmsFoodConsumptionDao foodConsumptionDao;
	
	@Autowired
	private RmsCommonDao commonDao;
	
	public boolean saveFoodConsumption(RmsGuestDto guestDto) {
		boolean flag=false;
		RmsFoodTypeDomain rmsFoodTypeDomain = foodTypeDao.getFoodTypeDomainByQuery("FROM RmsFoodTypeDomain WHERE foodTypeName = '"+guestDto.getTmpFoodTypeName().trim()+"'");  
        RmsVisitMenuPlaneDomain rmsVMPlaneDomain=visitMenuPlaneDao.getVisitMenuPlaneDomainByQuery("FROM RmsVisitMenuPlaneDomain WHERE 1=1 AND rmsVisitDomain.visitId = '"+guestDto.getTmpVisitId().trim()+"' "
        + " AND  rmsFoodTypeDomain.foodTypeId = '"+rmsFoodTypeDomain.getFoodTypeId().trim()+"'");
        
        RmsFoodConsumptionDomain rmsFoodConsumptionDomain = new RmsFoodConsumptionDomain();
        rmsFoodConsumptionDomain.setRmsVisitMenuPlaneDomain(rmsVMPlaneDomain);
        rmsFoodConsumptionDomain.setCreatedOn(guestDto.getCreatedOn());
        rmsFoodConsumptionDomain.setCreatedBy(guestDto.getCreatedBy());
        rmsFoodConsumptionDomain.setQty(guestDto.getTmpQuantity().trim());
        String id=foodConsumptionDao.save(rmsFoodConsumptionDomain);
        if(id!=null && !("").equalsIgnoreCase(id.trim())){
        	int qty=Integer.parseInt(guestDto.getTmpQuantity().trim());
            int actualQtyRemaining=Integer.parseInt(rmsVMPlaneDomain.getRemaining().trim());
            int updateRemaining=actualQtyRemaining-qty;
        	String query="UPDATE RmsVisitMenuPlaneDomain set remaining = '"+updateRemaining+"'  "
        		   + " WHERE visitMenuPlaneId = '"+rmsVMPlaneDomain.getVisitMenuPlaneId()+"' "
        		   	+ " AND rmsFoodTypeDomain.foodTypeId = '"+rmsFoodTypeDomain.getFoodTypeId()+"' ";
        	flag=commonDao.updateByQuery(query);
        }
	    return flag;
	}
	
}
