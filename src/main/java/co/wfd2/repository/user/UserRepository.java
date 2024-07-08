package co.wfd2.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import co.wfd2.persistence.entity.user.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmail(String email);
    User findByUserName(String userName);
    
}
