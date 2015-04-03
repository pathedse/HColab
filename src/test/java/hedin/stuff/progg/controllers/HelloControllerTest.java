package hedin.stuff.progg.controllers;

import java.util.HashMap;

import junit.framework.TestCase;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HelloControllerTest extends TestCase {

	private final Gson gson;
	
	public HelloControllerTest(){
		super();
		gson = (new GsonBuilder()).setPrettyPrinting().create();
	}
	
	public void testWorld(){
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("Hello","World");
		map.put("Presented by", "Patrik, Niclas And XXXXXXXX");
		String expectedResult = gson.toJson(map);
		HelloController controller = new HelloController();
		String s = controller.world();
		 
		assertEquals(expectedResult, s);
	}
}
