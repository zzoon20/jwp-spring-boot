package core.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import next.dao.UserRepository;
import next.model.User;

public class UserRepositoryTest extends IntegrationTest{
	private Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);
	
	@Autowired
	private UserRepository userRepository;

	@Before
	public void setup(){
		userRepository.save(new User("admin", "password", "javajigi", "admin@gmail.com"));
	}
	
	@Test
	public void crud() throws Exception {
		List<User> users = userRepository.findAll();
		for (User user : users) {
			log.debug("{}", user.toString());
		}
	}

}
