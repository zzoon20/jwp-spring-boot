package next.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import next.model.User;

public interface UserRepository extends JpaRepository<User, String> {

}
