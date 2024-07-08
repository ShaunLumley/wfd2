package co.wfd2.persistence.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.wfd2.persistence.entity.user.User;
import co.wfd2.repository.user.UserRepository;

@Service
public class UserPersistenceService {

	private final UserRepository repo;

	@Autowired
	public UserPersistenceService(UserRepository repo) {
		this.repo = repo;
	}

	public User get(Integer id) {
		return repo.getById(id);
	}
	
	public User getByUsername(String userName) {
		return repo.findByUserName(userName);
	}
	
	public User getByEmail(String email) {
		return repo.findByEmail(email);
	}
	public List<User> get(){
		return repo.findAll();
	}

	public User save(User user) {
		return repo.save(user);
	}

	public Boolean isUserExist(String userName) {
		return getByUsername(userName) != null;
	}
}
