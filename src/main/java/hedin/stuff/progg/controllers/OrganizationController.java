package hedin.stuff.progg.controllers;

import hedin.stuff.progg.dao.OrganizationDao;
import hedin.stuff.progg.data.organisation.Organisation;

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
	private final OrganizationDao orgDao;
	
	@Autowired
	public OrganizationController(Gson gson, OrganizationDao orgDao){
		this.gson = gson;
		this.orgDao = orgDao;
	}
	
	@RequestMapping(value="/get")
	@ResponseBody
	public String getOrganization(){
		Organisation o = new Organisation("asjld2", "Biff på tallrik", "Vi lagar god man på tallrik");
		
		return gson.toJson(o);
	}
	
	@RequestMapping(value="/start")
	public ModelAndView organisationStartPage(){
		ModelAndView mav = new ModelAndView("org");
		mav.addObject("org", gson.toJson(new Organisation("23", "BurgarKedjan", "En restaurangkedja med inrikting på hamburgare")));
		return mav;
	}
	
	@RequestMapping(value="/list")
	@ResponseBody
	public String getMenu(@RequestParam String orgname, HttpServletRequest request){
//		String username = getLoggedInUser(request);
		
		return gson.toJson(orgDao.getMenu("12312"));
		
	}
	
	public String getLoggedInUser(HttpServletRequest request){
		String username = (String) request.getSession().getAttribute("username");
		if(username == null || username.isEmpty()){
			throw new RuntimeException("User not logged in");
		}
		return username;
	}
}
