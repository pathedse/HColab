package hedin.stuff.progg.controllers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

@Controller
@RequestMapping(value="/user")
public class UserController {

	public final Gson gson;
	Logger log = LoggerFactory.getLogger(this.getClass());
		
	@Autowired
	public UserController(Gson gson){
		this.gson = gson;
	}
	
	private class LoginCredentials{
		String username;
		String password;
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	@ResponseBody
	public String login(HttpServletRequest request, HttpServletResponse response, @RequestBody(required=true) LoginCredentials login){
		HashMap<String,String> map = new HashMap<>();
		if(login.password.equals("kalle")){
			map.put("status","success");
			request.getSession().setAttribute("username", login.username);
		} else {
			map.put("status","failed password");
		}
		return gson.toJson(map);	
	}
	
	
	@RequestMapping(value="whoami")
	@ResponseBody
	public String whoAmI(HttpServletRequest request, HttpServletResponse response){
		HashMap<String,String> map = new HashMap<>();
		String username = (String) request.getSession().getAttribute("username");
		if( username == null){
			map.put("status", "not logged in");
		} else {
			map.put("status", "logged in");
			map.put("username", username);
		}
		return gson.toJson(map);
	}
	
}
