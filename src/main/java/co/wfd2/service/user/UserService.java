package co.wfd2.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import co.wfd2.persistence.service.user.UserPersistenceService;
import co.wfd2.service.entity.user.User;
import co.wfd2.util.Role;

@Service
public class UserService {

	private final UserPersistenceService userPersistenceService;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserService(UserPersistenceService userPersistenceService, BCryptPasswordEncoder bCryptPasswordEncoder){
		this.userPersistenceService = userPersistenceService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	public User getByEmail(String email) {
		return User.map(userPersistenceService.getByEmail(email));
	}

	public User getByUsername(String userName) {
		return User.map(userPersistenceService.getByUsername(userName));
	}

	public User save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		user.setRole(Role.READ_ONLY);
		return User.map(userPersistenceService.save(user.trace()));
	}

	public Boolean isUserExist(String userName) {
		return userPersistenceService.isUserExist(userName);
	}

}
