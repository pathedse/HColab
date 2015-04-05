package hedin.stuff.progg.controllers.util;

import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

public class MavUserUtil {

	public void addUser(ModelAndView mav, HttpSession session){
		String username = (String) session.getAttribute("username");
		if(username != null){
			mav.addObject("user", username);
		} else {
			mav.addObject("nouser", true);
		}
	}
}
