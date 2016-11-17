package com.momentumTech.rms.springmvc.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.momentumTech.rms.springmvc.domain.Employee;
import com.momentumTech.rms.springmvc.domain.RmsUserDomain;
import com.momentumTech.rms.springmvc.dto.RmsGuestDto;
import com.momentumTech.rms.springmvc.dto.RmsUserDto;
import com.momentumTech.rms.springmvc.service.EmployeeService;
import com.momentumTech.rms.springmvc.service.RmsFoodConsumptionService;
import com.momentumTech.rms.springmvc.service.RmsGuestService;
import com.momentumTech.rms.springmvc.service.RmsUserService;
import com.momentumTech.rms.springmvc.utility.CommonUtility;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
@RequestMapping("/")
public class AppController {

	@Autowired
	EmployeeService service;
	
	@Autowired
	MessageSource messageSource;

	@Autowired
	RmsUserService userService;
	
	@Autowired
	RmsGuestService guestService;
	
	@Autowired
	RmsFoodConsumptionService foodConsumptionService;
	
	/*
	 * This method will list all existing employees.
	 */
	@RequestMapping(value = { "/","/login", "/list" }, method = RequestMethod.GET)
	public String getLoginForm(ModelMap model) {
		RmsUserDto userDto=new RmsUserDto();
		model.addAttribute("userDto", userDto);
		return "user/index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
		    public String executeLogin(HttpServletRequest request, HttpServletResponse response , @ModelAttribute("userDto")RmsUserDto userDto , BindingResult resultBind)
		    {
		        String result= "user/index";
		        try
		        {
		            RmsUserDomain userDomain = userService.validateUser(userDto);
		            if(userDomain!=null && userDomain.getUserId()!=null)
		            {
		                System.out.println("User Login Successful");
		                request.setAttribute("loggedInUser", userDomain);
		                request.getSession().setAttribute("user", userDomain);
		                //ActionContext.getContext().getSession().put("user", userDomain);
		               
		                result= "user/dashBoard";
		            }
		            else
		            {
		            	System.out.println("Crediential Issue");
		            	FieldError userName =new FieldError("userDto","username",messageSource.getMessage("user.or.pass.incorrect", new String[]{userDto.getUsername()}, Locale.getDefault()));
		    		    resultBind.addError(userName);
		    			return result;
		            }
		        }
		        catch(Exception e)
		        {
		            e.printStackTrace();
		        }
		        return result;
		    }
	
	@RequestMapping(value = {"/redirect"}, method = RequestMethod.GET)
	 public String dashboard(HttpServletRequest request) {
	  RmsUserDomain userDomain =(RmsUserDomain) request.getSession().getAttribute("user");
	  return "user/dashBoard";
	 }
	
	/*
	@RequestMapping(value = { "/", "/list" }, method = RequestMethod.GET)
	public String listEmployees(ModelMap model) {
		
    List<Employee> employees = service.findAllEmployees();
	model.addAttribute("employees", employees);
	return "allemployees";
	}
	*/

	/*
	 * This method will provide the medium to add a new employee.
	 */
	@RequestMapping(value = { "/new" }, method = RequestMethod.GET)
	public String newEmployee(ModelMap model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		model.addAttribute("edit", false);
		return "registration";
	}

	@RequestMapping(value = { "/addGuest"}, method = RequestMethod.GET)
	public String getGuestPage(ModelMap model) {
		Date d=new Date();
		String year=d.getYear()+"";
		RmsGuestDto guestDto=new RmsGuestDto();
		guestDto.setGuestCode(year+"-"+CommonUtility.generateRandomNumber(5));
		model.addAttribute("guestDto", guestDto);
		return "user/addGuest";
	}
	
	@RequestMapping(value = { "/addGuest" }, method = RequestMethod.POST)
	public String saveGuest(HttpServletRequest request,@Valid RmsGuestDto guestDto,
			ModelMap model) {
		RmsUserDomain userDomain=(RmsUserDomain)request.getSession().getAttribute("user");
		//RmsUserDomain userDomain=(RmsUserDomain)ActionContext.getContext().getSession().get("user");
		if(userDomain!=null && userDomain.getUserId()!=null){
			//model.addAttribute("userDto", new RmsUserDto());
			//return "user/index";
			guestDto.setCreatedBy(userDomain.getUserId());
			guestDto.setUserId(userDomain.getUserId());
		}
		Date now = new Date();
		guestDto.setCreatedOn(now);
		guestDto.setRegDate(now);
		guestDto.setGuestStatus("ACTIVE");
		guestService.saveGuest(guestDto);
		model.addAttribute("saved", "Guest " + guestDto.getGuestName() + " registered successfully");
		model.addAttribute("guestDto", guestDto);
		return "user/addGuest";
	}
	
	@RequestMapping(value = { "/getGuestList", "/list" }, method = RequestMethod.GET)
	public String getGuestList(ModelMap model) {
		List<RmsGuestDto> guestDtoList=guestService.getGuestList();
		model.addAttribute("guestDtoList", guestDtoList);
		return "user/guest";
	}
	
	@RequestMapping(value = { "/getGuestTransaction"}, method = RequestMethod.GET)
	public String getGuestTransaction(ModelMap model) {
		RmsGuestDto guestDto=new RmsGuestDto();
		model.addAttribute("guestDto", guestDto);
		return "user/guestTransaction";
	}
	
	@RequestMapping(value = { "/searchGuestForTransaction", "/list" }, method = RequestMethod.GET)
	public @ResponseBody RmsGuestDto searchGuestListForTrans(ModelMap model , @ModelAttribute("guestDto")RmsGuestDto guestDto ) {
		RmsGuestDto guestDtoSearched=new RmsGuestDto();
		guestDtoSearched=guestService.getGuestDomainBySearchCretaria(guestDto);
		if(guestDtoSearched!=null){
		guestDtoSearched.setTmpCheckIn(CommonUtility.convertDateToString(guestDtoSearched.getRmsVisitDomain().getCheckIn()));
		guestDtoSearched.setTmpCheckOut(CommonUtility.convertDateToString(guestDtoSearched.getRmsVisitDomain().getCheckOut()));
		}
		return guestDtoSearched;
	}
	
	@RequestMapping(value = { "/saveGuestTransaction" }, method = RequestMethod.POST)
	public String saveGuestTransaction(HttpServletRequest request,@Valid RmsGuestDto guestDto,
			ModelMap model) {
		RmsUserDomain userDomain=(RmsUserDomain)request.getSession().getAttribute("user");
		if(userDomain!=null && userDomain.getUserId()!=null){
			guestDto.setCreatedBy(userDomain.getUserId());
			guestDto.setUserId(userDomain.getUserId());
		}
		Date now = new Date();
		guestDto.setCreatedOn(now);
		boolean flag=foodConsumptionService.saveFoodConsumption(guestDto);
		model.addAttribute("guestDto", guestDto);
		return "user/guestTransaction";
	}
	
	/*
	@RequestMapping(value = { "/new" }, method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model) {

		if (result.hasErrors()) {
			return "registration";
		}

		/*
		 * Preferred way to achieve uniqueness of field [ssn] should be implementing custom @Unique annotation 
		 * and applying it on field [ssn] of Model class [Employee].
		 * 
		 * Below mentioned peace of code [if block] is to demonstrate that you can fill custom errors outside the validation
		 * framework as well while still using internationalized messages.
		 * 
		 
		if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}
		
		service.saveEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName() + " registered successfully");
		return "success";
	} */


	/*
	 * This method will provide the medium to update an existing employee.
	 */
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.GET)
	public String editEmployee(@PathVariable String ssn, ModelMap model) {
		Employee employee = service.findEmployeeBySsn(ssn);
		model.addAttribute("employee", employee);
		model.addAttribute("edit", true);
		return "registration";
	}
	
	/*
	 * This method will be called on form submission, handling POST request for
	 * updating employee in database. It also validates the user input
	 */
	@RequestMapping(value = { "/edit-{ssn}-employee" }, method = RequestMethod.POST)
	public String updateEmployee(@Valid Employee employee, BindingResult result,
			ModelMap model, @PathVariable String ssn) {

		if (result.hasErrors()) {
			return "registration";
		}

		if(!service.isEmployeeSsnUnique(employee.getId(), employee.getSsn())){
			FieldError ssnError =new FieldError("employee","ssn",messageSource.getMessage("non.unique.ssn", new String[]{employee.getSsn()}, Locale.getDefault()));
		    result.addError(ssnError);
			return "registration";
		}

		service.updateEmployee(employee);

		model.addAttribute("success", "Employee " + employee.getName()	+ " updated successfully");
		return "success";
	}

	
	/*
	 * This method will delete an employee by it's SSN value.
	 */
	@RequestMapping(value = { "/delete-{ssn}-employee" }, method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable String ssn) {
		service.deleteEmployeeBySsn(ssn);
		return "redirect:/list";
	}

}
