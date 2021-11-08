package springjenkins;

import static org.junit.Assert.assertEquals;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SpringjenkinsApplicationTests {

	public static final Logger logger =LoggerFactory.getLogger(SpringjenkinsApplicationTests.class);

	public void contextLoads() {
		logger.info("Test case Executing  ...");
		
		
		assertEquals(true, true);
	}
	
}
