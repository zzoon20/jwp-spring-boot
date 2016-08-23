package core.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import next.dao.UserRepository;
import next.model.User;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	private Logger log = LoggerFactory.getLogger(UserRepositoryTest.class);

	@Autowired
	private UserRepository userRepository;

	@Test
	public void crud() throws Exception {
		userRepository.save(new User("admin", "password", "javajigi", "admin@gmail.com"));
		List<User> users = userRepository.findAll();
		for (User user : users) {
			log.debug("{}", user.toString());
		}
	}
}
