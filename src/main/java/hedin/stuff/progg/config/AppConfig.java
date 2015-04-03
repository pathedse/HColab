package hedin.stuff.progg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Configuration
public class AppConfig {

	
	@Bean
	public Gson gson(){
		return (new GsonBuilder().setPrettyPrinting().create());
	}
}
