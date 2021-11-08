package springjenkins;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringjenkinsApplication {

	@PostConstruct
	public void intt() {
		logger.info("Application started...");
		
	}
	public static final Logger logger =LoggerFactory.getLogger(SpringjenkinsApplication.class);
	public static void main(String[] args) {
		
		SpringApplication.run(SpringjenkinsApplication.class, args);
		
	}
}
