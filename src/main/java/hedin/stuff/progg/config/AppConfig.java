package hedin.stuff.progg.config;

import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;

@Configuration
public class AppConfig {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Bean
	public Gson gson(){
		return (new GsonBuilder().setPrettyPrinting().create());
	}
	
	public @Bean MongoTemplate mongo() throws UnknownHostException{
		log.info("Loading mongo template");
		MongoClient client = new MongoClient();
		SimpleMongoDbFactory dbFactory = new SimpleMongoDbFactory(client, "hcolab");
		return new MongoTemplate(dbFactory);		
	}
	
	public @Bean InternalResourceViewResolver getInternalResourceViewResolver(){
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
