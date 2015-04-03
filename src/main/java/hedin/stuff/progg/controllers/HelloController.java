package hedin.stuff.progg.controllers;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Controller()
@RequestMapping("/hello")
public class HelloController {
	
	private final Gson gson;
	
	public HelloController(){
		gson = (new GsonBuilder()).setPrettyPrinting().create();
	}
	
	
	@RequestMapping(value="world", method=RequestMethod.GET)
	@ResponseBody
	public String world(){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("Hello","World");
		map.put("Presented by", "Patrik & THE king of Sweden Niclas");
		
		return gson.toJson(map);
	}

}
