package hedin.stuff.progg.controllers;

import java.util.List;

import hedin.stuff.progg.dao.EnterpriseDao;
import hedin.stuff.progg.data.organisation.BusinessUnit;
import hedin.stuff.progg.data.organisation.Enterprise;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

@Controller
@RequestMapping(value="org")
public class OrganizationController {

	private final Gson gson;
	private final EnterpriseDao orgDao;
	
	@Autowired
	public OrganizationController(Gson gson, EnterpriseDao orgDao){
		this.gson = gson;
		this.orgDao = orgDao;
	}
	
	@RequestMapping(value="/get")
	@ResponseBody
	public String getOrganization(){
		Enterprise o = orgDao.getEnterprise("1");
		List<BusinessUnit> units = orgDao.getBusinesUnitsForEnterprise(o.getId());
		o.addBusinessUnits(units);
		return gson.toJson(o);
	}
	
	@RequestMapping(value="/start")
	public ModelAndView organisationStartPage(){
		ModelAndView mav = new ModelAndView("org");
		Enterprise o = orgDao.getEnterprise("1");
		List<BusinessUnit> units = orgDao.getBusinesUnitsForEnterprise(o.getId());
		o.addBusinessUnits(units);
		mav.addObject("org", gson.toJson(o));
		return mav;
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public String getMenu(@RequestParam String orgname, HttpServletRequest request){
//		String username = getLoggedInUser(request);
		return "";
		//return gson.toJson(orgDao.getMenu("12312"));		
	}
	
	public String getLoggedInUser(HttpServletRequest request){
		String username = (String) request.getSession().getAttribute("username");
		if(username == null || username.isEmpty()){
			throw new RuntimeException("User not logged in");
		}
		return username;
	}
}
