package core.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import next.dao.UserRepository;

public class UserRepositoryTest extends IntegrationTest{
	
	@Autowired
	private UserRepository userRepository;

	@Test
	public void crud() {
		
	}

}
